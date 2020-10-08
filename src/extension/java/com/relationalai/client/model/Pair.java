package com.relationalai.client.model;

@lombok.Getter
@lombok.Setter
@lombok.ToString
@lombok.AllArgsConstructor
public class Pair<T,U> {
    private T key;
    private U value;
}