package com.mark.state.eg;

/**
 * @author Mark
 * @date 2020/5/22 11:28
 */
public class Test {

    public static void main(String[] args) {
        AppContext appContext = new AppContext();
        appContext.favorite();
        appContext.comment("评论：好文章，520个赞！");
    }
}
