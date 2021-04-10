package com.github.jacekpoz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.github.jacekpoz.PopeClickerGame;
import com.github.jacekpoz.util.Scores;
import com.github.jacekpoz.upgrades.Upgrade;

// I guess this is fine but could use a bit more work like scrolling when there's more upgrades or shit idk

public class UpgradesScreen implements Screen {

    final PopeClickerGame game;

    //TODO ok so I added the camera in here after it didn't work without it and smarter people told me to do so
    // I gotta learn about the cameras in here and then implement it in a way which doesn't hurt anybody's eyes

    OrthographicCamera camera;
    Vector3 input;

    public UpgradesScreen(final PopeClickerGame popeClickerGame) {
        game = popeClickerGame;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        for (Upgrade u : game.upgrades) {
            u.getSprite().draw(game.batch);
            game.font.draw(game.batch, u.toString(), u.getTextX(), u.getTextY());
        }
        game.batch.end();

        if (Gdx.input.justTouched()) {
            for (Upgrade u : game.upgrades) {
                input = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (u.isTouched(input.x, input.y) && Scores.canBuyBuyable(u)) {
                    u.buy();
                }
            }
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
