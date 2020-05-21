package com.mark.iterator.uml;

/**
 * @author Mark
 * @date 2020/5/20 9:59
 */
public class ConcreteAggregate<E> implements IAggregate<E> {
    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
