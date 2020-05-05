package com.mark.proxy;

/**
 * @author Mark
 * @date 2020/5/4 10:36
 */
public class Client {

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();
    }
}
