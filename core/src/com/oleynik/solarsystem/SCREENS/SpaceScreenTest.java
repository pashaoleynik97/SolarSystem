package com.oleynik.solarsystem.SCREENS;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.oleynik.solarsystem.Const;
import com.oleynik.solarsystem.GdxGameCore;
import com.oleynik.solarsystem.OBJ.Planet;
import com.oleynik.solarsystem.RES.Resources;

/**
 * Created by MATHAHAKAR on 24.11.2016.
 * vk.com/mathahakar
 * mathahakar1997@gmail.com
 */
public class SpaceScreenTest implements Screen {

    final GdxGameCore game;

    private Stage stage;

    float x, y, x0, y0, angle, k, radius;

    private Image sun, orbit;
    private Planet body;

    public SpaceScreenTest (GdxGameCore game) {
        this.game = game;

        stage = new Stage(new ScreenViewport());

        sun = new Image(Resources.ImgRes.getRegion(Resources.ImgRes.SUN));
        sun.setPosition(stage.getWidth() / 2 - (sun.getWidth() / 2), stage.getHeight() / 2 - (sun.getHeight() / 2));
        stage.addActor(sun);

        body = new Planet(Const.RADIUS_EARTH, 10);
        body.setSize(sun.getWidth() / 2, sun.getWidth() / 2);


        x0 = stage.getWidth() / 2;
        y0 = stage.getHeight() / 2;
        angle = 0;
        radius = sun.getWidth() * 1.5f;
        k = 1;

        orbit = new Image(Resources.ImgRes.getRegion(Resources.ImgRes.ORBIT_SMALL));
        orbit.setSize(radius * 2, radius * 2);
        orbit.setPosition(stage.getWidth() / 2 - (orbit.getWidth() / 2), stage.getHeight() / 2 - (orbit.getHeight() / 2));
        stage.addActor(orbit);

        stage.addActor(body);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(delta);

        angle +=delta * k;
        x = x0 + radius  * (float)Math.cos(angle);
        y = y0 + radius  * (float)Math.sin(angle);

        body.addAction(Actions.moveTo(x - body.getWidth() / 2, y - body.getHeight() / 2));
        body.addAction(Actions.rotateBy(10));

        stage.setDebugAll(true);

        System.out.println("FPS: " + Gdx.graphics.getFramesPerSecond());

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
