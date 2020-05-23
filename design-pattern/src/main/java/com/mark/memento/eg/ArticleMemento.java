package com.mark.memento.eg;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mark
 * @date 2020/5/23 15:03
 */
@Data
@AllArgsConstructor
public class ArticleMemento {

    private String title;
    private String content;
    private String images;
}
