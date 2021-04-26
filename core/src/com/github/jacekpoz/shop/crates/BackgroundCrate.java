package com.github.jacekpoz.shop.crates;

import com.github.jacekpoz.shop.skins.Background;
import com.github.jacekpoz.shop.skins.Skin;
import com.github.jacekpoz.util.Scores;

import static com.github.jacekpoz.GlobalVars.SCORE;

public class BackgroundCrate extends Crate {

    private Background drop;

    public BackgroundCrate(String name, int p, String fileName, float x, float y) {
        super(name, p, fileName, x, y);
    }

    @Override
    public void buy() {
        Scores.scores.get(SCORE).subtract(getPrice());
        drop = Background.values()[rand.nextInt(Background.values().length)];
        for (Background background : Background.values()) System.out.println(background);
        System.out.println();
        drop.unlock();
        showDrop();
    }

    @Override
    protected void showDrop() {
        isDropping = true;
        for (int i = 0; i <= 265; i++) {
            drop.getSprite().setAlpha(i);
        }

        for (int i = 265; i >= 0; i--) {
            drop.getSprite().setAlpha(i);
        }
        isDropping = false;
    }

    @Override
    public Skin getDrop() {
        return drop;
    }
}
