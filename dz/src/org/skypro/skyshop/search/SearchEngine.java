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

    public Searchable findSearchable(String search) {
        Searchable bestResult = null;
        int maxOccurrences = 0;
        for (Searchable searchable : searchables) {
            if (searchable == null) continue;
            String text = searchable.getSearchTerms().toLowerCase();
            String target = search.toLowerCase();
            int count = 0;
            int index = 0;

            while ((index = text.indexOf(target, index)) != -1) {
                count++;
                index += target.length();
            }
        }
        return bestResult;
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
