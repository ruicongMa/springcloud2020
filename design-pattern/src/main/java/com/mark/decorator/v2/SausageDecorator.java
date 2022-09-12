package com.mark.decorator.v2;

/**
 * @author Mark
 * @date 2020/5/7 15:10
 */
public class SausageDecorator extends BatterCakeDecorator {

    public SausageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    public String getMsg() {
        return super.getMsg() + "+1根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
