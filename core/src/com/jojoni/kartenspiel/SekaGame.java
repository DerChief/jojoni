package com.jojoni.kartenspiel;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jojoni.kartenspiel.screens.MainMenuScreen;



public class SekaGame  extends Game {

	private static GoogleServicesActionResolverInterface googleServicesActionResolver;
	public SpriteBatch batch;
//	public BitmapFont font;

	public SekaGame(GoogleServicesActionResolverInterface googleServicesActionResolver){
		this.googleServicesActionResolver = googleServicesActionResolver;

	}

	public void create() {
		batch = new SpriteBatch();
		//Use LibGDX's default Arial font.
//		font = new BitmapFont();
		//font = new BitmapFont();
		googleServicesActionResolver.signIn();
		this.setScreen(new MainMenuScreen(this));
	}

	public void render() {
		super.render(); //important!
	}

	public void dispose() {
		batch.dispose();
//		font.dispose();
	}
	public void sendCall() {
		googleServicesActionResolver.startingNewGame();
	}

}
