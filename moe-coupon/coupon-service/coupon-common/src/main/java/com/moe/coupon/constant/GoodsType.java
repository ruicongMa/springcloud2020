package com.moe.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * <h1>商品类型枚举</h1>
 *
 * @author Mark
 * @date 2022/5/23 16:20
 */
@Getter
@AllArgsConstructor
public enum GoodsType {

    WENYU("文娱", 1),
    SHENGXIAN("生鲜", 2),
    JIAJU("家居", 3),
    OTHER("其他", 4),
    ALL("全品类", 5);

    /**
     * 商品类型描述
     */
    private String description;

    /**
     * 商品类型编码
     */
    private Integer code;

    public static GoodsType of(Integer code) {
        Objects.requireNonNull(code, "商品类型编码不能为空！");
        return Stream.of(values())
                .filter(item -> item.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " not exist!"));
    }
}
