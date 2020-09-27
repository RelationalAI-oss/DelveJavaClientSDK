package com.relationalai.client.builder;

import com.relationalai.client.model.FileSchema;
import com.relationalai.client.model.FileSyntax;
import com.relationalai.client.model.LoadDataAction;

@lombok.Getter
@lombok.Setter
@lombok.ToString(callSuper = true)
public class DataLoaderArgs extends LoadDataAction {
    String contentType;
    String data;
    String path;
    Object key;
    FileSyntax syntax;
    FileSchema schema;

    @lombok.Builder
    public DataLoaderArgs(
            String rel,
            String contentType,
            String data,
            String path,
            Object key,
            FileSyntax syntax,
            FileSchema schema
    ) {
        this.setRel(rel);
        this.contentType = contentType;
        this.data = data;
        this.path = path;
        this.key = key;
        this.syntax = syntax;
        this.schema = schema;
    }
}
