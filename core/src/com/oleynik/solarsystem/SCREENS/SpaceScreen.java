package com.oleynik.solarsystem.SCREENS;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.oleynik.solarsystem.GdxGameCore;
import com.oleynik.solarsystem.OBJ.RandomParticles;
import com.oleynik.solarsystem.OBJ.SolarSys;
import com.oleynik.solarsystem.RES.Resources;

/**
 * Created by MATHAHAKAR on 25.11.2016.
 * vk.com/mathahakar
 * mathahakar1997@gmail.com
 */
public class SpaceScreen implements Screen {

    final GdxGameCore game;
    private Stage stage;
    private Background background;
    private BackgroundMask backgroundMask;
    private ScaleImg scaleImg;
    private SolarSys sSys;
    private RandomParticles randomParticles;
    private Controls controls;
    private PersonalizationControls pControls;

    private Label.LabelStyle ls;
    private Label stateLabel;
    private Label angleLabel;
    private Label infoLabel;

    private static String infoStr;
    private String defaultInfo = "Solar System\n" +
            "The Solar System is the gravitationally bound system comprising the Sun and the objects that " +
            "orbit it, either directly or indirectly.\n" +
            "The Solar System formed 4.6 billion years ago from the gravitational collapse of a giant " +
            "interstellar molecular cloud. The vast majority of the system's mass is in the Sun, with most " +
            "of the remaining mass contained in Jupiter. The four smaller inner planets, Mercury, Venus, " +
            "Earth and Mars, are terrestrial planets, being primarily composed of rock and metal. The four " +
            "outer planets are giant planets, being substantially more massive than the terrestrials. " +
            "The two largest, Jupiter and Saturn, are gas giants, being composed mainly of hydrogen and " +
            "helium; the two outermost planets, Uranus and Neptune, are ice giants, being composed mostly " +
            "of substances with relatively high melting points compared with hydrogen and helium, called " +
            "volatiles, such as water, ammonia and methane. All planets have almost circular orbits that " +
            "lie within a nearly flat disc called the ecliptic.";

    private boolean isStarted = false;

    class ScaleImg extends Actor {

        @Override
        public void draw(Batch batch, float parentAlpha) {
            Color color = this.getColor();
            batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
            batch.draw(Resources.ImgRes.getRegion(Resources.ImgRes.SCALE),
                    getX(), getY(), getWidth() / 2.0f, getHeight() / 2.0f, getWidth(),
                    getHeight(), 1, 1, getRotation());
            super.draw(batch, batch.getColor().a);
        }

    }

    class Background extends Actor {

        private TextureAtlas.AtlasRegion region;
        public static final int A = 1, B = 2;

        public Background () {
            setRegion(A);
        }

        public void setRegion (int bg) {
            switch (bg) {
                case A:
                    region = Resources.ImgRes.getRegion(Resources.ImgRes.BG);
                    break;
                case B:
                    region = Resources.ImgRes.getRegion(Resources.ImgRes.BG_B);
                    break;
                default:
                    region = Resources.ImgRes.getRegion(Resources.ImgRes.BG);
                    break;
            }
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            Color color = this.getColor();
            batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
            batch.draw(region, getX(), getY(), getWidth(), getHeight());
            super.draw(batch, batch.getColor().a);
        }

    }

    class BackgroundMask extends Actor {

        private TextureAtlas.AtlasRegion region;
        public static final int NO = 0, RED = 1, YELLOW = 2, GREEN = 3;

        public BackgroundMask () {
            setMask(NO);
        }

        public void setMask (int mask) {
            if (mask != NO) {

                switch (mask) {
                    case RED:
                        region = Resources.ImgRes.getRegion(Resources.ImgRes.MASK_RED);
                        break;
                    case YELLOW:
                        region = Resources.ImgRes.getRegion(Resources.ImgRes.MASK_YELLOW);
                        break;
                    case GREEN:
                        region = Resources.ImgRes.getRegion(Resources.ImgRes.MASK_GREEN);
                        break;
                }

                this.setVisible(true);

            } else {
                this.setVisible(false);
            }
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            Color color = this.getColor();
            batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
            batch.draw(region, getX(), getY(), getWidth(), getHeight());
            super.draw(batch, batch.getColor().a);
        }

    }

    class Controls extends Group {

        private float w, h;

