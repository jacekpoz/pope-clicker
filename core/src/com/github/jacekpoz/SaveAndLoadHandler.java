package com.github.jacekpoz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.github.jacekpoz.upgrades.Upgrade;
import com.github.jacekpoz.util.Score;
import com.github.jacekpoz.util.Scores;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.github.jacekpoz.GlobalVars.*;

//TODO if you're reviewing the code, either ignore this piece of shit or help me out with it
// I have no idea how to make this actually work, this is what I could make by myself
// by release it should be: all upgrades in 1 file, all skins in 1 file and then all the scores and stats in another file
// the only things I found for json in libGDX is the wiki page, which didn't give me much info on how to do this
// and a tutorial from about 2013 by some German (?) guy who uploaded the code to bitbucket I think
// so yeah that doesn't help at all I just gotta learn by myself I guess

public class SaveAndLoadHandler {

    final PopeClickerGame game;
    private Json json;

    public SaveAndLoadHandler(final PopeClickerGame popeClickerGame) {
        game = popeClickerGame;
        json = new Json();
    }

    public void saveAll() {
        saveUpgrades();
        saveScores();
    }

    public void loadAll() {
        loadUpgrades();
        loadScores();
    }

    public void saveUpgrades() {
        Upgrade[] u = game.upgrades.toArray(new Upgrade[0]);
        json.toJson(u, u.getClass(), Gdx.files.local(JSON_LOCATION + UPGRADES_FILE));
    }

    public void loadUpgrades() {
        game.upgrades.clear();
        game.upgrades.addAll(Arrays.asList(
                json.fromJson(Upgrade[].class, Gdx.files.local(JSON_LOCATION + UPGRADES_FILE))));
    }

    public void saveScores() {
        Map<String, Score> s = Scores.scores;
        json.toJson(s, s.getClass(), Gdx.files.local(JSON_LOCATION + SCORES_FILE));
    }

    public void loadScores() {
        Scores.scores.clear();
        Scores.scores.putAll(json.fromJson(HashMap.class, Gdx.files.local(JSON_LOCATION + SCORES_FILE)));
    }
}
