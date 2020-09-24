package com.relationalai.client.builder;

import com.relationalai.client.model.CSVFileSchema;

import java.util.ArrayList;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString(callSuper = true)
public class FileSchemaCSV extends CSVFileSchema {
    @lombok.Builder
    public FileSchemaCSV(List<String> types) {
        this.types(types);
    }

    public CSVFileSchema getCSVFileSchema(FileSchemaCSV fileSchemaCSV) {
        return new CSVFileSchema()
                .types(fileSchemaCSV.getTypes() == null ? new ArrayList<>() : fileSchemaCSV.getTypes());
    }
}
