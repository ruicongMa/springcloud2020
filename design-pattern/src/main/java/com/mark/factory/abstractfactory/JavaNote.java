package com.mark.factory.abstractfactory;

/**
 * @author Mark
 * @date 2020/4/28 14:01
 */
public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("记录Java笔记");
    }
}
