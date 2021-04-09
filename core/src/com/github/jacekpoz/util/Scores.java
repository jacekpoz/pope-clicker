package com.github.jacekpoz.util;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.github.jacekpoz.upgrades.Buyable;

import java.util.*;

import static com.github.jacekpoz.GlobalVars.*;

public class Scores {

    private Scores() {/*nope*/}

//    public static Score score = new Score(SCORE, 0, false);
//
//    public static Score totalScore = new Score(TOTAL_SCORE, 0, true);
//
//    public static Score scorePerSecond = new Score(SCORE_PER_SECOND, 0, false);
//
//    public static Score scorePerClick = new Score(SCORE_PER_CLICK, 1, false);

    public static Map<String, Score> scores = new HashMap<>();

//    static {
//        scores.put(score.getName(), score);
//        scores.put(totalScore.getName(), totalScore);
//        scores.put(scorePerSecond.getName(), scorePerSecond);
//        scores.put(scorePerClick.getName(), scorePerClick);
//    }

    private static Task task = new Task() {
        @Override
        public void run() {
            scores.get(SCORE).add(scores.get(SCORE_PER_SECOND).get());
        }
    };

    public static boolean canBuyBuyable(Buyable b) {
        return scores.get(SCORE).get() >= b.getPrice();
    }

    public static void incrementScore() {
        if (task.isScheduled()) task.cancel();
        task = new Task() {
            @Override
            public void run() {
                scores.get(SCORE).add(scores.get(SCORE_PER_SECOND).get());
            }
        };

        Timer.schedule(task, 0.5f, 1);
    }

    public static void click() {
        scores.get(SCORE).add(scores.get(SCORE_PER_CLICK).get());
    }

}
