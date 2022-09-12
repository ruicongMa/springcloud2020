package com.mark.facade;

/**
 * @author Mark
 * @date 2020/5/5 15:02
 */
public class EgTest {

    public static void main(String[] args) {
        GiftInfo giftInfo = new GiftInfo("《DDD是什么鬼？》");
        GiftFacadeService facadeService = new GiftFacadeService();
        facadeService.exchange(giftInfo);
    }
}