        private ImageButton.ImageButtonStyle styleREW, stylePLAY, stylePAUSE, styleFWD;
        private ImageButton btnREW, btnPLAY, btnPAUSE, btnFWD;

        private float separator;
        private float btnSize;

        public Controls (float height) {
            this.h = height;
            this.w = height * 4;

            this.setSize(w, h);

            styleREW = new ImageButton.ImageButtonStyle();
            styleREW.up = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.REW);
            styleREW.down = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.REW_P);
            styleREW.checked = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.REW);

            stylePLAY = new ImageButton.ImageButtonStyle();
            stylePLAY.up = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.PLAY);
            stylePLAY.down = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.PLAY_P);
            stylePLAY.checked = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.PLAY);

            stylePAUSE = new ImageButton.ImageButtonStyle();
            stylePAUSE.up = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.PAUSE);
            stylePAUSE.down = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.PAUSE_P);
            stylePAUSE.checked = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.PAUSE);

            styleFWD = new ImageButton.ImageButtonStyle();
            styleFWD.up = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.FWD);
            styleFWD.down = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.FWD_P);
            styleFWD.checked = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.FWD);

            btnSize = this.getHeight() * 0.9f;
            separator = (this.getWidth() - (btnSize * 4)) / 3;

            btnREW = new ImageButton(styleREW);
            btnPLAY = new ImageButton(stylePLAY);
            btnPAUSE = new ImageButton(stylePAUSE);
            btnFWD = new ImageButton(styleFWD);

            btnREW.setSize(btnSize, btnSize);
            btnPLAY.setSize(btnSize, btnSize);
            btnPAUSE.setSize(btnSize, btnSize);
            btnFWD.setSize(btnSize, btnSize);

            btnREW.setPosition(0, this.getHeight() / 2 - (btnSize / 2));
            btnPLAY.setPosition(btnSize + separator, this.getHeight() / 2 - (btnSize / 2));
            btnPAUSE.setPosition(btnSize * 2 + separator * 2, this.getHeight() / 2 - (btnSize / 2));
            btnFWD.setPosition(btnSize * 3 + separator * 3, this.getHeight() / 2 - (btnSize / 2));

            this.addActor(btnREW);
            this.addActor(btnPLAY);
            this.addActor(btnPAUSE);
            this.addActor(btnFWD);

            btnREW.addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    sSys.setSpeedMultiplier(-100);
                    super.touchUp(event, x, y, pointer, button);
                }
            });

            btnFWD.addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    sSys.setSpeedMultiplier(100);
                    super.touchUp(event, x, y, pointer, button);
                }
            });

            btnPLAY.addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    sSys.setPause(false);
                    isStarted = true;
                    super.touchUp(event, x, y, pointer, button);
                }
            });

            btnPAUSE.addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    sSys.setPause(true);
                    super.touchUp(event, x, y, pointer, button);
                }
            });

        }

    }

    class PersonalizationControls extends Group {

        private float w, h;
        private Image btnNoMask, btnRedMask, btnYellowMask, btnGreenMask;
        private Image btnBgA, btnBgB;
        private TextButton.TextButtonStyle tbs;
        private TextButton btnSatellites;

        private boolean satellites = true;

        private float btnSize;
        private float separator;

        public PersonalizationControls (float width) {
            this.w = width;
            btnSize = (this.w * 0.95f) / 4;
            separator = (this.w - (btnSize * 4)) / 3;
            this.h = btnSize * 3 + separator * 2;

            this.setSize(w, h);

            btnNoMask = new Image(Resources.ImgRes.getRegion(Resources.ImgRes.BTN_NO_MASK));
            btnRedMask = new Image(Resources.ImgRes.getRegion(Resources.ImgRes.BTN_RED_MASK));
            btnYellowMask = new Image(Resources.ImgRes.getRegion(Resources.ImgRes.BTN_YELLOW_MASK));
            btnGreenMask = new Image(Resources.ImgRes.getRegion(Resources.ImgRes.BTN_GREEN_MASK));
            btnBgA = new Image(Resources.ImgRes.getRegion(Resources.ImgRes.BTN_BG_A));
            btnBgB = new Image(Resources.ImgRes.getRegion(Resources.ImgRes.BTN_BG_B));

            tbs = new TextButton.TextButtonStyle();
            tbs.up = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.BTN_SATELLITES);
            tbs.down = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.BTN_SATELLITES);
            tbs.checked = Resources.ImgRes.getDrawableFromSkin(Resources.ImgRes.BTN_SATELLITES);
            tbs.font = Resources.FontRes.getFont(Resources.FontRes.TEXT_FONT);
            tbs.fontColor = new Color(100, 100, 255, 1);

            btnSatellites = new TextButton("HIDE SATELLITES", tbs);

            btnNoMask.setSize(btnSize, btnSize);
            btnRedMask.setSize(btnSize, btnSize);
            btnYellowMask.setSize(btnSize, btnSize);
            btnGreenMask.setSize(btnSize, btnSize);
            btnBgA.setSize((btnSize * 2) + separator, btnSize);
            btnBgB.setSize((btnSize * 2) + separator, btnSize);

            btnSatellites.setSize(this.getWidth(), btnSize);

            btnNoMask.setPosition(0, this.getHeight() / 2 - (btnSize / 2));
            btnRedMask.setPosition(btnSize + separator, this.getHeight() / 2 - (btnSize / 2));
            btnYellowMask.setPosition(btnSize * 2 + separator * 2, this.getHeight() / 2 - (btnSize / 2));
            btnGreenMask.setPosition(btnSize * 3 + separator * 3, this.getHeight() / 2 - (btnSize / 2));
            btnBgA.setPosition(0, this.getHeight() - btnSize);
            btnBgB.setPosition(this.getWidth() - (btnSize * 2), this.getHeight() - btnSize);

            btnSatellites.setPosition(this.getWidth() / 2 - (btnSatellites.getWidth() / 2), 0);

            this.addActor(btnNoMask);
            this.addActor(btnRedMask);
            this.addActor(btnYellowMask);
            this.addActor(btnGreenMask);
            this.addActor(btnBgA);
            this.addActor(btnBgB);
            this.addActor(btnSatellites);

            btnSatellites.addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    if (satellites) {
                        satellites = false;
                        sSys.setSatellitesVisible(false);
                        btnSatellites.setText("SHOW SATELLITES");
                    } else {
                        satellites = true;
                        sSys.setSatellitesVisible(true);
                        btnSatellites.setText("HIDE SATELLITES");
                    }
                    super.touchUp(event, x, y, pointer, button);
                }
            });

            btnBgA.addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    background.setRegion(Background.A);
                    super.touchUp(event, x, y, pointer, button);
                }
            });

            btnBgB.addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    background.setRegion(Background.B);
                    super.touchUp(event, x, y, pointer, button);
                }
            });

            btnRedMask.addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    backgroundMask.setMask(BackgroundMask.RED);
                    super.touchUp(event, x, y, pointer, button);
                }
            });

            btnGreenMask.addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    backgroundMask.setMask(BackgroundMask.GREEN);
                    super.touchUp(event, x, y, pointer, button);
                }
            });

            btnYellowMask.addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    backgroundMask.setMask(BackgroundMask.YELLOW);
                    super.touchUp(event, x, y, pointer, button);
                }
            });

            btnNoMask.addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    backgroundMask.setMask(BackgroundMask.NO);
                    super.touchUp(event, x, y, pointer, button);
                }
            });


        }

    }


    public SpaceScreen (GdxGameCore game) {
        this.game = game;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        ls = new Label.LabelStyle(Resources.FontRes.getFont(Resources.FontRes.TEXT_FONT), Color.CYAN);

        /* INIT ACTORS */

        background = new Background();
        background.setSize(stage.getWidth(), stage.getHeight());

        backgroundMask = new BackgroundMask();
        backgroundMask.setSize(stage.getWidth(), stage.getHeight());

        scaleImg = new ScaleImg();
        scaleImg.setSize(stage.getHeight() * 0.98f, stage.getHeight() * 0.98f);
        scaleImg.setPosition
                (stage.getWidth() / 2 - (scaleImg.getWidth() / 2),
                stage.getHeight() / 2 - (scaleImg.getHeight() / 2));
        scaleImg.setTouchable(Touchable.disabled);

        sSys = new SolarSys(stage.getHeight() * 0.8f);
        sSys.setPosition(stage.getWidth() / 2 - (sSys.getWidth() / 2), stage.getHeight() / 2 - (sSys.getHeight() / 2));

        controls = new Controls(stage.getHeight() * 0.065f);
        controls.setPosition
                (controls.getWidth() * 0.05f,
                stage.getHeight() - controls.getHeight() - (controls.getWidth() * 0.05f));

        pControls = new PersonalizationControls(stage.getWidth() * 0.12f);
        pControls.setPosition(stage.getWidth() - (pControls.getWidth()) - (pControls.getWidth() * 0.05f),
                pControls.getWidth() * 0.05f);

        stateLabel = new Label("LOADING\nLOADING\nLOADING", ls);
        stateLabel.setWidth(sSys.getX() - controls.getRight());
        stateLabel.setPosition
                (controls.getRight() + controls.getWidth() * 0.05f,
                controls.getY() + (controls.getHeight() / 2 - (stateLabel.getHeight() / 2)));

        angleLabel = new Label("LOADING\nLOADING\nLOADING\nLOADING\nLOADING\nLOADING\nLOADING\nLOADING\nLOADING\n" +
                "LOADING\nLOADING\nLOADING\nLOADING\nLOADING\nLOADING\nLOADING\nLOADING\n", ls);
        angleLabel.setWidth(sSys.getX() - controls.getX());
        angleLabel.setPosition
                (controls.getX(),
                controls.getY() - (controls.getHeight() * 0.1f) - angleLabel.getHeight());

        infoStr = defaultInfo;

        infoLabel = new Label(infoStr, ls);
        infoLabel.setWidth(pControls.getRight() - scaleImg.getRight() - (scaleImg.getWidth() * 0.05f));
        infoLabel.setHeight(stage.getHeight() - pControls.getTop() - (pControls.getHeight() * 0.1f));
        infoLabel.setWrap(true);
        infoLabel.setAlignment(Align.top, Align.top);
        infoLabel.setX(pControls.getRight() - infoLabel.getWidth());
        infoLabel.setY(pControls.getTop());

        infoLabel.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                infoStr = defaultInfo;
                super.touchUp(event, x, y, pointer, button);
            }
        });

        /* ADDING ACTORS */

        stage.addActor(background);
        stage.addActor(backgroundMask);

        randomParticles = new RandomParticles
                (5000, stage.getHeight() * 0.0025f, stage.getWidth(), stage.getHeight(), stage);

        stage.addActor(scaleImg);
        stage.addActor(sSys);
        stage.addActor(controls);
        stage.addActor(pControls);

        stage.addActor(stateLabel);
        stage.addActor(angleLabel);
        stage.addActor(infoLabel);

        scaleImg.addAction(Actions.rotateBy(360, 0.75f));

    }

    @Override
    public void show() {

    }

    private void updateLabels () {
        stateLabel.setText
                (
                        "Speed multiplier: " + sSys.getSpeedMultiplier()
                                + "\n" + "State: " + sSys.getStateString() + "\n"
                                + "FPS: " + Gdx.graphics.getFramesPerSecond()
                );

        if (isStarted) {

            angleLabel.setText
                    (
                            "*** ANGLES ***\n" +
                                    "MERCURY:\n"
                                    + sSys.getPlanetAngle(SolarSys.P_MER) + "\n" +
                                    "VENUS:\n"
                                    + sSys.getPlanetAngle(SolarSys.P_VEN) + "\n" +
                                    "EARTH:\n"
                                    + sSys.getPlanetAngle(SolarSys.P_EAR) + "\n" +
                                    "MARS:\n"
                                    + sSys.getPlanetAngle(SolarSys.P_MAR) + "\n" +
                                    "JUPITER:\n"
                                    + sSys.getPlanetAngle(SolarSys.P_JUP) + "\n" +
                                    "SATURN:\n"
                                    + sSys.getPlanetAngle(SolarSys.P_SAT) + "\n" +
                                    "URANUS:\n"
                                    + sSys.getPlanetAngle(SolarSys.P_URA) + "\n" +
                                    "NEPTUNE:\n"
                                    + sSys.getPlanetAngle(SolarSys.P_NEP) + "\n"
                    );

        }

        infoLabel.setText(infoStr);

    }

    public static void setNewInformation (String text) {
        infoStr = text;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(delta);

        stage.setDebugAll(false);
        sSys.update();
        randomParticles.update();

        updateLabels();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
