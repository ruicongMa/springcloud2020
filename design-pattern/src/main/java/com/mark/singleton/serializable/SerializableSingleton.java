package com.mark.singleton.serializable;

import java.io.Serializable;

/**
 * @author Mark
 * @date 2020/4/29 17:45
 */

/**
 * 反序列化导致破坏单例模式
 * 序列化是把内存中的状态通过转换成字节码的形式，从而转换一个I/O流，写入其它地方（可以是磁盘，网络I/O）
 * 内存中的状态会永久保存下来
 * 反序列化就是将已经持久化的字节码内容转换为I/O流，通过I/O流的读取，进而将读取的内容转换为Java对象'
 * 在转换过程中会重新创建对象new
 */
public class SerializableSingleton implements Serializable {
    private static final long serialVersionUID = 4440801921918873154L;

    private static final SerializableSingleton SERIALIZABLE_SINGLETON = new SerializableSingleton();

    public static SerializableSingleton getInstance() {
        return SERIALIZABLE_SINGLETON;
    }

    private Object readResolve() {
        return SERIALIZABLE_SINGLETON;
    }
}
