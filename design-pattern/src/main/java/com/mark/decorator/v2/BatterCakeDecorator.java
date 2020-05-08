package com.mark.decorator.v2;

/**
 * @author Mark
 * @date 2020/5/7 11:54
 */
public abstract class BatterCakeDecorator extends BatterCake {

    //静态代理，委派
    private BatterCake batterCake;

    public BatterCakeDecorator(BatterCake batterCake) {
        this.batterCake = batterCake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.batterCake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.batterCake.getPrice();
    }
}
