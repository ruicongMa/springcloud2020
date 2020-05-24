package com.mark.mediator.uml;

/**
 * @author Mark
 * @date 2020/5/24 9:55
 */
public abstract class Mediator {

    private ConcreteColleagueA colleagueA;
    private ConcreteColleagueB colleagueB;

    public void setColleagueA(ConcreteColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ConcreteColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    public abstract void transferA();

    public abstract void transferB();
}