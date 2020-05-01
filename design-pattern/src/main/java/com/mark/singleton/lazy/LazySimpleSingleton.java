package com.mark.singleton.lazy;

/**
 * @author Mark
 * @date 2020/4/29 10:59
 */
public class LazySimpleSingleton {

    private LazySimpleSingleton() {

    }

    private static LazySimpleSingleton instance;

    public static synchronized LazySimpleSingleton getInstance() {
        if (instance == null) {
            instance = new LazySimpleSingleton();
        }
        return instance;
    }
}
