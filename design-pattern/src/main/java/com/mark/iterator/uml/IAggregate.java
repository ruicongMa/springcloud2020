package com.mark.iterator.uml;

/**
 * @author Mark
 * @date 2020/5/20 9:56
 */
public interface IAggregate<E> {

    boolean add(E e);

    boolean remove(E e);

    Iterator<E> iterator();
}
