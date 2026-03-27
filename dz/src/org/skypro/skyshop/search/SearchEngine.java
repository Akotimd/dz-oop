package org.skypro.skyshop.search;

public class SearchEngine {

    private final Searchable[] searchables;
    private int count;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.count = 0;
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < count && resultCount < 5; i++) {
            Searchable searchable = this.searchables[i];
            String searchTerm = searchable.getSearchTerms();

            if (searchTerm.toLowerCase().contains(query.toLowerCase())) {
                result[resultCount] = searchable;
                resultCount++;
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count] = searchable;
            count++;
        } else {
            System.out.println("Невозможно добавить объект: достигнут лимит");
        }
    }
}
