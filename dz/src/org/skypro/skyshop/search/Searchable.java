package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerms();

    String getContentType();

    default String getStringRepresentation() {
        return getSearchTerms() + " - " + getContentType();
    }
}
