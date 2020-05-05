package com.mark.facade;

/**
 * @author Mark
 * @date 2020/5/5 14:50
 */
public class QualifyService {

    public boolean isAvailable(GiftInfo giftInfo) {
        System.out.println("校验" + giftInfo.getName() + "积分资格通过，库存通过");
        return true;
    }
}
