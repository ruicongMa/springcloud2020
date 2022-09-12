package com.moe.coupon.dao;

import com.moe.coupon.constant.CouponStatus;
import com.moe.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <h1>Coupon Dao 接口定义</h1>
 *
 * @author Mark
 * @date 2022/5/23 15:49
 */
public interface CouponDao extends JpaRepository<Coupon, Integer> {

    /**
     * <h2>根据 userId + 状态寻找优惠券记录</h2>
     * where userId = ... and status = ...
     */
    List<Coupon> findAllByUserIdAndStatus(Long userId, CouponStatus status);

}
