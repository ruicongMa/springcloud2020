package com.mark.factory.abstractfactory;

/**
 * @author Mark
 * @date 2020/4/28 14:00
 */
public class JavaVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制Java视频");
    }
}
