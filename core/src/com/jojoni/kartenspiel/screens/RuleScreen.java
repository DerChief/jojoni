package com.jojoni.kartenspiel.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.jojoni.kartenspiel.SekaGame;

/**
 * Created by Niko on 20.05.2015.
 */
public class RuleScreen implements Screen{
    final SekaGame game;
    Label lblHeadline;
    Label lblContent;
    Table table;
    BitmapFont bmp;
    Texture bgTexture;
    Sprite bgSprite;
//    OrthographicCamera camera;

    public RuleScreen(final SekaGame gam) {
        this.game = gam;

  //      Gdx.input.setCatchBackKey(true);

   //   camera = new OrthographicCamera();
  //    camera.setToOrtho(false, 800, 480);

        Label.LabelStyle stLblHeadline = new Label.LabelStyle();
        bmp = new BitmapFont();
        bmp.setColor(0,0,0,0);
        stLblHeadline.font = bmp;
        lblHeadline = new Label ("Regeln", stLblHeadline);

        // Bilder werden eingelesen
        bgTexture = new Texture(Gdx.files.internal("img/BackgroundMenuSmall.png"));
    }


    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void render(float delta) {
        //Hintergrundfarbe setzen
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        //Bildschirm leeren
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
   //     camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
//        game.batch.setProjectionMatrix(camera.combined);
        //Hintergrundbild setzen

        bgSprite = new Sprite(bgTexture);

        game.batch.begin();
        // game.batch.disableBlending();
        bgSprite.draw(game.batch);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
            game.setScreen(new MainMenuScreen(game));
        }
            dispose();


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
