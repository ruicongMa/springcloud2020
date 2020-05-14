package com.mark.strategy.eg;


/**
 * @author Mark
 * @date 2020/5/14 11:15
 */
public class Test {

    public static void main(String[] args) {
        PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
        PromotionActivity activity1111 = new PromotionActivity(new CashBackStrategy());

        activity618.execute();
        activity1111.execute();
    }

    @org.junit.Test
    public void test() {
        PromotionActivity activity = null;
        String promotionKey = "COUPON";

        if ("COUPON".equalsIgnoreCase(promotionKey)) {
            activity = new PromotionActivity(new CouponStrategy());
        } else if ("CASHBACK".equalsIgnoreCase(promotionKey)) {
            activity = new PromotionActivity(new CashBackStrategy());
        }
        //......
        activity.execute();
    }
}
