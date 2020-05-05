package com.mark.proxy.me;

import java.lang.reflect.Method;

/**
 * @author Mark
 * @date 2020/5/4 17:26
 */
public class MarkMeiRen implements MarkInvocationHandler {

    //被代理的对象，把引用保存下来
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return MarkProxy.newProxyInstance(new MarkClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(target, args);
        after();
        return null;
    }

    private void before() {
        System.out.println("我是媒人，我要给你找对象，现在已经确认了你的需求。");
        System.out.println("开始物色");
    }

    private void after() {
        System.out.println("如果合适的话，就准备办事。");
    }
}
