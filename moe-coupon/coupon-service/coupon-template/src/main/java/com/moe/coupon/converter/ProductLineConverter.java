package com.moe.coupon.converter;

import com.moe.coupon.constant.ProductLine;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * <h1>产品线枚举属性转换器</h1>
 *
 * @author Mark
 * @date 2022/5/23 15:27
 */
@Converter
public class ProductLineConverter
        implements AttributeConverter<ProductLine, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductLine productLine) {
        return productLine.getCode();
    }

    @Override
    public ProductLine convertToEntityAttribute(Integer code) {
        return ProductLine.of(code);
    }
}
