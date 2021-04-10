package com.github.jacekpoz.shop.skins;

import com.badlogic.gdx.graphics.g2d.Sprite;

public interface Skin {

    boolean isUnlocked();

    void unlock();

    void setSkin(Skin s);

    String getName();

    String getLocation();

    Sprite getSprite();

    Skin[] getSkins();

}
