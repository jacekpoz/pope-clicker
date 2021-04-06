package com.github.jacekpoz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.github.jacekpoz.PopeClickerGame;

public class MainMenuScreen implements Screen {

    final PopeClickerGame game;

    public MainMenuScreen(final PopeClickerGame popeClickerGame) {
        game = popeClickerGame;
    }

    @Override
    public void render(float delta) {

        game.batch.begin();
        game.font.draw(game.batch, "Papież Clicker", Gdx.graphics.getWidth() / 2, 400);
        game.font.draw(game.batch, "0.7", Gdx.graphics.getWidth() / 2, 350);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
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
    public void dispose() {}
}
