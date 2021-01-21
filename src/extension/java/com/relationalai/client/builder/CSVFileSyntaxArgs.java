package com.relationalai.client.builder;

import com.relationalai.client.model.CSVFileSyntax;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString(callSuper = true)
public class CSVFileSyntaxArgs extends CSVFileSyntax {

    @lombok.Builder
    public CSVFileSyntaxArgs(
        List<String > header,
        String delim,
        Integer dataRow,
        String escapechar,
        Integer headerRow,
        Boolean ignorerepeated,
        List<String> missingstrings,
        Boolean normalizenames,
        String quotechar
    ) {
        this.header(header);
        this.dataRow(dataRow);
        this.delim(delim);
        this.escapechar(escapechar);
        this.headerRow(headerRow);
        this.ignorerepeated(ignorerepeated);
        this.missingstrings(missingstrings);
        this.normalizenames(normalizenames);
        this.quotechar(quotechar);
    }

    public CSVFileSyntax getCSVFileSyntax(CSVFileSyntaxArgs CSVFileSyntaxArgs) {
        return new CSVFileSyntax()
                .header(CSVFileSyntaxArgs.getHeader())
                .delim(StringUtils.isEmpty(CSVFileSyntaxArgs.getDelim()) ? "," : CSVFileSyntaxArgs.getDelim())
                .dataRow(CSVFileSyntaxArgs.getDataRow() == null ? -1 : CSVFileSyntaxArgs.getDataRow())
                .escapechar(StringUtils.isEmpty(CSVFileSyntaxArgs.getEscapechar()) ? "\\" : CSVFileSyntaxArgs.getEscapechar())
                .headerRow(CSVFileSyntaxArgs.getHeaderRow() == null ? 1 : CSVFileSyntaxArgs.getHeaderRow())
                .ignorerepeated(CSVFileSyntaxArgs.getIgnorerepeated() == null ? false : CSVFileSyntaxArgs.getIgnorerepeated())
                .missingstrings(CSVFileSyntaxArgs.getMissingstrings())
                .normalizenames(CSVFileSyntaxArgs.getNormalizenames() == null ? false : CSVFileSyntaxArgs.getNormalizenames())
                .quotechar(StringUtils.isEmpty(CSVFileSyntaxArgs.getQuotechar()) ? "\"" : CSVFileSyntaxArgs.getQuotechar());
    }
}
