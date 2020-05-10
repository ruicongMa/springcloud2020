package com.mark.adapter.eg.advice;

import com.mark.adapter.eg.IPassportForThird;
import com.mark.adapter.eg.ResultMsg;

/**
 * @author Mark
 * @date 2020/5/10 16:35
 */
public class PassportForThirdAdapter implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String openId) {
        return processLogin(openId, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWeChat(String openId) {
        return processLogin(openId, LoginForWeChatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelphone(String phone, String code) {
        return processLogin(phone, LoginForTelAdapter.class);
    }

    private ResultMsg processLogin(String id, Class<? extends ILoginAdatper> clazz) {
        try {
            ILoginAdatper adatper = clazz.newInstance();
            if (adatper.support(adatper)) {
                return adatper.login(id, adatper);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
