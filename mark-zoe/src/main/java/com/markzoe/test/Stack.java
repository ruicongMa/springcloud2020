package com.markzoe.test;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Mark
 * @date 2021/5/31 下午8:34
 */
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    public Object pop2() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, size * 2 + 1);
    }
}
