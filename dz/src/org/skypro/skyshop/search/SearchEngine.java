package org.skypro.skyshop.search;

public class SearchEngine {

    private final Searchable[] searchables;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int count = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerms().contains(query)) {
                result[count++] = searchable;
                if (count >= 50) {
                    break;
                }
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        int freeIndex = getFreeIndex();
        if (freeIndex < -1) {
            System.out.println("Невозможно добавить элемент для поиска");
            return;
        }
        searchables[freeIndex] = searchable;
    }

    public int getFreeIndex() {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                return i;
            }
        }
        return 0;
    }
}
