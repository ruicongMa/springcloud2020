package com.mark.observer.uml;

/**
 * @author Mark
 * @date 2020/5/26 10:08
 */
public class ConcreteSubject<E> implements ISubject<E> {

    @Override
    public boolean attach(IObserver<E> observer) {
        return false;
    }

    @Override
    public boolean detach(IObserver<E> observer) {
        return false;
    }

    @Override
    public void notify(E e) {

    }
}
