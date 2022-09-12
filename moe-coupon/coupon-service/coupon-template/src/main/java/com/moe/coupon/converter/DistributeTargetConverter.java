package com.moe.coupon.converter;

import com.moe.coupon.constant.DistributeTarget;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * <h1>分发目标枚举属性转换器</h1>
 *
 * @author Mark
 * @date 2022/5/23 15:27
 */
@Converter
public class DistributeTargetConverter
        implements AttributeConverter<DistributeTarget, Integer> {

    @Override
    public Integer convertToDatabaseColumn(DistributeTarget distributeTarget) {
        return distributeTarget.getCode();
    }

    @Override
    public DistributeTarget convertToEntityAttribute(Integer code) {
        return DistributeTarget.of(code);
    }
}