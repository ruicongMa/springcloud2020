package com.mark.singleton.hungry;

/**
 * @author Mark
 * @date 2020/4/29 10:40
 */
public class HungryStaticSingleton {

    /**
     * 加载机制：
     * 先静态，后动态
     * 先属性，后方法
     * 先上后下
     */

    private static final HungryStaticSingleton HUNGRY_STATIC_SINGLETON;

    static {
        HUNGRY_STATIC_SINGLETON = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
    }

    public static HungryStaticSingleton getInstance() {
        return HUNGRY_STATIC_SINGLETON;
    }
}
