package com.mark.mediator.eg;

/**
 * @author Mark
 * @date 2020/5/24 10:16
 */
public class ChatRoom {

    public void showMsg(User user, String msg) {
        System.out.println("[" + user.getName() + "]：" + msg);
    }
}
