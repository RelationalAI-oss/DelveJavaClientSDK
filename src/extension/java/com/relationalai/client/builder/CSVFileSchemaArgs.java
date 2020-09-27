package com.relationalai.client.builder;

import com.relationalai.client.model.CSVFileSchema;

import java.util.ArrayList;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString(callSuper = true)
public class CSVFileSchemaArgs extends CSVFileSchema {
    @lombok.Builder
    public CSVFileSchemaArgs(List<String> types) {
        this.types(types);
    }

    public CSVFileSchema getCSVFileSchema(CSVFileSchemaArgs CSVFileSchemaArgs) {
        return new CSVFileSchema()
                .types(CSVFileSchemaArgs.getTypes() == null ? new ArrayList<>() : CSVFileSchemaArgs.getTypes());
    }
}
