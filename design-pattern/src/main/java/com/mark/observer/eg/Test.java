package com.mark.observer.eg;

/**
 * @author Mark
 * @date 2020/5/26 10:40
 */
public class Test {

    public static void main(String[] args) {
        MPer mPer = MPer.getInstance();
        Teacher mark = new Teacher("Mark");
        Teacher zoe = new Teacher("Zoe");

        mPer.addObserver(mark);
        mPer.addObserver(zoe);

        //业务逻辑代码
        Question question = new Question();
        question.setUserName("小明");
        question.setContent("观察者模式适用于哪些场景？");

        mPer.publishQuestion(question);
    }
}
