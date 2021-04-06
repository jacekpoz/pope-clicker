package com.github.jacekpoz.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import static com.github.jacekpoz.GlobalVars.*;

public class FontUtils {

    private FontUtils() {/*nope*/}

    public static BitmapFont generateFontFromFile(String fileName, int fontSize) {
        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal(FONTS_LOCATION + fileName));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = fontSize;
        param.characters = ALL_CHARS;
        param.color = Color.BLACK;
        BitmapFont font = gen.generateFont(param);
        gen.dispose();
        return font;
    }
}
