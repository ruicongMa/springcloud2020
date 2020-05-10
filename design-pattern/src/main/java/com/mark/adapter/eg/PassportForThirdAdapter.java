package com.mark.adapter.eg;

/**
 * @author Mark
 * @date 2020/5/10 15:51
 */
public class PassportForThirdAdapter extends PassportService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String openId) {
        return loginForRegist(openId, null);
    }

    @Override
    public ResultMsg loginForWeChat(String openId) {
        return loginForRegist(openId, null);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return loginForRegist(token, null);
    }

    @Override
    public ResultMsg loginForTelphone(String phone, String code) {
        return loginForRegist(phone, code);
    }

    private ResultMsg loginForRegist(String username, String password) {
        if (null == password || "".equals(password)) {
            password = "THIRD_EMPTY";
        }
        super.regist(username, password);
        return super.login(username, password);

    }
}
