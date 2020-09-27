package com.relationalai.client.builder;

import com.relationalai.client.model.InstallAction;
import com.relationalai.client.model.Source;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString(callSuper = true)
public class InstallSourceArgs extends InstallAction {
    private String name;
    private String path;
    private String value;

    @lombok.Builder
    public InstallSourceArgs(
            String name,
            String path,
            String value,
            List<Source> sources
    ) {
        this.name = name;
        this.path = path;
        this.value = value;
        this.sources(sources);
    }
}
