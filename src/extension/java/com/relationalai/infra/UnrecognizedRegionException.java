package com.relationalai.infra;

public class UnrecognizedRegionException extends Exception
{
    public UnrecognizedRegionException(String name)
    {
        super(name + " is not a known RAI region.");
    }
}
