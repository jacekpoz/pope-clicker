package com.github.jacekpoz.upgrades;

import com.github.jacekpoz.util.Scores;

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
        Scores.subtractScore(price);
        price += (long) Math.log(price * 1.8);
        Scores.addScorePerClick(score);
    }

}
