package com.mark.singleton.innerclass;

/**
 * @author Mark
 * @date 2020/4/29 17:01
 */

import java.io.Serializable;

/**
 * 这种形式兼顾饿汉式单例模式的内存浪费问题和懒汉式synchronized加锁的性能问题，完美的屏蔽了这两个缺点
 */
public class LazyInnerClassSingleton implements Serializable {

    private static final long serialVersionUID = -8484501356898167924L;

    /**
     * 使用LazyInnerClassSingleton的时候，默认会初始化内部类LazyHolder，如果没使用，则内部类是不加载的
     */
    private LazyInnerClassSingleton() {
        if (LazyHolder.LAZY_INNER_CLASS_SINGLETON != null) {
            throw new RuntimeException("不允许创建多个实例~~~");
        }
    }

    /**
     * 每一个关键字都不是多余的，static是为了使单例的空间共享，final保证这个方法不会被覆盖，重载
     */
    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY_INNER_CLASS_SINGLETON;
    }

    //默认不加载
    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY_INNER_CLASS_SINGLETON = new LazyInnerClassSingleton();
    }

    private Object readResolve() {
        return LazyHolder.LAZY_INNER_CLASS_SINGLETON;
    }
}
