package com.mark.proxy.dynamicproxy.jdk;

import com.mark.proxy.staticproxy.IPerson;
import com.mark.proxy.staticproxy.ZhangSan;
import com.mark.proxy.staticproxy.ZhaoLiu;

/**
 * @author Mark
 * @date 2020/5/4 11:15
 */
public class Test {
    public static void main(String[] args) {
        JdkMeiRen jdkMeiRen = new JdkMeiRen();
        IPerson zhangSan = jdkMeiRen.getInstance(new ZhangSan());
        System.out.println(zhangSan.getClass().getName());
        zhangSan.findLove();
        zhangSan.test();
        System.out.println("=====================");
        // IPerson zhaoLiu = jdkMeiRen.getInstance(new ZhaoLiu());
        // zhaoLiu.findLove();
    }
}
