package com.github.jacekpoz.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.github.jacekpoz.PopeClickerGame;
import com.github.jacekpoz.shop.crates.Crate;
import com.github.jacekpoz.shop.skins.Background;
import com.github.jacekpoz.shop.skins.PopeSkin;
import com.github.jacekpoz.shop.skins.Soundtrack;
import com.github.jacekpoz.util.Scores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.github.jacekpoz.GlobalVars.*;

//TODO actually make this

public class ShopScreen implements Screen {

    final PopeClickerGame game;
    private List<Crate> crates;

    private OrthographicCamera camera;
    private Vector3 input;

    public ShopScreen(final PopeClickerGame popeClickerGame) {
        game = popeClickerGame;
        crates = new ArrayList<>();
        Crate<PopeSkin> popeCrate = new Crate<>("Papież skrzynia", 2137, "popecrate.png", 100, 100);
        Crate<Background> backgroundCrate = new Crate<>("Tło skrzynia", 2137, "backgroundcrate.png", 250, 100);
        Crate<Soundtrack> soundtrackCrate = new Crate<>("Muzyka skrzynia", 2137, "soundtrackcrate.png", 400, 100);
        crates.addAll(Arrays.asList(popeCrate, backgroundCrate, soundtrackCrate));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        for (Crate c : crates) {
            c.getSprite().draw(game.batch);
            game.font.draw(game.batch, c.toString(), c.getTextX(), c.getTextY());
        }
        game.batch.end();

        if (Gdx.input.justTouched()) {
            for (Crate c : crates) {
                input = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
                if (c.isTouched(input.x, input.y) && Scores.canBuyBuyable(c)) {
                    c.buy();
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
