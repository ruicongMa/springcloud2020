package com.mark.mediator.uml;

/**
 * @author Mark
 * @date 2020/5/24 10:02
 */
public class Test {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        mediator.setColleagueA(new ConcreteColleagueA());
        mediator.setColleagueB(new ConcreteColleagueB());

        mediator.transferA();
        mediator.transferB();
    }
}
