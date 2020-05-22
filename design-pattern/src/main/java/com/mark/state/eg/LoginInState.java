package com.mark.state.eg;

/**
 * @author Mark
 * @date 2020/5/22 11:14
 */
public class LoginInState extends UserState {

    @Override
    public void favorite() {
        System.out.println("收藏成功！");
    }

    @Override
    public void comment(String comment) {
        System.out.println(comment);
    }
}
