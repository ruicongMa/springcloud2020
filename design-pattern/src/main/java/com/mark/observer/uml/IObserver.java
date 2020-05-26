package com.mark.observer.uml;

/**
 * @author Mark
 * @date 2020/5/26 10:06
 */
public interface IObserver<E> {

    void update(E e);
}
