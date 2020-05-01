package com.mark.singleton;

import com.mark.singleton.enumsingleton.EnumSingleton;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Mark
 * @date 2020/4/29 19:15
 */
public class EnumSingletonTest {

    @Test
    public void test() {
        try {
            EnumSingleton s1 = EnumSingleton.getInstance();
            FileOutputStream fos = new FileOutputStream("serializableSingleton.obj");

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("serializableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            EnumSingleton s2 = (EnumSingleton) ois.readObject();
            ois.close();

            System.out.println("s1=" + s1);
            System.out.println("s2=" + s2);
            System.out.println(s1 == s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
