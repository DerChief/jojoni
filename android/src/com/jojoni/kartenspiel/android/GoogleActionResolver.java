package com.jojoni.kartenspiel.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.plus.Plus;
import com.google.example.games.basegameutils.BaseGameUtils;
import com.jojoni.kartenspiel.GoogleServicesActionResolverInterface;

import java.util.List;

/**
 * Created by johan_000 on 01.06.2015.
 */
public class GoogleActionResolver implements GoogleServicesActionResolverInterface {

    private final static int RC_SIGN_IN = 9001;
    private final static int RC_SELECT_PLAYERS = 10000;
    private final static int RC_ACHIEVEMENTS = 10002;
    private final static int RC_WAITING_ROOM = 10003;

    AndroidApplication appContext;
    Handler uiThread;
    GoogleApiClient mGoogleApiClient;

    public GoogleActionResolver(AndroidApplication appContext) {
        this.appContext = appContext;
        this.uiThread = new Handler();

        mGoogleApiClient = new GoogleApiClient.Builder(appContext)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(Bundle bundle) {

                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                })
                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(ConnectionResult connectionResult) {

                    }
                })
                .addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .build();

    }

    @Override
    public void signIn() {

    }

    @Override
    public void signOut() {

    }

    @Override
    public void invitePlayers() {

    }

    @Override
    public void leaveRoom() {

    }

    @Override
    public void makeToast(final String toastMessage) {
        uiThread.post(new Runnable() {
            public void run() {
                Toast.makeText(appContext, toastMessage, Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }

    @Override
    public boolean inRoom() {
        return false;
    }

    @Override
    public void sendAdvanceToNextPlayer() {

    }

    @Override
    public void startingNewGame() {
        int minPlayers = 1;
        int maxPlayers = 8;
        Intent intent = Games.RealTimeMultiplayer.getSelectOpponentsIntent(mGoogleApiClient,
                minPlayers, maxPlayers, true);
        appContext.startActivityForResult(intent, RC_SELECT_PLAYERS);
    }

    @Override
    public void joinRandomGame() {

    }

    @Override
    public void sendIsMyTurn() {

    }

    public void onActivityResult(int request, int response, Intent data) {

        // We are coming back from the player selection UI, in preparation to start a match.
        if (request == RC_SELECT_PLAYERS) {
            if (response != Activity.RESULT_OK) {
                // user canceled
                return;
            }

        }

    }
}
