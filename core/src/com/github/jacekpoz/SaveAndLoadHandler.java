package com.github.jacekpoz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.github.jacekpoz.upgrades.Upgrade;

import java.util.regex.Pattern;

import static com.github.jacekpoz.GlobalVars.*;

public class SaveAndLoadHandler {

    final PopeClickerGame game;

    public SaveAndLoadHandler(final PopeClickerGame popeClickerGame) {
        game = popeClickerGame;
    }

    public void saveUpgrades() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        for (Upgrade u : game.upgrades) {
            json.toJson(u, u.getClass(), Gdx.files.local(JSON_LOCATION + UPGRADES_LOCATION +
                    u.getName().toLowerCase() + ".json"));
        }
    }

    public void loadUpgrades() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        for (Upgrade u : game.upgrades) {
            u.set(json.fromJson(u.getClass(), Gdx.files.local(JSON_LOCATION + UPGRADES_LOCATION +
                    u.getName().toLowerCase() + ".json")));
        }
    }

    public void saveScores() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        long[] jsonValues = {
                Score.getScore(),
                Score.getTotalScore(),
                Score.getScorePerSecond(),
                Score.getScorePerClick()
        };
        json.toJson(jsonValues, long[].class, Gdx.files.local(JSON_LOCATION + SCORES_FILE));
    }

    public void loadScores() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        long[] jsonValues = json.fromJson(long[].class, Gdx.files.local(JSON_LOCATION + SCORES_FILE));
        Score.setScore(jsonValues[0]);
        Score.setTotalScore(jsonValues[1]);
        Score.setScorePerSecond(jsonValues[2]);
        Score.setScorePerClick(jsonValues[3]);
    }
}
