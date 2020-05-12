package com.mark.bridge.eg;

/**
 * @author Mark
 * @date 2020/5/11 16:14
 */

/**
 * 系统内短消息的实现类
 * SMS(Short IMessage Service)短信息服务
 */
public class SmsMessage implements IMessage {
    @Override
    public void send(String message, String toUser) {
        System.out.println(String.format("使用系统内部短消息的方法，发送消息 %s 给 %s", message, toUser));
    }
}
