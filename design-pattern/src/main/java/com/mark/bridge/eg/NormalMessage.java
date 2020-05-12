package com.mark.bridge.eg;

/**
 * @author Mark
 * @date 2020/5/11 16:20
 */

/**
 * 普通消息类
 */
public class NormalMessage extends AbstractMessage {

    //构造方法，传入实现部分的对象
    public NormalMessage(IMessage iMessage) {
        super(iMessage);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        //对于普通消息，直接调用父类方法，发送消息即可
        super.sendMessage(message, toUser);
    }
}
