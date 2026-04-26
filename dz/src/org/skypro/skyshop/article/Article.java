package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {

    private final String articleTitle;
    private final String text;

    public Article(String articleTitle, String text) {
        this.articleTitle = articleTitle;
        this.text = text;
    }

    @Override
    public String getName() {
        return articleTitle;
    }

    @Override
    public String getSearchTerms() {
        return articleTitle + " " + text;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(articleTitle, article.articleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleTitle);
    }

    @Override
    public String toString() {
        return "Название статьи " + articleTitle + '\'' +
                " Текст статьи: " + text + '\'';
    }


}
