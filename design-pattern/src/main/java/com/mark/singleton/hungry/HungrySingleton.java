package com.mark.singleton.hungry;

/**
 * @author Mark
 * @date 2020/4/29 10:40
 */
public class HungrySingleton {

    /**
     * 加载机制：
     * 先静态，后动态
     * 先属性，后方法
     * 先上后下
     */

    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }
}
