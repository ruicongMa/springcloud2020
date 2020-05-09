package com.mark.composite.safe;

/**
 * @author Mark
 * @date 2020/5/9 20:40
 */
public class File extends Directory {

    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
