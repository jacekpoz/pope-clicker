package com.github.jacekpoz.shop.crates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.jacekpoz.shop.skins.Skin;
import com.github.jacekpoz.upgrades.Buyable;

import java.util.Random;

import static com.github.jacekpoz.GlobalVars.CRATES_LOCATION;
import static com.github.jacekpoz.GlobalVars.TEXTURES_LOCATION;

//TODO actually make this class with generics hopefully

public class Crate<S extends Skin> implements Buyable {

    private static final float CRATE_IMAGE_SIZE = 200;

    private String crateName;
    private int price;
    private Texture crateTexture;
    private Sprite crateSprite;
    private S skin;
    private float crateX, crateY, textX, textY;

    public Crate(String name, int p, String fileName, float x, float y) {
        crateName = name;
        price = p;
        crateTexture = new Texture(Gdx.files.internal(TEXTURES_LOCATION + CRATES_LOCATION + fileName));
        crateSprite = new Sprite(crateTexture);
        crateSprite.setBounds(x, y, CRATE_IMAGE_SIZE, CRATE_IMAGE_SIZE);
        crateX = x;
        crateY = y;

        textX = crateX + CRATE_IMAGE_SIZE / 8;
        textY = crateY - 10;
    }

    @Override
    public void buy() {
        skin = getRandomSkin();
        skin.unlock();
    }

    private S getRandomSkin() {
        return (S) skin.getSkins()[new Random().nextInt(skin.getSkins().length)];
    }

    @Override
    public long getPrice() {
        return price;
    }

    @Override
    public boolean isTouched(float x, float y) {
        return crateSprite.getBoundingRectangle().contains(x, y);
    }

    public Sprite getSprite() {
        return crateSprite;
    }

    public float getTextX() {
        return textX;
    }

    public float getTextY() {
        return textY;
    }

    @Override
    public String toString() {
        return crateName + "\nCena: " + price;
    }
}

