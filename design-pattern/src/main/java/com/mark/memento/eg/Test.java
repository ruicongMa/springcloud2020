package com.mark.memento.eg;

/**
 * @author Mark
 * @date 2020/5/23 15:49
 */
public class Test {

    public static void main(String[] args) {
        DraftsBox draftsBox = new DraftsBox();

        Editor editor = new Editor("设计模式学习之旅", "好好学习天天向上", "666888.png");

        ArticleMemento articleMemento = editor.saveToMemento();
        draftsBox.addMemento(articleMemento);

        System.out.println("标题：" + editor.getTitle() + "\n" + "内容：" + editor.getContent() + "\n" + "插图：" + editor.getImages());
        System.out.println("完成的信息：" + editor);

        System.out.println("====首次修改文章====");
        editor.setTitle("备忘录模式");
        editor.setContent("Mark在学习此模式中。。。");
        System.out.println("====首次修改文章完成====");

        System.out.println("完成的信息：" + editor);

        articleMemento = editor.saveToMemento();
        draftsBox.addMemento(articleMemento);
        System.out.println("====保存到草稿箱====");

        System.out.println("====第二次修改文章====");
        editor.setTitle("单例模式");
        editor.setContent("Zoe在学习此模式中。。。");
        System.out.println("完成的信息：" + editor);
        System.out.println("====第二次修改文章完成====");

        System.out.println("====第一次撤销====");
        articleMemento = draftsBox.getMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("完成的信息：" + editor);
        System.out.println("====第一次撤销完成====");

        System.out.println("====第二次撤销====");
        articleMemento = draftsBox.getMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("完成的信息：" + editor);
        System.out.println("====第二次撤销完成====");
    }
}
