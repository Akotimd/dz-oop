package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private HashSet<Searchable> searchables;

    public SearchEngine(int capacity) {
        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> result = new TreeSet<>((s1, s2) -> {
            int lengthCom = Integer.compare(s2.getName().length(),
                    s1.getName().length());
            if (lengthCom != 0) {
                return lengthCom;
            }
            return s1.getName().compareTo(s2.getName());
        });
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerms().toLowerCase().contains(query.toLowerCase())) {
                result.add(searchable);
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
        searchables.add(searchable);
    }

//    public int getFreeIndex() {
//        for (int i = 0; i < searchables.size(); i++) {
//            if (searchables.get(i) == null) {
//                return i;
//            }
//        }
//        return searchables.size();
//    }
}
