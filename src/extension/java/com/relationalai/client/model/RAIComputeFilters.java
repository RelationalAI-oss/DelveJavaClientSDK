package com.relationalai.client.model;

import java.util.List;

public class RAIComputeFilters
{
    public final List<String> id;
    public final List<String> name;
    public final List<RaiComputeSize> size;
    public final List<String> state;

    public RAIComputeFilters(
        List<String> id, List<String> name, List<RaiComputeSize> size, List<String> state)
    {
        this.id = id;
        this.name = name;
        this.size = size;
        this.state = state;
    }
}
