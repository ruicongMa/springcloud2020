package com.mark.proxy.me;

import com.mark.proxy.staticproxy.IPerson;
import com.mark.proxy.staticproxy.ZhangSan;

/**
 * @author Mark
 * @date 2020/5/4 17:37
 */
public class Test {
    public static void main(String[] args) {
        IPerson zhangSan = (IPerson) new MarkMeiRen().getInstance(new ZhangSan());
        System.out.println(zhangSan.getClass());
        zhangSan.findLove();
    }
}
