package com.oleynik.solarsystem.SCREENS;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.oleynik.solarsystem.GdxGameCore;
import com.oleynik.solarsystem.RES.Resources;

/**
 * Created by MATHAHAKAR on 27.11.2016.
 * vk.com/mathahakar
 * mathahakar1997@gmail.com
 */
public class LoadingScreen implements Screen {

    final GdxGameCore game;
    private Stage stage;
    private Image logo;

    private float timer = 4.0f;

    public LoadingScreen (GdxGameCore game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        logo = new Image(Resources.ImgRes.getRegion(Resources.ImgRes.LOGO));
        logo.setSize(stage.getHeight() * 0.65f, stage.getHeight() * 0.65f);
        logo.setPosition(- stage.getWidth(), - stage.getHeight());
        stage.addActor(logo);
        logo.addAction(Actions.alpha(0));
        logo.addAction(Actions.moveTo
                (stage.getWidth() / 2 - (logo.getWidth() / 2),
                stage.getHeight() / 2 - (logo.getHeight() / 2))
        );
        logo.addAction(Actions.fadeIn(1.0f));
    }

    private void changeScreen () {
        game.setScreen(new SpaceScreen(game));
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

        timer -= delta;

        if (timer <= 0) {
            dispose();
            changeScreen();
        }
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
