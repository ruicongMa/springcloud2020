package com.mark.mediator.eg;

/**
 * @author Mark
 * @date 2020/5/24 10:16
 */
public class User {

    private String name;
    private ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public void sendMessage(String msg) {
        this.chatRoom.showMsg(this, msg);
    }

    public String getName() {
        return name;
    }
}
