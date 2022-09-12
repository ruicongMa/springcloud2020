package com.mark.decorator.v2;

/**
 * @author Mark
 * @date 2020/5/7 11:47
 */
public class BaseBatterCake implements BatterCake {
    @Override
    public String getMsg() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
