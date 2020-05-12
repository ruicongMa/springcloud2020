package com.mark.bridge.eg;

/**
 * @author Mark
 * @date 2020/5/11 16:17
 */

/**
 * 抽象类消息
 */
public abstract class AbstractMessage {

    //持有一个实现部分的抽象
    private IMessage iMessage;

    //构造方法，传入实现部分的对象
    public AbstractMessage(IMessage iMessage) {
        this.iMessage = iMessage;
    }

    //发送消息，委派给实现部分的方法
    public void sendMessage(String message, String toUser) {
        iMessage.send(message, toUser);
    }
}
