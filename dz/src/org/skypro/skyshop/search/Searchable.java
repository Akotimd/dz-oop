package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerms();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return getSearchTerms() + " - " + getContentType();
    }
}
