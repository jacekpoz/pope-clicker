package com.github.jacekpoz.pope;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

import static com.github.jacekpoz.GlobalVars.*;

public class Pope implements Disposable {

    private static final int POPE_GIF_COLS = 7;

    private Texture popeTexture;
    private Sprite popeSprite;
    private Rectangle hitBox;
    private Animation<TextureRegion> popeGif;
    private Texture popeGifImage;
    private boolean isGif = false;
    private float gifTime = 0f;

    public Pope() {
        popeTexture = new Texture(TEXTURES_LOCATION + POPE_IMAGE);
        popeSprite = new Sprite(popeTexture);
        popeSprite.setSize(300, 300);
        popeSprite.setPosition(Gdx.graphics.getWidth() / 2 - popeSprite.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - popeSprite.getHeight() / 2);
        popeGifImage = new Texture(Gdx.files.internal(TEXTURES_LOCATION + POPE_GIF));

        hitBox = new Rectangle(popeSprite.getX(), popeSprite.getY(),
                popeSprite.getWidth() * popeSprite.getScaleX(),
                popeSprite.getHeight() * popeSprite.getScaleY());

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
            popeSprite.draw(batch);
        }
    }

    public void changePope() {
        isGif = !isGif;
    }

    public Sprite getPopeSprite() {
        return popeSprite;
    }

    public Animation<TextureRegion> getPopeGif() {
        return popeGif;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void dispose() {
        popeTexture.dispose();
        popeGifImage.dispose();
    }
}
