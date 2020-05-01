package com.mark.singleton.lazy;

/**
 * @author Mark
 * @date 2020/4/29 10:59
 */
public class LazyDoubleCheckSingleton {

    private LazyDoubleCheckSingleton() {

    }

    //使用volatile禁止指令重排序
    private static volatile LazyDoubleCheckSingleton instance;

    public static LazyDoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheckSingleton();
                    /**
                     * 1。分配内存给这个对象
                     * 2。初始化对象
                     * 3。设置lazy指向刚分配的内存地址
                     * 4。初始化访问对象
                     */
                }
            }
        }
        return instance;
    }
}
