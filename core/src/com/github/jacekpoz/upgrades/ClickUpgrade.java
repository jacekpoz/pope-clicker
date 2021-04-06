package com.github.jacekpoz.upgrades;

import com.github.jacekpoz.Score;

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
        Score.subtractScore(price);
        price += (long) Math.log(price * 1.8);
        Score.addScorePerClick(score);
    }

}
