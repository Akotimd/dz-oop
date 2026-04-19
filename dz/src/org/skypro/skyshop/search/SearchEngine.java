package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private ArrayList<Searchable> searchables;

    public SearchEngine(int capacity) {
        this.searchables = new ArrayList<>();
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> result = new TreeMap<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerms().contains(query)) {
                result.put(searchable.getName(), searchable);
            }
        }
        return result;
    }

    public Searchable findSearchable(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }
        Searchable bestResult = null;
        int maxOccurrences = 0;
        String target = search.toLowerCase();

        for (Searchable searchable : searchables) {
            if (searchable == null) continue;
            String text = searchable.getSearchTerms().toLowerCase();
            int count = 0;
            int index = 0;

            while ((index = text.indexOf(target, index)) != -1) {
                count++;
                index += target.length();
            }
            if (count > maxOccurrences) {
                maxOccurrences = count;
                bestResult = searchable;
            }
        }
        if (maxOccurrences <= 0) {
            throw new BestResultNotFound(search);
        }
        return bestResult;
    }
    public void add(Searchable searchable) {
        int freeIndex = getFreeIndex();
        if (freeIndex == searchables.size()) {
            searchables.add(searchable);
        } else  {
            searchables.set(freeIndex, searchable);
        }
    }

    public int getFreeIndex() {
        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i) == null) {
                return i;
            }
        }
        return searchables.size();
    }
}
