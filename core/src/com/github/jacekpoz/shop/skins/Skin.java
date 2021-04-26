package com.github.jacekpoz.shop.skins;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public interface Skin {

    boolean isUnlocked();

    void unlock();

    void setSkin(Skin s);

    String getName();

    String getLocation();

    Sprite getSprite();

}
