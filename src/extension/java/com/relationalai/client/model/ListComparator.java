package com.relationalai.client.model;

import java.util.Comparator;
import java.util.List;

public class ListComparator<T extends Comparable> implements Comparator<List<T>> {
    @Override
    public int compare(List<T> o1, List<T> o2) {
        if(o1 == null && o2 == null) return 0;
        if(o1 == null) return -1;
        if(o2 == null) return +1;
        int res = o1.size() - o2.size();
        if(res != 0) return res;
        for(int i = 0 ; i < o1.size(); ++i) {
            res = o1.get(i).compareTo(o2.get(i));
            if(res != 0) return res;
        }

        return 0;
    }
}
