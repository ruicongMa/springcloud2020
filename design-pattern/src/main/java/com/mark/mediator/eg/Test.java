package com.mark.mediator.eg;

/**
 * @author Mark
 * @date 2020/5/24 10:21
 */
public class Test {

    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        User mark = new User("Mark", chatRoom);
        User zoe = new User("ZOE", chatRoom);
        mark.sendMessage("Hi ! I am Mark.");
        zoe.sendMessage("Hello ! My name is ZOE.");
    }
}
