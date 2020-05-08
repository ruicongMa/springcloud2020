package com.mark.decorator.v1;

/**
 * @author Mark
 * @date 2020/5/7 11:19
 */
public class BatterCakeWithEggAndSausage extends BatterCake {

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1根香肠";
    }

    @Override
    public int getPrice() {
        //加一个香肠加2块钱
        return super.getPrice() + 2;
    }
}
