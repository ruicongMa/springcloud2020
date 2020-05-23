package com.mark.memento.uml;

/**
 * @author Mark
 * @date 2020/5/23 14:48
 */
public class Originator {

    public String getState() {
        return null;
    }

    public void setState(String state) {

    }

    public Memento createMemento() {
        return new Memento();
    }

    public void restoreMemento(Memento memento) {

    }
}
