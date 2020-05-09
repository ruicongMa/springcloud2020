package com.mark.composite.safe;

/**
 * @author Mark
 * @date 2020/5/9 20:51
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("=============安全组合模式================");

        File qq = new File("QQ.exe");
        File wx = new File("微信.exe");

        Folder office = new Folder("办公软件", 2);

        File word = new File("word.exe");
        File ppt = new File("powerpoint.exe");
        File excel = new File("excel.ext");

        office.add(word);
        office.add(ppt);
        office.add(excel);

        Folder wps = new Folder("金山软件", 3);
        wps.add(new File("wps.exe"));
        office.add(wps);

        Folder root = new Folder("根目录", 1);
        root.add(qq);
        root.add(wx);
        root.add(office);

        System.out.println("================show()方法效果======================");
        root.show();
        System.out.println("================list()方法效果======================");
        root.list();
    }
}
