package com.moe.passbook.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <h2>错误码枚举定义</h2>
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    SUCCESS(0, ""),
    DUPLICATE_NAME(1, "商户名称重复"),
    EMPTY_LOGO(2, "商户 logo 为空"),
    EMPTY_BUSINESS_LICENSE(3, "商户营业执照为空"),
    ERROR_PHONE(4, "商户联系电话错误"),
    EMPTY_ADDRESS(5, "商户地址为空"),
    MERCHANTS_NOT_EXIST(6, "商户不存在");

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误描述
     */
    private String desc;

}
