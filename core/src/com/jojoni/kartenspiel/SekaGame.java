package com.jojoni.kartenspiel;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jojoni.kartenspiel.screens.MainMenuScreen;



public class SekaGame  extends Game {

	static GoogleServicesInterface googleServicesInterface;
	public SpriteBatch batch;
//	public BitmapFont font;

	public SekaGame(GoogleServicesInterface googleServicesInterface){
		this.googleServicesInterface = googleServicesInterface;
	}

	public void create() {
		batch = new SpriteBatch();
		//Use LibGDX's default Arial font.
//		font = new BitmapFont();
		//font = new BitmapFont();
		googleServicesInterface.signIn();
		this.setScreen(new MainMenuScreen(this));
	}

	public void render() {
		super.render(); //important!
	}

	public void dispose() {
		batch.dispose();
//		font.dispose();
	}

}
