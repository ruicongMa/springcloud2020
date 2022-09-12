package com.moe.passbook.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 优惠券模板背景颜色
 */
@Getter
@AllArgsConstructor
public enum TemplateColor {

    RED(1, "红色"),
    GREEN(2, "绿色"),
    BLUE(3, "蓝色");

    /**
     * 颜色代码
     */
    private Integer code;

    /**
     * 颜色描述
     */
    private String color;

}
