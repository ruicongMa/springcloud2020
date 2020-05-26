package com.mark.observer.eg;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Mark
 * @date 2020/5/26 10:35
 */

/**
 * 观察者
 */
public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        MPer mPer = (MPer) o;
        Question question = (Question) arg;
        System.out.println("===============================");
        System.out.println(name + "老师，你好！\n" + "您收到了一个来自“" + mPer.getName() + "”的提问，希望您解答，问题内容如下：\n" + question.getContent() + "\n" + "提问者：" + question.getUserName());
    }
}
