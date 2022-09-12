package com.mark.prototype;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark
 * @date 2020/5/2 16:48
 */
public class PrototypeTest {

    @Test
    public void test() {
        //创建原型对象
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setName("Mark");
        concretePrototype.setAge(18);
        List<String> hobbies = new ArrayList<>();
        hobbies.add("basketball");
        hobbies.add("coding");
        concretePrototype.setHobbies(hobbies);

        //拷贝原型对象
        // ConcretePrototype cloneType = concretePrototype.clone();
        ConcretePrototype cloneType = concretePrototype.deepClone();
        // ConcretePrototype cloneType = concretePrototype.deepCloneHobbies();
        cloneType.getHobbies().add("swing");
        System.out.println("原型对象：" + concretePrototype);
        System.out.println("克隆对象：" + cloneType);
        System.out.println(concretePrototype == cloneType);
    }
}
