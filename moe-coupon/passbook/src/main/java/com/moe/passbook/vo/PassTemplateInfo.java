package com.moe.passbook.vo;

import com.moe.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>优惠券模板信息</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplateInfo {

    /**
     * 优惠券模板
     */
    private PassTemplate passTemplate;

    /**
     * 优惠券对应的商户
     */
    private Merchants merchants;
}
