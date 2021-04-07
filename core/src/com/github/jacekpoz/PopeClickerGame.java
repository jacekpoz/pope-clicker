package com.github.jacekpoz;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.jacekpoz.screens.*;
import com.github.jacekpoz.shop.skins.Background;
import com.github.jacekpoz.shop.skins.Soundtrack;
import com.github.jacekpoz.upgrades.ClickUpgrade;
import com.github.jacekpoz.upgrades.TimeUpgrade;
import com.github.jacekpoz.upgrades.Upgrade;
import com.github.jacekpoz.util.FontUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopeClickerGame extends Game {

    private static final int UPGRADE_Y = 500;
    private static final int UPGRADE_X_OFFSET = 125;
    private static final int UPGRADE_Y_OFFSET = 150;

    public SpriteBatch batch;
    public BitmapFont font;

    public List<Upgrade> upgrades;

    public SaveAndLoadHandler handler;

    public Soundtrack soundtrack;
    public Background background;

    public void create() {
        batch = new SpriteBatch();
        font = FontUtils.generateFontFromFile("Rubik-Medium.ttf", 16);
        setScreen(new MainMenuScreen(this));
        upgrades = new ArrayList<>();
        Upgrade kremowka = new TimeUpgrade("kremowka.png",
                "Kremówka", 5, 1,
                10, UPGRADE_Y);
        Upgrade rzezba = new TimeUpgrade("rzezba.png",
                "Rzeźba", 8, 2,
                10 + UPGRADE_X_OFFSET, UPGRADE_Y);
        Upgrade marysia = new TimeUpgrade("mary.jpg",
                "Marysia", 11, 3,
                10 + UPGRADE_X_OFFSET * 2, UPGRADE_Y);
        Upgrade szpinak = new TimeUpgrade("spinach.png",
                "Szpinak", 14, 4,
                10 + UPGRADE_X_OFFSET * 3, UPGRADE_Y);
        Upgrade dziwisz = new TimeUpgrade("dziwisz.jpg",
                "Kard. Dziwisz", 17, 5,
                10 + UPGRADE_X_OFFSET * 4, UPGRADE_Y);
        Upgrade vatican = new TimeUpgrade("vatican.jpg",
                "Watykan", 20, 6,
                10 + UPGRADE_X_OFFSET * 5, UPGRADE_Y);

        Upgrade pilka = new ClickUpgrade("football.png",
                "Piłka", 20, 1,
                10, UPGRADE_Y - UPGRADE_Y_OFFSET);
        Upgrade barka = new ClickUpgrade("barka.jpg",
                "Barka", 30, 2,
                10 + UPGRADE_X_OFFSET, UPGRADE_Y - UPGRADE_Y_OFFSET);
        Upgrade magik = new ClickUpgrade("magik.png",
                "Magik", 40, 3,
                10 + UPGRADE_X_OFFSET * 2, UPGRADE_Y - UPGRADE_Y_OFFSET);
        Upgrade jesus = new ClickUpgrade("jesus.png",
                "Jezus", 50, 4,
                10 + UPGRADE_X_OFFSET * 3, UPGRADE_Y - UPGRADE_Y_OFFSET);
        Upgrade dinosaur = new ClickUpgrade("dinosaur.png",
                "Dinozaur", 60, 5,
                10 + UPGRADE_X_OFFSET * 4, UPGRADE_Y - UPGRADE_Y_OFFSET);
        Upgrade papamobile = new ClickUpgrade("papamobile.jpg",
                "Papamobile", 70, 6,
                10 + UPGRADE_X_OFFSET * 5, UPGRADE_Y - UPGRADE_Y_OFFSET);
        upgrades.addAll(Arrays.asList(
                kremowka, rzezba, marysia, szpinak, dziwisz, vatican,
                pilka, barka, magik, jesus, dinosaur, papamobile
        ));

        handler = new SaveAndLoadHandler(this);

        soundtrack = Soundtrack.ZAWADIAKA;
//        soundtrack.play();
        background = Background.DEFAULT_BACKGROUND;
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.getSprite().draw(batch);
        font.draw(batch, "Punkty: " + Score.getScore(), 10, 75);
        font.draw(batch, "Punkty na sekundę: " + Score.getScorePerSecond(), 10, 50);
        font.draw(batch, "Punkty za kliknięcie: " + Score.getScorePerClick(), 10, 25);
        batch.end();
        super.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
            handler.saveUpgrades();
            handler.saveScores();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.H)) {
            handler.loadUpgrades();
            handler.loadScores();
            Score.incrementScore();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.U)) {
            if (screen instanceof UpgradesScreen) setScreen(new GameScreen(this));
            else setScreen(new UpgradesScreen(this));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            if (screen instanceof StatisticsScreen) setScreen(new GameScreen(this));
            else setScreen(new StatisticsScreen(this));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {
            if (screen instanceof ShopScreen) setScreen(new GameScreen(this));
            else setScreen(new ShopScreen(this));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) setScreen(new GameScreen(this));

        if (Gdx.input.isKeyJustPressed(Input.Keys.Y)) SpecialMode.specialMode();

    }

    public void dispose() {
        batch.dispose();
        background.dispose();
        font.dispose();
        for (Upgrade u : upgrades) {
            u.dispose();
        }

    }

}