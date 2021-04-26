package com.github.jacekpoz.shop.skins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;

import java.util.Random;

import static com.github.jacekpoz.GlobalVars.*;

public enum Soundtrack implements Disposable, Skin {

    ZAWADIAKA("PAPIEŻ ZAWADIAKA", "zawadiaka.mp3", "zawadiakathumbnail.jpg", true),
    BARKA("Barka - Krzysztof Krawczyk", "barka.mp3", "barkathumbnail.jpg",false),
    BARKA_ELECTRO("Wykop - Barka (Electro Version)", "barkaelectro.mp3", "barkaelectrothumbnail.jpg",false),
    DINOZAURY("Wykop - Dinozaury", "dinozaury.mp3", "dinozaurythumbnail.jpg",false),
    WATYKAN_SHUFFLE("Watykan Shuffle", "watykanshuffle.mp3", "watykanshufflethumbnail.jpg",false),
    BARKA_NOTEBLOCK("Barka - Noteblock Cover", "barkanoteblock.mp3", "barkanoteblockthumbnail.jpg",false),
    KREMOWKA("Co się stanie gdy kremówkę dam?", "gdykremowkedam.mp3", "gdykremowkedamthumbnail.jpg",false),
    NABOJ("Nabój daj papieżowi", "nabojdajpapiezowi.mp3", "nabojdajpapiezowithumbnail.jpg",false),
    BARKA_HARDBASS("Hardbass Wadowice", "barkahardbass.mp3", "barkahardbassthumbnail.jpg",false);


    private final String songName;
    private final String songLocation;
    private final Texture thumbnailTexture;
    private final Sprite thumbnailSprite;
    private boolean isUnlocked;
    private Music music;

    Soundtrack(String name, String fileName, String thumbnail, boolean unlocked) {
        songName = name;
        songLocation = fileName;
        thumbnailTexture = new Texture(Gdx.files.internal(TEXTURES_LOCATION + THUMBNAILS_LOCATION + thumbnail));
        thumbnailSprite = new Sprite(thumbnailTexture);
        isUnlocked = unlocked;
        music = Gdx.audio.newMusic(Gdx.files.internal(MUSIC_LOCATION + fileName));
        music.setLooping(true);
    }

    public void play() {
        if (music.isPlaying()) music.stop();
        music.play();
    }

    @Override
    public void setSkin(Skin s) {
        if (s instanceof Soundtrack) {
            music = Gdx.audio.newMusic(Gdx.files.internal(MUSIC_LOCATION + ((Soundtrack) s).songLocation));
            play();
        }
    }

    @Override
    public boolean isUnlocked() {
        return isUnlocked;
    }

    @Override
    public String getName() {
        return songName;
    }

    @Override
    public String getLocation() {
        return songLocation;
    }

    @Override
    public Sprite getSprite() {
        return thumbnailSprite;
    }

    @Override
    public void unlock() {
        isUnlocked = true;
    }

    @Override
    public String toString() {
        return songName + ": " + isUnlocked;
    }

    @Override
    public void dispose() {
        music.dispose();
        thumbnailTexture.dispose();
    }
}
