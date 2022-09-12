package com.moe.passbook.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <h1>评论类型枚举</h1>
 */
@Getter
@AllArgsConstructor
public enum FeedbackType {

    PASS("pass", "针对优惠券的评论"),
    APP("app", "针对卡包 App 的评论");

    /**
     * 评论类型编码
     */
    private String code;

    /**
     * 评论类型描述
     */
    private String desc;

}
