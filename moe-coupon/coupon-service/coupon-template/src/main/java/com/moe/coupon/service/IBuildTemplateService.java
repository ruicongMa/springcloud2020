package com.moe.coupon.service;

import com.moe.coupon.entity.CouponTemplate;
import com.moe.coupon.exception.CouponException;
import com.moe.coupon.vo.TemplateRequest;

/**
 * <h1>构建优惠券模板接口定义</h1>
 *
 * @author Mark
 * @date 2022/5/23 15:31
 */
public interface IBuildTemplateService {

    /**
     * <h2>创建优惠券模板</h2>
     *
     * @param request {@link TemplateRequest} 模板信息请求对象
     * @return {@link CouponTemplate} 优惠券模板实体
     */
    CouponTemplate buildTemplate(TemplateRequest request)
            throws CouponException;
}
