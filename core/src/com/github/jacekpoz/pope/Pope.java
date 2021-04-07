package com.github.jacekpoz.pope;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;
import com.github.jacekpoz.shop.skins.PopeSkin;

import static com.github.jacekpoz.GlobalVars.POPE_GIF;
import static com.github.jacekpoz.GlobalVars.TEXTURES_LOCATION;

public class Pope implements Disposable {

    private static final int POPE_GIF_COLS = 7;

    private PopeSkin skin = PopeSkin.DEFAULT_POPE;
    private Rectangle hitBox;
    private Animation<TextureRegion> popeGif;
    private Texture popeGifImage;
    private boolean isGif = false;
    private float gifTime = 0f;

    public Pope() {
        popeGifImage = new Texture(Gdx.files.internal(TEXTURES_LOCATION + POPE_GIF));

        hitBox = new Rectangle(skin.getSprite().getX(), skin.getSprite().getY(),
                skin.getSprite().getWidth() * skin.getSprite().getScaleX(),
                skin.getSprite().getHeight() * skin.getSprite().getScaleY());

        TextureRegion[][] temp = TextureRegion.split(popeGifImage,
                popeGifImage.getWidth() / POPE_GIF_COLS,
                popeGifImage.getHeight());

        TextureRegion[] popeFrames = temp[0];

        popeGif = new Animation<>(0.05f, popeFrames);
    }

    public boolean isTouched() {
        return hitBox.contains(Gdx.input.getX(), Gdx.input.getY());
    }

    public void drawPope(SpriteBatch batch) {
        if (isGif) {
            gifTime += Gdx.graphics.getDeltaTime();
            TextureRegion frame = popeGif.getKeyFrame(gifTime, true);
            batch.draw(frame, hitBox.x, hitBox.y, hitBox.width, hitBox.height);
        } else {
            skin.getSprite().draw(batch);
        }
    }

    public void changePope() {
        isGif = !isGif;
    }

    public void setSkin(PopeSkin s) {
        skin = s;
    }

    public void dispose() {
        popeGifImage.dispose();
    }
}
