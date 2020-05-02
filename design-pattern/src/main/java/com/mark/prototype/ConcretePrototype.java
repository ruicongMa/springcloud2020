package com.mark.prototype;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark
 * @date 2020/5/2 16:44
 */
@Data
public class ConcretePrototype implements Cloneable, Serializable {
    private String name;
    private int age;
    private List<String> hobbies;

    @Override
    public ConcretePrototype clone() {
        try {
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ConcretePrototype deepCloneHobbies() {
        try {
            ConcretePrototype result = (ConcretePrototype) super.clone();
            result.setHobbies((List) ((ArrayList) result.getHobbies()).clone());
            return result;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ConcretePrototype deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (ConcretePrototype) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // @Override
    // public ConcretePrototype clone() {
    //     ConcretePrototype concretePrototype = new ConcretePrototype();
    //     concretePrototype.setName(this.name);
    //     concretePrototype.setAge(this.age);
    //     return concretePrototype;
    // }

}
