package com.mark.iterator.eg;

import java.util.List;

/**
 * @author Mark
 * @date 2020/5/20 10:15
 */
public class IteratorImpl<E> implements Iterator<E> {

    private List<E> list;
    private int cursor;
    private E element;

    public IteratorImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public E next() {
        System.out.print("当前位置" + cursor + "：");
        this.element = list.get(cursor);
        cursor++;
        return this.element;
    }

    @Override
    public boolean hasNext() {
        if (cursor > list.size() - 1) {
            return false;
        }
        return true;
    }
}
