package com.mark.proxy.me;

import java.lang.reflect.Method;

/**
 * @author Mark
 * @date 2020/5/4 16:31
 */
public interface MarkInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
