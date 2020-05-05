package com.mark.proxy.eg;

import lombok.Data;

/**
 * @author Mark
 * @date 2020/5/4 11:54
 */
@Data
public class Order {
    private Object orderInfo;
    private Long createTime;
    private String id;
}
