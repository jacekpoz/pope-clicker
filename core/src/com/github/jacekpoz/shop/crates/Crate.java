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

public abstract class Crate implements Buyable {

    private static final float CRATE_IMAGE_SIZE = 200;

    private String crateName;
    private int price;
    private Texture crateTexture;
    private Sprite crateSprite;
    private float crateX, crateY, textX, textY;
    protected Random rand;
    protected boolean isDropping;

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

        rand = new Random();
    }

    @Override
    public abstract void buy();

    protected abstract void showDrop();

    public abstract Skin getDrop();

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

    public boolean isDropping() {
        return isDropping;
    }
}

