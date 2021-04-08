package com.github.jacekpoz.upgrades;

import com.github.jacekpoz.util.Scores;

public class TimeUpgrade extends Upgrade {
    public TimeUpgrade(String fileName, String upgradeName, long initialPrice, int upgradeScore, int x, int y) {
        super(fileName, upgradeName, initialPrice, upgradeScore, x, y);
    }

    public TimeUpgrade() {
        super();
    }

    @Override
    public void buy() {
        amount++;
        Scores.subtractScore(price);
        price += (long) Math.log(price * 1.5);
        Scores.addScorePerSecond(score);
        Scores.incrementScore();
    }

}
