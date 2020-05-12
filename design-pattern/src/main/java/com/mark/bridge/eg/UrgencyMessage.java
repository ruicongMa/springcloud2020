package com.mark.bridge.eg;

/**
 * @author Mark
 * @date 2020/5/11 16:22
 */

/**
 * 加急消息
 */
public class UrgencyMessage extends AbstractMessage {

    //构造方法
    public UrgencyMessage(IMessage iMessage) {
        super(iMessage);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "加急：" + message;
        super.sendMessage(message, toUser);
    }
}
