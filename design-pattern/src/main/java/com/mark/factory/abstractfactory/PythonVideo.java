package com.mark.factory.abstractfactory;

/**
 * @author Mark
 * @date 2020/4/28 14:07
 */
public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制python视频");
    }
}
