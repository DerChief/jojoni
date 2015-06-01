package com.jojoni.kartenspiel.android;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.games.Game;
import com.google.example.games.basegameutils.GameHelper;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;
import com.jojoni.kartenspiel.GoogleServicesActionResolverInterface;

public class AndroidLauncher extends AndroidApplication implements GameHelperListener {
	private GameHelper gameHelper;
	private Game game;
	private GoogleActionResolver actionResolver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		actionResolver = new GoogleActionResolver(this);

		if (gameHelper == null) {
			gameHelper = new GameHelper(this, GameHelper.CLIENT_GAMES);
			gameHelper.enableDebugLog(true);
		}

		actionResolver.makeToast("HalloWelt");
		gameHelper.setup(this);
		initialize(new com.jojoni.kartenspiel.SekaGame(actionResolver), config);
	}

	@Override
	public void onSignInSucceeded() {
	}

	@Override
	public void onSignInFailed() {
	}

	@Override
	protected void onStart() {
		super.onStart();
		actionResolver.mGoogleApiClient.connect();
		gameHelper.onStart(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		gameHelper.onStop();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		gameHelper.onActivityResult(requestCode, resultCode, data);
	}
}