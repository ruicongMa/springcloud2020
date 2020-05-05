package com.mark.facade;

/**
 * @author Mark
 * @date 2020/5/5 14:58
 */
public class GiftFacadeService {
    private QualifyService qualifyService = new QualifyService();
    private PaymentService paymentService = new PaymentService();
    private ShippingService shippingService = new ShippingService();

    //兑换
    public void exchange(GiftInfo giftInfo) {
        if (qualifyService.isAvailable(giftInfo)) {
            //资格校验通过
            if (paymentService.pay(giftInfo)) {
                //如果支付积分成功
                String shippingOrderNo = shippingService.delivery(giftInfo);
                System.out.println("物流系统下单成功，订单号是：" + shippingOrderNo);
            }
        }
    }
}
