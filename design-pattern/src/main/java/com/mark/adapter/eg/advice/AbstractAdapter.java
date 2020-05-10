package com.mark.adapter.eg.advice;

import com.mark.adapter.eg.PassportService;
import com.mark.adapter.eg.ResultMsg;

/**
 * @author Mark
 * @date 2020/5/10 16:09
 */
public abstract class AbstractAdapter extends PassportService implements ILoginAdatper {

    public ResultMsg loginForRegist(String username, String password) {
        if (null == password || "".equals(password)) {
            password = "THIRD_EMPTY";
        }
        super.regist(username, password);
        return super.login(username, password);
    }
}
