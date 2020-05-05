package com.mark.proxy.eg;

/**
 * @author Mark
 * @date 2020/5/4 12:13
 */
public class DynamicDataSourceEntry {

    //默认数据源
    public static final String DEFAULT_SOURCE = null;

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntry() {
    }

    //根据年份动态设置数据源
    public static void set(int year) {
        local.set("DB_" + year);
    }

    //设置已知名字的数据源
    public static void set(String source) {
        local.set(source);
    }

    //还原当前切换的数据源
    public static void restore() {
        local.set(DEFAULT_SOURCE);
    }

    //获取当前正在使用的数据源名字
    public static String get() {
        return local.get();
    }

    //清空数据源
    public static void clear() {
        local.remove();
    }
}
