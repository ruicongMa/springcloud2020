package com.mark.observer.uml;

/**
 * @author Mark
 * @date 2020/5/26 10:05
 */
public interface ISubject<E> {

    boolean attach(IObserver<E> observer);

    boolean detach(IObserver<E> observer);

    void notify(E e);
}
