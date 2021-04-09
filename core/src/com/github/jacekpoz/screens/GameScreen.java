package com.github.jacekpoz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.github.jacekpoz.PopeClickerGame;
import com.github.jacekpoz.util.Scores;

import static com.github.jacekpoz.GlobalVars.POPE;

public class GameScreen implements Screen {

    final PopeClickerGame game;

    public GameScreen(final PopeClickerGame popeClickerGame) {
        game = popeClickerGame;
    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        if (Gdx.input.justTouched()) {
            if (POPE.isTouched()) {
                Scores.click();
            }
        }

        POPE.drawPope(game.batch);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void show() {}

    @Override
    public void hide() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {
        POPE.dispose();
    }

}
