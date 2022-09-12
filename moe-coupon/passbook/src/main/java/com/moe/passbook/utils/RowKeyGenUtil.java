package com.moe.passbook.utils;

import com.moe.passbook.vo.Feedback;
import com.moe.passbook.vo.GainPassTemplateRequest;
import com.moe.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * <h1>RowKey 生成器工具类</h1>
 */
@Slf4j
public class RowKeyGenUtil {

    /**
     * <h2>根据提供的 PassTemplate 对象生成 RowKey</h2>
     *
     * @param passTemplate {@link PassTemplate}
     * @return String RowKey
     */
    public static String genPassTemplateRowKey(PassTemplate passTemplate) {

        String passInfo = String.valueOf(passTemplate.getId()) + "_" + passTemplate.getTitle();
        String rowKey = DigestUtils.md5Hex(passInfo); // 分散rowkey，尽量让数据分散开在不同的机器上，避免相似的数据存在一台机器上
        log.info("GenPassTemplateRowKey: {}, {}", passInfo, rowKey);

        return rowKey;
    }

    /**
     * <h2>根据提供的领取优惠券请求生成 RowKey, 只可以在领取优惠券的时候使用</h2>
     * Pass RowKey = reversed(userId) + inverse(timestamp) + PassTemplate RowKey
     *
     * @param request {@link GainPassTemplateRequest}
     * @return String RowKey
     */
    public static String genPassRowKey(GainPassTemplateRequest request) {

        return new StringBuilder(String.valueOf(request.getUserId())).reverse().toString()
                + (Long.MAX_VALUE - System.currentTimeMillis())
                + genPassTemplateRowKey(request.getPassTemplate());
    }

    /**
     * <h2>根据 Feedback 构造 RowKey</h2>
     *
     * @param feedback {@link Feedback}
     * @return String RowKey
     */
    public static String genFeedbackRowKey(Feedback feedback) {
        // 用户id前边相同，后边不同，所以不反转的话，就会存储在同一台机器上
        // 首先把用户id随机分散到不同的机器上，然后相同用户id的feedback，后评论的显示在最上边（根据时间降序显示，肯定是显示最新评论）
        return new StringBuilder(String.valueOf(feedback.getUserId())).reverse().toString() +
                (Long.MAX_VALUE - System.currentTimeMillis());
    }
}
