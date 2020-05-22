package com.mark.state.eg;

/**
 * @author Mark
 * @date 2020/5/22 11:16
 */
public class UnLoginState extends UserState {
    @Override
    public void favorite() {
        this.switch2Login();
        this.context.getState().favorite();
    }

    @Override
    public void comment(String comment) {
        this.switch2Login();
        this.context.getState().comment(comment);
    }

    private void switch2Login() {
        System.out.println("跳转到登录页面！");
        this.context.setState(this.context.STATE_LOGIN);
    }
}
