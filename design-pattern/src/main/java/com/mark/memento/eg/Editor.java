package com.mark.memento.eg;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mark
 * @date 2020/5/23 15:01
 */
@Data
@AllArgsConstructor
public class Editor {

    private String title;
    private String content;
    private String images;

    public ArticleMemento saveToMemento() {
        ArticleMemento articleMemento = new ArticleMemento(this.title, this.content, this.images);
        return articleMemento;
    }

    public void undoFromMemento(ArticleMemento articleMemento) {
        this.title = articleMemento.getTitle();
        this.content = articleMemento.getContent();
        this.images = articleMemento.getImages();
    }
}
