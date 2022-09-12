package com.moe.coupon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>商品信息</h1>
 *
 * @author Mark
 * @date 2022/5/23 16:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfo {

    /**
     * 商品类型：{@link com.moe.coupon.constant.GoodsType}
     */
    private Integer type;

    /**
     * 商品价格
     */
    private Integer price;

    /**
     * 商品数量
     */
    private Integer count;

    // TODO 名称，使用信息
}
