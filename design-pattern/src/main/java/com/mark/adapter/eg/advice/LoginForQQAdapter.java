package com.mark.adapter.eg.advice;

import com.mark.adapter.eg.ResultMsg;

/**
 * @author Mark
 * @date 2020/5/10 16:08
 */
public class LoginForQQAdapter extends AbstractAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        if (!support(adapter)) {
            return null;
        }
        //accessToken
        //time
        return super.loginForRegist(id, null);
    }
}
