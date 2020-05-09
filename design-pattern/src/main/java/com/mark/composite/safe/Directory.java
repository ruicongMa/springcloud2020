package com.mark.composite.safe;

/**
 * @author Mark
 * @date 2020/5/9 20:38
 */
public abstract class Directory {
    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    public abstract void show();
}
