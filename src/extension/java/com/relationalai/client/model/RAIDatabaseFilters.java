package com.relationalai.client.model;

import java.util.List;

public class RAIDatabaseFilters
{
    public final List<String> id;
    public final List<String> name;
    public final List<String> state;

    public RAIDatabaseFilters(
        List<String> id, List<String> name, List<String> state)
    {
        this.id = id;
        this.name = name;
        this.state = state;
    }
}
