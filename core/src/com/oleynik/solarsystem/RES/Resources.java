package com.oleynik.solarsystem.RES;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by MATHAHAKAR on 24.11.2016.
 * vk.com/mathahakar
 * mathahakar1997@gmail.com
 */
public class Resources {

    private static Resources resources = new Resources();

    public static class ImgRes {

        private static TextureAtlas mainAtlas;
        private static Skin SKIN;

        private static ImgRes imgRes = new ImgRes();

        public static final String
                ASTEROID = "asteroid",
                EARTH = "earth",
                JUPITER = "jupiter",
                MARS = "mars",
                MERCURY = "mercury",
                MOON = "moon",
                NEPTUNE = "neptune",
                SATURN = "saturn",
                SUN = "sun",
                URANUS = "uranus",
                VENUS = "venus",
                ORBIT_BIG = "orbit_big",
                ORBIT_SMALL = "orbit_small",
                ORBIT_SUPER_SMALL = "orbit_super_small",
                SCALE = "scale",
                LOGO = "logo",
                BG = "bg",
                BG_B = "bg_b",
                BTN_BG_A = "btn_bg_a",
                BTN_BG_B = "btn_bg_b",
                BTN_GREEN_MASK = "btn_green_mask",
                BTN_NO_MASK = "btn_no_mask",
                BTN_RED_MASK = "btn_red_mask",
                BTN_SATELLITES = "btn_satellites",
                BTN_YELLOW_MASK = "btn_yellow_mask",
                FWD = "fwd",
                FWD_P = "fwd_p",
                MASK_GREEN = "mask_green",
                MASK_RED = "mask_red",
                MASK_YELLOW = "mask_yellow",
                PAUSE = "pause",
                PAUSE_P = "pause_p",
                PLAY = "play",
                PLAY_P = "play_p",
                REW = "rew",
                REW_P = "rew_p";

        public static void loadAtlases () {
            mainAtlas = new TextureAtlas(Gdx.files.internal("PACKS/main/main.atlas"));
            /* CREATING SKIN */
            SKIN = new Skin(mainAtlas);
        }

        public static TextureAtlas.AtlasRegion getRegion (String regionName) {
            return mainAtlas.findRegion(regionName);
        }

        public static Drawable getDrawableFromSkin (String drawableName) {
            return SKIN.getDrawable(drawableName);
        }

    }

    public static class FontRes {

        private static String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяєїіАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯЄЇІáabcdeéfghiíjklmnoópqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.:;,{}\"´`'<>°©™";

        private static BitmapFont
                text_font;

        private static final String
                consola = "consola.ttf";

        public static final int
                TEXT_FONT  = 101;

        /**
         * Конструктор по умолчанию
         */
        private FontRes () {

        }

        /**
         * Метод для загрузки шрифтов (при загрузке игры)
         */
        public static void loadFonts () {
            loadFont(TEXT_FONT, consola, Gdx.graphics.getHeight() * 0.018f);
        }

        /**
         * Метод для загрузки шрифта
         *
         * @param font - переменная шрифта
         * @param path - путь
         * @param size - размер
         */
        private static void loadFont (int font, String path, float size) {
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(path));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = (int) size;
            parameter.characters = FONT_CHARACTERS;
            switch (font) {
                case TEXT_FONT:
                    text_font = generator.generateFont(parameter);
                    text_font.setColor(Color.WHITE);
                    break;
            }

            generator.dispose();
        }

        /**
         * Метод для получения BitmapFont
         *
         * @param font - шрифт (статическая переменная этого класса)
         * @return - возвращаемый шрифт
         */
        public static BitmapFont getFont (int font) {
            switch (font) {
                case TEXT_FONT:
                    return text_font;
                default:
                    return text_font;
            }
        }

    }

    public static void loadResources () {
        ImgRes.loadAtlases();
        FontRes.loadFonts();
    }

}
