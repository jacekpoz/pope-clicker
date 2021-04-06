package com.github.jacekpoz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.github.jacekpoz.PopeClickerGame;
import com.github.jacekpoz.Score;

public class GameScreen implements Screen {
    final PopeClickerGame game;


    public GameScreen(final PopeClickerGame popeClickerGame) {
        game = popeClickerGame;
    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        if (Gdx.input.justTouched()) {
            if (game.pope.isTouched()) {
                Score.addScore();
            }
        }

        game.pope.drawPope(game.batch);

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
        game.pope.dispose();
    }

}
