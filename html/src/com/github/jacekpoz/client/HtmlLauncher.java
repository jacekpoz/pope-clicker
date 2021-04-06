package com.github.jacekpoz.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.freetype.gwt.FreetypeInjector;
import com.badlogic.gdx.graphics.g2d.freetype.gwt.inject.OnCompletion;
import com.github.jacekpoz.PopeClickerGame;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(800, 600);
        return cfg;
    }

    @Override
    public ApplicationListener createApplicationListener() {
        return new PopeClickerGame();
    }

    @Override
    public void onModuleLoad () {
        FreetypeInjector.inject(new OnCompletion() {
            public void run () {
                HtmlLauncher.super.onModuleLoad();
            }
        });
    }
}