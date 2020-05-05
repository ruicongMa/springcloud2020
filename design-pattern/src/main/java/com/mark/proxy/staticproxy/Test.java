package com.mark.proxy.staticproxy;


/**
 * @author Mark
 * @date 2020/5/4 11:15
 */
public class Test {
    public static void main(String[] args) {
        ZhangLaoSan zhangLaoSan = new ZhangLaoSan(new ZhangSan());
        zhangLaoSan.findLove();
    }
}
