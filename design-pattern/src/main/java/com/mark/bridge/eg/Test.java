package com.mark.bridge.eg;

/**
 * @author Mark
 * @date 2020/5/11 16:24
 */
public class Test {

    public static void main(String[] args) {
        IMessage message = new SmsMessage();
        AbstractMessage abstractMessage = new NormalMessage(message);
        abstractMessage.sendMessage("加班申请特批", "moe");

        message = new EmailMessage();
        abstractMessage = new UrgencyMessage(message);
        abstractMessage.sendMessage("加班申请特批", "zoe");
    }
}
