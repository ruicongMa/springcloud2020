package com.mark.proxy.dynamicproxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author Mark
 * @date 2020/5/4 21:54
 */
public class Test {
    public static void main(String[] args) {
        //利用CGLib的代理类可以将内存中的.class文件写入本地磁盘
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F://test/");
        Customer customer = (Customer) new CglibMeiRen().getInstance(Customer.class);
        System.out.println(customer.getClass());
        customer.findLove();
    }
}
