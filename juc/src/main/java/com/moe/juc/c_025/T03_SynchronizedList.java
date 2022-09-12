package com.moe.juc.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Mark
 * @date 2022/5/16 22:18
 */
public class T03_SynchronizedList {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        List<String> strsSync = Collections.synchronizedList(strs);
    }
}
