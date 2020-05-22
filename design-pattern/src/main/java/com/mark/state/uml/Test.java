package com.mark.state.uml;

/**
 * @author Mark
 * @date 2020/5/22 11:02
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateB());
        context.handle();
    }
}
