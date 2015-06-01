package com.jojoni.kartenspiel;

/**
 * Created by johan_000 on 27.05.2015.
 */
public interface GoogleServicesActionResolverInterface {

    public void signIn();
    public void signOut();

    public void invitePlayers();
    public void leaveRoom();
    public void makeToast(String message);
    public boolean inRoom();
    public void sendAdvanceToNextPlayer();
    public void startingNewGame();

    public void joinRandomGame();

    public void sendIsMyTurn();

}
