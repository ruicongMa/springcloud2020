package com.mark.decorator.v2;

/**
 * @author Mark
 * @date 2020/5/7 11:47
 */
public class BaseBatterCake extends BatterCake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
