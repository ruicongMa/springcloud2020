package com.mark.facade;

/**
 * @author Mark
 * @date 2020/5/5 15:02
 */
public class EgTest {

    public static void main(String[] args) {
        GiftInfo giftInfo = new GiftInfo("《Spring5核心原理》");
        GiftFacadeService facadeService = new GiftFacadeService();
        facadeService.exchange(giftInfo);
    }
}
