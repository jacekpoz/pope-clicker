package com.github.jacekpoz;

import java.math.BigInteger;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.github.jacekpoz.upgrades.Buyable;

public class Score {

    private Score() {/*nope*/}

    private static BigInteger actualScore = BigInteger.ZERO;

    private static BigInteger totalScore = BigInteger.ZERO;

    private static BigInteger actualScorePerSecond = BigInteger.ZERO;

    private static BigInteger actualScorePerClick = BigInteger.ONE;

    private static Task task = new Task() {
        @Override
        public void run() {
            addScore(getScorePerSecond());
        }
    };

    public static void addScore(long amount) {
        actualScore = actualScore.add(BigInteger.valueOf(amount));
        totalScore = totalScore.add(BigInteger.valueOf(amount));
    }

    public static void subtractScore(long amount) {
        actualScore = actualScore.subtract(BigInteger.valueOf(amount));
    }

    public static long getScore() {
        return actualScore.longValue();
    }

    public static void setScore(long amount) {
        actualScore = BigInteger.valueOf(amount);
    }

    public static long getTotalScore() {
        return totalScore.longValue();
    }

    public static void setTotalScore(long amount) {
        totalScore = BigInteger.valueOf(amount);
    }

    public static void addScorePerSecond(long amount) {
        actualScorePerSecond = actualScorePerSecond.add(BigInteger.valueOf(amount));
    }

    public static void subtractScorePerSecond(long amount) {
        addScorePerSecond(-amount);
    }

    public static long getScorePerSecond() {
        return actualScorePerSecond.longValue();
    }

    public static void setScorePerSecond(long amount) {
        actualScorePerSecond = BigInteger.valueOf(amount);
    }

    public static void addScorePerClick(long amount) {
        actualScorePerClick = actualScorePerClick.add(BigInteger.valueOf(amount));
    }

    public static void subtractScorePerClick(long amount) {
        addScorePerClick(-amount);
    }

    public static long getScorePerClick() {
        return actualScorePerClick.longValue();
    }

    public static void setScorePerClick(long amount) {
        actualScorePerClick = BigInteger.valueOf(amount);
    }

    public static boolean canBuyBuyable(Buyable b) {
        return getScore() >= b.getPrice();
    }

    public static void incrementScore() {
        if (task.isScheduled()) task.cancel();
        task = new Task() {
            @Override
            public void run() {
                addScore(getScorePerSecond());
            }
        };

        Timer.schedule(task, 0.5f, 1);
    }

    public static void addScore() {
        addScore(getScorePerClick());
    }
}
