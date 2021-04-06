package com.github.jacekpoz.upgrades;

import com.github.jacekpoz.Score;

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
        Score.subtractScore(price);
        price += (long) Math.log(price * 1.5);
        Score.addScorePerSecond(score);
        Score.incrementScore();
    }

}
