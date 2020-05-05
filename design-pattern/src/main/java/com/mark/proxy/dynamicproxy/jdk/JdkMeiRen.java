package com.mark.proxy.dynamicproxy.jdk;

import com.mark.proxy.staticproxy.IPerson;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Mark
 * @date 2020/5/4 11:29
 */
public class JdkMeiRen implements InvocationHandler {

    private IPerson target;

    public IPerson getInstance(IPerson target) {
        this.target = target;
        Class<? extends IPerson> clazz = target.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("我是媒人，已经收集到你的需求，开始物色。");
    }

    private void after() {
        System.out.println("双方同意，开始交往。");
    }
}
