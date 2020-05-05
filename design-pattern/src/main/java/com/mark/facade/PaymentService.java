package com.mark.facade;

/**
 * @author Mark
 * @date 2020/5/5 14:53
 */
public class PaymentService {

    public boolean pay(GiftInfo giftInfo) {
        //扣减积分
        System.out.println("支付" + giftInfo.getName() + "积分成功");
        return true;
    }
}
