package com.moe.passbook.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <h1>优惠券的状态</h1>
 */
@Getter
@AllArgsConstructor
public enum PassStatus {

    UNUSED(1, "未被使用的"),
    USED(2, "已经使用的"),
    ALL(3, "全部领取的");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态描述
     */
    private String desc;
}
