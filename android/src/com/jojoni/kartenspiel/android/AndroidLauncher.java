package com.jojoni.kartenspiel.android;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.example.games.basegameutils.GameHelper;
import com.jojoni.kartenspiel.GoogleServicesInterface;

public class AndroidLauncher extends AndroidApplication implements GoogleServicesInterface{
	GameHelper gh;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		gh = new GameHelper(this, GameHelper.CLIENT_GAMES);
		gh.enableDebugLog(false);

		GameHelper.GameHelperListener gameHelperListener = new GameHelper.GameHelperListener()
		{
			@Override
			public void onSignInSucceeded()
			{
			}

			@Override
			public void onSignInFailed()
			{
			}
		};

		gh.setup(gameHelperListener);

		initialize(new com.jojoni.kartenspiel.SekaGame(this), config);
	}


	@Override
	protected void onStart()
	{
		super.onStart();
		gh.onStart(this);
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		gh.onStop();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		gh.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void signIn() {

	}

	@Override
	public void signOut() {

	}
}
