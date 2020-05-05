package com.mark.facade;

/**
 * @author Mark
 * @date 2020/5/5 11:40
 */
public class Facade {
    private SubSystemA a = new SubSystemA();
    private SubSystemB b = new SubSystemB();
    private SubSystemC c = new SubSystemC();

    //对外接口
    public void doA() {
        a.doA();
    }

    //对外接口
    public void doB() {
        b.doB();
    }

    //对外接口
    public void doC() {
        c.doC();
    }
}
