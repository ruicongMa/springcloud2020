package com.moe.passbook.service.impl;

import com.moe.passbook.constant.Constants;
import com.moe.passbook.dao.MerchantsDao;
import com.moe.passbook.entity.Merchants;
import com.moe.passbook.mapper.PassTemplateRowMapper;
import com.moe.passbook.service.IInventoryService;
import com.moe.passbook.service.IUserPassService;
import com.moe.passbook.utils.RowKeyGenUtil;
import com.moe.passbook.vo.*;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.LongComparator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

/**
 * <h1>获取库存信息, 只返回用户没有领取的</h1>
 * Created by Qinyi.
 */
@Slf4j
@Service
public class InventoryServiceImpl implements IInventoryService {

    /**
     * Hbase 客户端
     */
    private final HbaseTemplate hbaseTemplate;

    /**
     * Merchants Dao 接口
     */
    private final MerchantsDao merchantsDao;

    private final IUserPassService userPassService;

    @Autowired
    public InventoryServiceImpl(HbaseTemplate hbaseTemplate,
                                MerchantsDao merchantsDao,
                                IUserPassService userPassService) {
        this.hbaseTemplate = hbaseTemplate;
        this.merchantsDao = merchantsDao;
        this.userPassService = userPassService;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Response getInventoryInfo(Long userId) throws Exception {

        Response allUserPass = userPassService.getUserAllPassInfo(userId);
        List<PassInfo> passInfos = (List<PassInfo>) allUserPass.getData();

        List<PassTemplate> excludeObject = passInfos.stream().map(PassInfo::getPassTemplate)
                .collect(Collectors.toList());
        List<String> excludeIds = new ArrayList<>();

        excludeObject.forEach(e -> excludeIds.add(
                RowKeyGenUtil.genPassTemplateRowKey(e)));

        return new Response(new InventoryResponse(userId,
                buildPassTemplateInfo(getAvailablePassTemplate(excludeIds))));
    }

    /**
     * <h2>获取系统中可用的优惠券</h2>
     *
     * @param excludeIds 需要排除的优惠券 ids
     * @return {@link PassTemplate}
     */
    // TODO 如果系统中优惠券很多，需要考虑分页，而不是一次load所有优惠券
    private List<PassTemplate> getAvailablePassTemplate(List<String> excludeIds) {

        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ONE);

        // MUST_PASS_ONE 两个Filter是or的关系，满足其中一个即可
        filterList.addFilter(
                new SingleColumnValueFilter(
                        Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                        Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                        CompareFilter.CompareOp.GREATER,
                        new LongComparator(0L)
                )
        );
        filterList.addFilter(
                new SingleColumnValueFilter(
                        Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                        Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                        CompareFilter.CompareOp.EQUAL,
                        Bytes.toBytes("-1")
                )
        );

        Scan scan = new Scan();
        scan.setFilter(filterList);

        List<PassTemplate> validTemplates = hbaseTemplate.find(
                Constants.PassTemplateTable.TABLE_NAME, scan, new PassTemplateRowMapper());
        List<PassTemplate> availablePassTemplates = new ArrayList<>();

        Date cur = new Date();

        for (PassTemplate validTemplate : validTemplates) {

            if (excludeIds.contains(RowKeyGenUtil.genPassTemplateRowKey(validTemplate))) {
                continue;
            }

            if (cur.getTime() >= validTemplate.getStart().getTime()
                    && cur.getTime() <= validTemplate.getEnd().getTime()) {
                availablePassTemplates.add(validTemplate);
            }
        }

        return availablePassTemplates;
    }

    /**
     * <h2>构造优惠券的信息</h2>
     *
     * @param passTemplates {@link PassTemplate}
     * @return {@link PassTemplateInfo}
     */
    private List<PassTemplateInfo> buildPassTemplateInfo(List<PassTemplate> passTemplates) {

        Map<Integer, Merchants> merchantsMap = new HashMap<>();
        List<Integer> merchantsIds = passTemplates.stream().map(
                PassTemplate::getId
        ).collect(Collectors.toList());
        List<Merchants> merchants = merchantsDao.findByIdIn(merchantsIds);
        merchants.forEach(m -> merchantsMap.put(m.getId(), m));

        List<PassTemplateInfo> result = new ArrayList<>(passTemplates.size());

        for (PassTemplate passTemplate : passTemplates) {

            Merchants mc = merchantsMap.getOrDefault(passTemplate.getId(),
                    null);
            if (null == mc) {
                log.error("Merchants Error: {}", passTemplate.getId());
                continue;
            }

            result.add(new PassTemplateInfo(passTemplate, mc));
        }

        return result;
    }
}
