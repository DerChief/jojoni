package com.jojoni.kartenspiel.screens;

/**
 * Created by Niko on 20.05.2015.
 */

//Diese Klasse war eine Testklasse und wird zur Zeit noch ueberhaupt nicht aufgerufen.
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.jojoni.kartenspiel.SekaGame;

public class GameScreen implements Screen {
    final SekaGame game;
    private Stage stage;
    Table table;
 //   OrthographicCamera camera;


    public GameScreen(final SekaGame gam) {
        this.game = gam;

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);



        table = new Table();
        table.setFillParent(true);
        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("img/CardTable.png"))));

        stage.addActor(table);

    }

    @Override
    public void render(float delta) {
        //Hintergrundfarbe setzen
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        //Bildschirm leeren
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        game.batch.begin();

        stage.draw();

        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
            game.setScreen(new MainMenuScreen(game));
        }
        dispose();


    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {

    }

}