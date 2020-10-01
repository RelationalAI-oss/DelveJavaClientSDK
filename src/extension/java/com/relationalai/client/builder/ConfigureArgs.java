package com.relationalai.client.builder;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class ConfigureArgs {
    boolean debug;
    boolean debugTrace;
    boolean broken;
    boolean silent;
    boolean abortOnError;

    @lombok.Builder
    public ConfigureArgs(
        boolean debug,
        boolean debugTrace,
        boolean broken,
        boolean silent,
        boolean abortOnError
    ) {
        this.debug = debug;
        this.debugTrace = debugTrace;
        this.broken = broken;
        this.silent = silent;
        this.abortOnError = abortOnError;
    }
}
