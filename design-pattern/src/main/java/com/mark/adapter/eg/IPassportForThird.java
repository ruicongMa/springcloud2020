package com.mark.adapter.eg;

/**
 * @author Mark
 * @date 2020/5/10 15:47
 */
public interface IPassportForThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWeChat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelphone(String phone, String code);
}
