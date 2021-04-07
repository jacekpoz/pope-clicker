package com.github.jacekpoz.shop.skins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;

import static com.github.jacekpoz.GlobalVars.*;

public enum Background implements Skin, Disposable {
    DEFAULT_BACKGROUND("Domyślne tło", "background.png", true),
    TROLL_BACKGROUND("Troll tło", "trollbackground.jpg", false),
    CHURCH_BACKGROUND("Kościół", "churchbackground.jpg", false),
    MINECRAFT_BACKGROUND("Minecraft tło", "minecraftbackground.png", false),
    TERRARIA_BACKGROUND("Terraria tło", "terrariabackground.png", false);

    private final String name;
    private final String backgroundLocation;
    private boolean isUnlocked;
    private Texture backgroundTexture;
    private Sprite backgroundSprite;

    Background(String backgroundName, String backgroundImage, boolean unlocked) {
        name = backgroundName;
        backgroundLocation = backgroundImage;
        isUnlocked = unlocked;
        backgroundTexture = new Texture(Gdx.files.internal(TEXTURES_LOCATION + BACKGROUNDS_LOCATION + backgroundImage));
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setBounds(0, 0, GAME_WIDTH, GAME_HEIGHT);
    }

    @Override
    public void setSkin(Skin s) {
        if (s instanceof Background) {
            backgroundTexture = new Texture(Gdx.files.internal(TEXTURES_LOCATION + BACKGROUNDS_LOCATION + ((Background) s).backgroundLocation));
            backgroundSprite = new Sprite(backgroundTexture);
            backgroundSprite.setBounds(0, 0, GAME_WIDTH, GAME_HEIGHT);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean isUnlocked() {
        return isUnlocked;
    }

    @Override
    public void unlock() {
        this.isUnlocked = true;
    }

    public Sprite getSprite() {
        return backgroundSprite;
    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
    }
}
