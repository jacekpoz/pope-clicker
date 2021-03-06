package com.github.jacekpoz.upgrades;

import com.github.jacekpoz.util.Scores;

import static com.github.jacekpoz.GlobalVars.SCORE;
import static com.github.jacekpoz.GlobalVars.SCORE_PER_CLICK;

public class ClickUpgrade extends Upgrade {
    public ClickUpgrade(String fileName, String upgradeName, long initialPrice, int upgradeScore, int x, int y) {
        super(fileName, upgradeName, initialPrice, upgradeScore, x, y);
    }

    public ClickUpgrade() {
        super();
    }

    @Override
    public void buy() {
        amount++;
        Scores.scores.get(SCORE).subtract(price);
        price += (long) Math.log(price * 1.8);
        Scores.scores.get(SCORE_PER_CLICK).add(score);
    }

}
