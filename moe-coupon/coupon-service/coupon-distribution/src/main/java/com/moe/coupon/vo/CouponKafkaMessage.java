package com.moe.coupon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <h1>优惠券 kafka 消息对象定义</h1>
 *
 * @author Mark
 * @date 2022/5/23 15:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponKafkaMessage {

    /**
     * 优惠券状态
     */
    private Integer status;

    /**
     * Coupon 主键
     */
    private List<Integer> ids;
}
