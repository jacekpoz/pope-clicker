package com.github.jacekpoz.upgrades;

import com.github.jacekpoz.util.Scores;

import static com.github.jacekpoz.GlobalVars.SCORE;
import static com.github.jacekpoz.GlobalVars.SCORE_PER_SECOND;

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
        Scores.scores.get(SCORE).subtract(price);
        price += (long) Math.log(price * 1.5);
        Scores.scores.get(SCORE_PER_SECOND).add(score);
        Scores.incrementScore();
    }

}
