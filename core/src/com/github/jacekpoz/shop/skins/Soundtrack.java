package com.github.jacekpoz.shop.skins;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Disposable;

import static com.github.jacekpoz.GlobalVars.MUSIC_LOCATION;

public enum Soundtrack implements Disposable, Skin {

    ZAWADIAKA("PAPIEŻ ZAWADIAKA", "zawadiaka.mp3", true),
    BARKA("Barka - Krzysztof Krawczyk", "barka.mp3", false),
    BARKA_ELECTRO("Wykop - Barka (Electro Version)", "barkaelectro.mp3", false),
    DINOZAURY("Wykop - Dinozaury", "dinozaury.mp3", false),
    WATYKAN_SHUFFLE("Watykan Shuffle", "watykanshuffle.mp3", false),
    BARKA_NOTEBLOCK("Barka - Noteblock Cover", "barkanoteblock.mp3", false),
    KREMOWKA("Co się stanie gdy kremówkę dam?", "gdykremowkedam.mp3", false),
    NABOJ("Nabój daj papieżowi", "nabojdajpapiezowi.mp3", false),
    BARKA_HARDBASS("Hardbass Wadowice", "barkahardbass.mp3", false);


    private final String songName;
    private final String songLocation;
    private boolean isUnlocked;
    private Music music;

    Soundtrack(String name, String fileName, boolean unlocked) {
        songName = name;
        songLocation = fileName;
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
    public void unlock() {
        isUnlocked = true;
    }

    @Override
    public void dispose() {
        music.dispose();
    }
}
