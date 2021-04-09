package com.github.jacekpoz;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.jacekpoz.screens.*;
import com.github.jacekpoz.shop.skins.Background;
import com.github.jacekpoz.shop.skins.PopeSkin;
import com.github.jacekpoz.shop.skins.Soundtrack;
import com.github.jacekpoz.upgrades.Upgrade;
import com.github.jacekpoz.util.FontUtils;
import com.github.jacekpoz.util.Score;
import com.github.jacekpoz.util.Scores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.github.jacekpoz.GlobalVars.POPE;
import static com.github.jacekpoz.GlobalVars.SCORE_OFFSET;

public class PopeClickerGame extends Game {

    // used for positioning the upgrades on the screen
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
        font = FontUtils.generateFontFromFile("Rubik-Medium.ttf", 16, Color.BLACK);
        setScreen(new MainMenuScreen(this));

        upgrades = new ArrayList<>();

        handler = new SaveAndLoadHandler(this);

        handler.loadAll();

        soundtrack = Soundtrack.ZAWADIAKA;
//        soundtrack.play();
        background = Background.DEFAULT_BACKGROUND;
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.getSprite().draw(batch);

        int scoreY = SCORE_OFFSET;
        for (Score s : Scores.scores.values()) {
            if (!s.isStatistic()) {
                font.draw(batch, s.toString(), 10, scoreY);
                scoreY += SCORE_OFFSET;
            }
        }
        batch.end();

        super.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
            handler.saveAll();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.H)) {
            handler.loadAll();
            Scores.incrementScore();
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

        if (Gdx.input.isKeyJustPressed(Input.Keys.P) && !(screen instanceof GameScreen)) setScreen(new GameScreen(this));

        // debugging, remove for release
        if (Gdx.input.isKeyJustPressed(Input.Keys.Y)) SpecialMode.specialMode();
        if (Gdx.input.isKeyJustPressed(Input.Keys.I)) POPE.setSkin(PopeSkin.values()[new Random().nextInt(PopeSkin.values().length)]);

    }

    public void dispose() {
        batch.dispose();
        background.dispose();
        font.dispose();
        for (Upgrade u : upgrades) {
            u.dispose();
        }
        background.dispose();
        soundtrack.dispose();
    }

}