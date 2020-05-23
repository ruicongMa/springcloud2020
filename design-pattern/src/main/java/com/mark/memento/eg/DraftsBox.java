package com.mark.memento.eg;

import java.util.Stack;

/**
 * @author Mark
 * @date 2020/5/23 15:33
 */
public class DraftsBox {

    private final Stack<ArticleMemento> stack = new Stack<>();

    public ArticleMemento getMemento() {
        ArticleMemento articleMemento = stack.pop();
        return articleMemento;
    }

    public void addMemento(ArticleMemento articleMemento) {
        stack.push(articleMemento);
    }
}
