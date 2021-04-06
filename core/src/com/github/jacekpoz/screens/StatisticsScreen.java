package com.github.jacekpoz.screens;

import com.badlogic.gdx.Screen;
import com.github.jacekpoz.PopeClickerGame;
import com.github.jacekpoz.Score;

public class StatisticsScreen implements Screen {

    final PopeClickerGame game;

    public StatisticsScreen(final PopeClickerGame popeClickerGame) {
        game = popeClickerGame;
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.font.draw(game.batch, "Punkty: " + Score.getTotalScore(), 250, 400);
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
    public void dispose() {}
}