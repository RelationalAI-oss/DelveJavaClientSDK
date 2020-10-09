package com.relationalai.client.builder;

import com.relationalai.client.model.QueryAction;
import com.relationalai.client.model.Relation;
import com.relationalai.client.model.Source;

import java.util.ArrayList;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString(callSuper = true)
public class QueryArgs extends QueryAction {
    private String name;
    private String path;
    private String value;
    private Boolean readOnly;

    /**
     *
     * @param name
     * @param path
     * @param value
     * @param inputs
     * @param outputs
     * @param persist
     * @param source
     */
    @lombok.Builder
    public QueryArgs(
        String name,
        String path,
        String value,
        Boolean readOnly,
        List<Relation> inputs,
        List<String> outputs,
        List<String> persist,
        Source source
    ) {
        this.name = name == null ? "" : name;
        this.path = path == null ? "" : path;
        this.value = value == null ? "" : value;
        this.inputs(inputs == null ? new ArrayList<>() : inputs);
        this.outputs(outputs == null ? new ArrayList<>() : outputs);
        this.persist(persist == null ? new ArrayList<>() : persist);
        this.readOnly = readOnly == null ? this.getPersist().size() == 0 : readOnly;
        if (source == null) {
            Source src = new Source();
            src.setName(this.getName());
            src.setPath(this.getPath());
            src.setValue(this.getValue());
            this.source(src);
        } else {
            this.source(source);
        }
    }
}
