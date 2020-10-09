package com.relationalai.client.model;

@lombok.Getter
@lombok.Setter
@lombok.ToString
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Pair<T,U> {
    private T key;
    private U value;

    public Pair key(T key) {
        this.setKey(key);
        return this;
    }

    public Pair value(U value) {
        this.setValue(value);
        return this;
    }
}