package com.github.jacekpoz.shop.skins;

import com.badlogic.gdx.utils.Disposable;

import java.util.Random;

public enum PopeSkin implements Skin, Disposable {

    DEFAULT_POPE("Papież", "pope.png", true),
    BIG_POPE("Big Papież", "bigpapiez.png", false),
    SLIME_POPE("Szlapież", "szlapiez.png", false),
    POPE_CRAFT("Craftpież", "craftpiez.png", false),
    DRIP_POPE("Drippież", "drippiez.png", false),
    POPE_CHAMP("Popechamp", "popechamp.png", false),
    POPE_LORD("Papież Lord", "papiezlord.png", false),
    STATUE("Rzeźba", "rzezba.png", false),
    TROLL_POPE("Trollpież", "trollpiez.png", false),
    GHOST_POPE("Duchpież", "duchpiez.png", false),
    EATER_OF_CREAMPIES("Zjadacz Kremówek", "zjadaczkremowek.png", false),
    GMOD_POPE("Modyfikacje Grzegorza Papież", "gmodpope.png", false),
    PIXEL_POPE("Pixelowy Papież", "pixelpapiez.png", false),
    COOMER_POPE("Coomer Papież", "coomerpope.png", false),
    JP("JP2", "jp.jpg", false),
    ROZUM_I_GODNOSC("Rozum i godność człowieka", "rozumigodnosc.jpg", false),
    OBRAZEK("Obrazek Papieża", "obrazek.jpg", false);

    private final String name;
    private final String skinLocation;
    private boolean isUnlocked;

    PopeSkin(String name, String image, boolean isUnlocked) {
        this.name = name;
        this.skinLocation = image;
        this.isUnlocked = isUnlocked;
    }

    @Override
    public boolean isUnlocked() {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Skin getRandomSkin() {
        return values()[new Random().nextInt(values().length)];
    }

    @Override
    public void dispose() {

    }
}
