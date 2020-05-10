package com.mark.adapter.eg;

/**
 * @author Mark
 * @date 2020/5/10 15:41
 */
public class PassportService {

    /**
     * 注册方法
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password) {
        return new ResultMsg(200, "注册成功", new Member());
    }

    public ResultMsg login(String username, String password) {
        return null;
    }
}
