package com.github.jacekpoz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.github.jacekpoz.upgrades.Upgrade;
import com.github.jacekpoz.util.Scores;

import java.util.Arrays;

import static com.github.jacekpoz.GlobalVars.*;

//TODO if you're reviewing the code, either ignore this piece of shit or help me out with it
// I have no idea how to make this actually work, this is what I could make by myself
// by release it should be: all upgrades in 1 file, all skins in 1 file and then all the scores and stats in another file
// the only things I found for json in libGDX is the wiki page, which didn't give me much info on how to do this
// and a tutorial from about 2013 by some German (?) guy who uploaded the code to bitbucket I think
// so yeah that doesn't help at all I just gotta learn by myself I guess

public class SaveAndLoadHandler {

    final PopeClickerGame game;

    public SaveAndLoadHandler(final PopeClickerGame popeClickerGame) {
        game = popeClickerGame;
    }

    public void saveUpgrades() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);

        Upgrade[] u = game.upgrades.toArray(new Upgrade[0]);
        json.toJson(u, u.getClass(), Gdx.files.local(JSON_LOCATION + "upgrades.json"));

//        for (Upgrade u : game.upgrades) {
//            json.toJson(u, u.getClass(), Gdx.files.local(JSON_LOCATION + UPGRADES_LOCATION +
//                    u.getName().toLowerCase() + ".json"));
//        }
    }

    public void loadUpgrades() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);

        game.upgrades.clear();
        game.upgrades.addAll(Arrays.asList(
                json.fromJson(Upgrade[].class, Gdx.files.local(JSON_LOCATION + "upgrades.json"))));

//        for (Upgrade u : game.upgrades) {
//            u.set(json.fromJson(u.getClass(), Gdx.files.local(JSON_LOCATION + UPGRADES_LOCATION +
//                    u.getName().toLowerCase() + ".json")));
//        }
    }

    public void saveScores() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        long[] jsonValues = {
                Scores.getScore(),
                Scores.getTotalScore(),
                Scores.getScorePerSecond(),
                Scores.getScorePerClick()
        };
        json.toJson(jsonValues, long[].class, Gdx.files.local(JSON_LOCATION + SCORES_FILE));
    }

    public void loadScores() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        long[] jsonValues = json.fromJson(long[].class, Gdx.files.local(JSON_LOCATION + SCORES_FILE));
        Scores.setScore(jsonValues[0]);
        Scores.setTotalScore(jsonValues[1]);
        Scores.setScorePerSecond(jsonValues[2]);
        Scores.setScorePerClick(jsonValues[3]);
    }
}
