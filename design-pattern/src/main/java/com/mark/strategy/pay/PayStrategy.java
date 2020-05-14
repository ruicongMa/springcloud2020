package com.mark.strategy.pay;

/**
 * @author Mark
 * @date 2020/5/14 11:47
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 支付策略管理
 */
public class PayStrategy {

    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JdPay";
    public static final String WECHAT_PAY = "WeChatPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static final Map<String, Payment> STRATEGY = new HashMap<>();

    static {
        STRATEGY.put(ALI_PAY, new AliPay());
        STRATEGY.put(JD_PAY, new JDPay());
        STRATEGY.put(WECHAT_PAY, new WeChatPay());
        STRATEGY.put(UNION_PAY, new UnionPay());
    }

    public static Payment get(String payKey) {
        if (!STRATEGY.containsKey(payKey)) {
            return STRATEGY.get(DEFAULT_PAY);
        }
        return STRATEGY.get(payKey);
    }
}
