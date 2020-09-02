package com.relationalai.client.model;

import java.util.Collections;
import java.util.List;

public class RelKeyFactory {
    public static RelKey build(String name, List<String> keyTypes, List<String> valueTypes)
    {
        RelKey instance = new RelKey();
        instance.setName(name);
        instance.setKeys(keyTypes == null ? Collections.emptyList() : keyTypes);
        instance.setValues(valueTypes == null ? Collections.emptyList() : valueTypes);
        return instance;
    }
}
