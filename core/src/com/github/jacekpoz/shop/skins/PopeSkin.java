package com.github.jacekpoz.shop.skins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;

import static com.github.jacekpoz.GlobalVars.*;

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
    private Texture popeTexture;
    private Sprite popeSprite;

    PopeSkin(String skinName, String image, boolean unlocked) {
        name = skinName;
        skinLocation = image;
        isUnlocked = unlocked;
        popeTexture = new Texture(Gdx.files.internal(TEXTURES_LOCATION + SKINS_LOCATION + image));
        popeSprite = new Sprite(popeTexture);
        popeSprite.setBounds(Gdx.graphics.getWidth() / 2 - popeSprite.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - popeSprite.getHeight() / 2,
                POPE_SIZE, POPE_SIZE);
    }

    @Override
    public boolean isUnlocked() {
        return isUnlocked;
    }

    @Override
    public void unlock() {
        isUnlocked = true;
    }

    @Override
    public void setSkin(Skin s) {
        if (s instanceof PopeSkin) {
            POPE.setSkin((PopeSkin) s);
        }
    }

    public Sprite getSprite() {
        return popeSprite;
    }

    @Override
    public void dispose() {
        popeTexture.dispose();
    }
}
