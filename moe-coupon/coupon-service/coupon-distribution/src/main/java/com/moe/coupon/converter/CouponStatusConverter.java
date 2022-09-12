package com.moe.coupon.converter;

import com.moe.coupon.constant.CouponStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * <h1>优惠券状态枚举属性转换器</h1>
 *
 * @author Mark
 * @date 2022/5/23 15:48
 */
@Converter
public class CouponStatusConverter implements
        AttributeConverter<CouponStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CouponStatus status) {
        return status.getCode();
    }

    @Override
    public CouponStatus convertToEntityAttribute(Integer code) {
        return CouponStatus.of(code);
    }
}

