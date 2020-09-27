package com.relationalai.client.builder;

import com.relationalai.client.model.QueryAction;
import com.relationalai.client.model.Relation;
import com.relationalai.client.model.Source;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString(callSuper = true)
public class QueryArgs extends QueryAction {
    private String name;
    private String path;
    private String value;

    @lombok.Builder
    public QueryArgs(
            String name,
            String path,
            String value,
            List<Relation> inputs,
            List<String> outputs,
            List<String> persist,
            Source source
    ) {
        this.name = name;
        this.path = path;
        this.value = value;
        this.inputs(inputs);
        this.outputs(outputs);
        this.persist(persist);
        this.source(source);
    }
}
