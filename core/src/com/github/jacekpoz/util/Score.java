package com.github.jacekpoz.util;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import java.math.BigInteger;

public class Score implements Json.Serializable {

    private String name;
    private BigInteger actualScore;

    public Score(String n, int initValue) {
        name = n;
        actualScore = BigInteger.valueOf(initValue);
    }

    public Score(String n) {
        this(n, 0);
    }

    public Score() {
        this("null");
    }

    public void add(long amount) {
        actualScore = actualScore.add(BigInteger.valueOf(amount));
    }

    public void subtract(long amount) {
        actualScore = actualScore.subtract(BigInteger.valueOf(amount));
    }

    public void set(long amount) {
        actualScore = BigInteger.valueOf(amount);
    }

    public long get() {
        return actualScore.longValue();
    }

    @Override
    public String toString() {
        return name + ": " + actualScore.longValue();
    }

    @Override
    public void write(Json json) {
        json.writeValue("name", name);
        json.writeValue("score", actualScore.longValue());
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        name = jsonData.get("name").asString();
        actualScore = BigInteger.valueOf(jsonData.get("score").asLong());
    }
}
