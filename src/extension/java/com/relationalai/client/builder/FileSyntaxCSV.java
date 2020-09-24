package com.relationalai.client.builder;

import com.relationalai.client.model.CSVFileSyntax;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString(callSuper = true)
public class FileSyntaxCSV extends CSVFileSyntax {

    @lombok.Builder
    public FileSyntaxCSV(
            List<String > header,
            String delim,
            Integer datarow,
            String escapechar,
            Integer headerRow,
            Boolean ignorerepeated,
            List<String> missingstrings,
            Boolean normalizenames,
            String quotechar
            )
    {
        this.header(header);
        this.datarow(datarow);
        this.delim(delim);
        this.escapechar(escapechar);
        this.headerRow(headerRow);
        this.ignorerepeated(ignorerepeated);
        this.missingstrings(missingstrings);
        this.normalizenames(normalizenames);
        this.quotechar(quotechar);
    }

    public CSVFileSyntax getCSVFileSyntax(FileSyntaxCSV fileSyntaxCSV) {
        return new CSVFileSyntax()
                .header(fileSyntaxCSV.getHeader())
                .delim(StringUtils.isEmpty(fileSyntaxCSV.getDelim()) ? "," : fileSyntaxCSV.getDelim())
                .datarow(fileSyntaxCSV.getDatarow() == null ? -1 : fileSyntaxCSV.getDatarow())
                .escapechar(StringUtils.isEmpty(fileSyntaxCSV.getEscapechar()) ? "\\" : fileSyntaxCSV.getEscapechar())
                .headerRow(fileSyntaxCSV.getHeaderRow() == null ? -1 : fileSyntaxCSV.getHeaderRow())
                .ignorerepeated(fileSyntaxCSV.getIgnorerepeated() == null ? false : fileSyntaxCSV.getIgnorerepeated())
                .missingstrings(fileSyntaxCSV.getMissingstrings())
                .normalizenames(fileSyntaxCSV.getNormalizenames() == null ? false : fileSyntaxCSV.getNormalizenames())
                .quotechar(StringUtils.isEmpty(fileSyntaxCSV.getQuotechar()) ? "\"" : fileSyntaxCSV.getQuotechar());
    }
}
