package com.relationalai.client.model;

import java.util.LinkedList;
import java.util.List;

public class RelationFactory {

    public static List<List<Object>> toCollection(Object[][] columnsArr) {
        List<List<Object>> columns = new LinkedList<>();
        if(columnsArr != null) {
            for (Object[] colArr : columnsArr) {
                List<Object> col = new LinkedList<>();
                if(colArr != null) {
                    for (Object elem : colArr) {
                        col.add(elem);
                    }
                }
                columns.add(col);
            }
        }
        return columns;
    }

    public static Relation build(RelKey relKey, Object[][] columns)
    {
        return build(relKey, toCollection(columns));
    }

    public static Relation build(RelKey relKey, List<List<Object>> columns)
    {
        Relation instance = new Relation();
        instance.setRelKey(relKey);
        instance.setColumns(columns);
        return instance;
    }
}
