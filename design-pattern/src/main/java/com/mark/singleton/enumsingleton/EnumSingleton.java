package com.mark.singleton.enumsingleton;

/**
 * @author Mark
 * @date 2020/4/29 21:57
 */
public enum EnumSingleton {

    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
