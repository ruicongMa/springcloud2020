package com.mark.visitor.dispatch;

/**
 * @author Mark
 * @date 2020/5/27 16:28
 */
interface Person {

    void test();
}

class Man implements Person {

    @Override
    public void test() {
        System.out.println("男人");
    }
}

class Woman implements Person {

    @Override
    public void test() {
        System.out.println("女人");
    }
}

class Main {
    public static void main(String[] args) {
        Person man = new Man();
        Person woman = new Woman();
        man.test();
        woman.test();
    }
}

