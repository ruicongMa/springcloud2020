package com.moe.juc.c_018_01_Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Mark
 * @date 2022/5/15 21:22
 */
public class HelloUnsafe {

    static class M {
        private M() {
        }

        int i = 0;
    }

    public static void main(String[] args) throws Exception {
        test01();
    }

    public static void test01() throws InstantiationException {
        Unsafe unsafe = reflectGetUnsafe();
        M m = (M) unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void test02() throws InstantiationException {
        Unsafe unsafe = Unsafe.getUnsafe(); // JDK 十几来着可以这么操作，JDK1.8以下不可以这么操作
        M m = (M) unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
    }
}
