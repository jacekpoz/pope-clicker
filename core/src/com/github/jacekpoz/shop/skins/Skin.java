package com.github.jacekpoz.shop.skins;

public interface Skin {

    boolean isUnlocked();

    void unlock();

    Skin getRandomSkin();
}
