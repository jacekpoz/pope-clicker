package com.github.jacekpoz.util;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import java.math.BigInteger;

public class Score implements Json.Serializable {

    private String name;
    private BigInteger actualScore;
    private boolean isStatistic;

    public Score(String n, int initValue, boolean isStat) {
        name = n;
        actualScore = BigInteger.valueOf(initValue);
        isStatistic = isStat;
    }

    public Score() {
        this("null", 0, true);
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

    public boolean isStatistic() {
        return isStatistic;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + actualScore.longValue();
    }

    @Override
    public void write(Json json) {
        json.writeValue("name", name);
        json.writeValue("score", actualScore.longValue());
        json.writeValue("isStat", isStatistic);
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        name = jsonData.get("name").asString();
        actualScore = BigInteger.valueOf(jsonData.get("score").asLong());
        isStatistic = jsonData.get("isStat").asBoolean();
    }
}
