package com.oleynik.solarsystem;

import com.badlogic.gdx.Game;
import com.oleynik.solarsystem.RES.Resources;
import com.oleynik.solarsystem.SCREENS.LoadingScreen;

public class GdxGameCore extends Game {

	public GdxGameCore () {

	}
	
	@Override
	public void create () {
		Resources.loadResources();
		this.setScreen(new LoadingScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		super.dispose();
	}
}
