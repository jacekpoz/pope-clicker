package com.github.jacekpoz.util;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.github.jacekpoz.upgrades.Buyable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scores {

    private Scores() {/*nope*/}

    public static Score score = new Score("score");

    public static Score totalScore = new Score("totalScore");

    public static Score scorePerSecond = new Score("scorePerSecond");

    public static Score scorePerClick = new Score("scorePerClick", 1);

    public static List<Score> scores = new ArrayList<>();

    static {
        scores.addAll(Arrays.asList(score, totalScore, scorePerSecond, scorePerClick));
    }

    private static Task task = new Task() {
        @Override
        public void run() {
            score.add(scorePerSecond.get());
        }
    };

    public static boolean canBuyBuyable(Buyable b) {
        return score.get() >= b.getPrice();
    }

    public static void incrementScore() {
        if (task.isScheduled()) task.cancel();
        task = new Task() {
            @Override
            public void run() {
                score.add(scorePerSecond.get());
            }
        };

        Timer.schedule(task, 0.5f, 1);
    }

}
