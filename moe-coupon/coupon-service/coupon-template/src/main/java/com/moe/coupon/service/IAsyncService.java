package com.moe.coupon.service;

import com.moe.coupon.entity.CouponTemplate;

/**
 * <h1>异步服务接口定义</h1>
 *
 * @author Mark
 * @date 2022/5/23 15:30
 */
public interface IAsyncService {

    /**
     * <h2>根据模板异步的创建优惠券码</h2>
     *
     * @param template {@link CouponTemplate} 优惠券模板实体
     */
    void asyncConstructCouponByTemplate(CouponTemplate template);
}
