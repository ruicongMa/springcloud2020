package com.mark.factory.abstractfactory;

/**
 * @author Mark
 * @date 2020/4/28 14:08
 */
public class PythonNote implements INote {
    @Override
    public void edit() {
        System.out.println("记录python笔记");
    }
}
