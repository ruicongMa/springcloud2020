package com.mark.facade;

/**
 * @author Mark
 * @date 2020/5/5 14:55
 */
public class ShippingService {
    //发货
    public String delivery(GiftInfo giftInfo) {
        //物流系统的对接逻辑
        System.out.println(giftInfo.getName() + "进入物流系统");
        return "666";
    }
}
