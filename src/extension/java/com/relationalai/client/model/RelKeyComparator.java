package com.relationalai.client.model;

import java.util.Comparator;

public class RelKeyComparator implements Comparator<RelKey> {
    private final static ListComparator<String> STRING_LIST_CMP = new ListComparator<>();

    @Override
    public int compare(RelKey o1, RelKey o2) {
        int res = 0;
        res = o1.getName().compareTo(o2.getName());
        if(res != 0) return res;

        res = STRING_LIST_CMP.compare(o1.getKeys(), o2.getKeys());
        if(res != 0) return res;

        res = STRING_LIST_CMP.compare(o1.getValues(), o2.getValues());
        if(res != 0) return res;

        return res;
    }
}
