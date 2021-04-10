package com.github.jacekpoz.upgrades;

public interface Buyable {

    void buy();

    long getPrice();

    boolean isTouched(float x, float y);
}
