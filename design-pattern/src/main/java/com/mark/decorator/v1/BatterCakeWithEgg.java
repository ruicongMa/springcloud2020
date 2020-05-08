package com.mark.decorator.v1;

/**
 * @author Mark
 * @date 2020/5/7 11:14
 */
public class BatterCakeWithEgg extends BatterCake {

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    public int getPrice() {
        //加一个鸡蛋加1块钱
        return super.getPrice() + 1;
    }
}
