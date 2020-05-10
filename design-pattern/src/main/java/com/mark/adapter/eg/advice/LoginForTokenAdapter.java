package com.mark.adapter.eg.advice;

import com.mark.adapter.eg.ResultMsg;

/**
 * @author Mark
 * @date 2020/5/10 16:29
 */
public class LoginForTokenAdapter extends AbstractAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTokenAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegist(id, null);
    }
}
