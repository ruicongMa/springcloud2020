package com.mark.proxy.test;

import com.mark.proxy.staticproxy.IPerson;
import com.mark.proxy.dynamicproxy.jdk.JdkMeiRen;
import com.mark.proxy.staticproxy.ZhangSan;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author Mark
 * @date 2020/5/4 15:57
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        try {
            IPerson zhangSan = new JdkMeiRen().getInstance(new ZhangSan());
            zhangSan.findLove();

            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
            FileOutputStream fos = new FileOutputStream("$Proxy0.class");
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
