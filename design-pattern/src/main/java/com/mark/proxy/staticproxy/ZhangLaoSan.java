package com.mark.proxy.staticproxy;

/**
 * @author Mark
 * @date 2020/5/4 11:13
 */
public class ZhangLaoSan implements IPerson {

    private ZhangSan zhangSan;

    public ZhangLaoSan(ZhangSan zhangSan) {
        this.zhangSan = zhangSan;
    }

    @Override
    public void findLove() {
        System.out.println("张老三开始物色");
        zhangSan.findLove();
        System.out.println("开始交往");
    }
}
