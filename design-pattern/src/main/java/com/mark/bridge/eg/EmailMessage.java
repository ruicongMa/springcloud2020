package com.mark.bridge.eg;

/**
 * @author Mark
 * @date 2020/5/11 16:11
 */

/**
 * 邮件短消息的实现类
 */
public class EmailMessage implements IMessage {
    @Override
    public void send(String message, String toUser) {
        System.out.println(String.format("使用邮件短消息的方法，发送消息 %s 给 %s", message, toUser));
    }
}
