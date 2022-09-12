package com.mark.decorator.v2;

/**
 * @author Mark
 * @date 2020/5/7 11:54
 */
public abstract class BatterCakeDecorator implements BatterCake {

    //静态代理，委派
    private BatterCake batterCake;

    public BatterCakeDecorator(BatterCake batterCake) {
        this.batterCake = batterCake;
    }

    protected abstract void doSomething();

    @Override
    public String getMsg() {
        return this.batterCake.getMsg();
    }

    @Override
    public int getPrice() {
        return this.batterCake.getPrice();
    }
}
