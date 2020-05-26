package com.mark.observer.eg;

import java.util.Observable;

/**
 * @author Mark
 * @date 2020/5/26 10:22
 */

/**
 * JDK提供的一种观察者的实现方式，被观察者
 */
public class MPer extends Observable {

    private String name = "MPer生态圈";
    private static MPer mPer = null;

    private MPer() {
    }

    public static MPer getInstance() {
        if (mPer == null) {
            mPer = new MPer();
        }
        return mPer;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
