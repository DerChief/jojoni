package com.jojoni.kartenspiel.screens;

/**
 * Created by Niko on 20.05.2015.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;


public class MainMenuScreen implements Screen{

    final com.jojoni.kartenspiel.SekaGame game;
    Sprite bgSprite;
    Texture bgTexture;
    Sprite btnSprCreateGame;
    Sprite btnSprJoinGame;
    Sprite btnSprShowRules;
    Texture btnTxtCreateGame;
    Texture btnTxtJoinGame;
    Texture btnTxtShowRules;

    OrthographicCamera camera;

    public MainMenuScreen(final com.jojoni.kartenspiel.SekaGame gam) {
        game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // Bilder werden eingelesen
        bgTexture = new Texture(Gdx.files.internal("img/BackgroundMenuSmall.png"));
        btnTxtCreateGame = new Texture(Gdx.files.internal("img/ButtonSpielStarten.png"));
        btnTxtJoinGame = new Texture(Gdx.files.internal("img/ButtonSpielBeitreten.png"));
        btnTxtShowRules = new Texture(Gdx.files.internal("img/ButtonRegelnEinsehen.png"));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //Hintergrundfarbe setzen
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        //Bildschirm leeren
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);
        //Hintergrundbild setzen

        bgSprite = new Sprite(bgTexture);
        //Die Buttons werden integriert

        //The Sprite class (source) describes both a texture region, the geometry where it will be drawn,
        // and the color it will be drawn.
        btnSprCreateGame = new Sprite(btnTxtCreateGame);
        btnSprCreateGame.setPosition(30, 220);
        btnSprJoinGame = new Sprite(btnTxtJoinGame);
        btnSprJoinGame.setPosition(485, 220);
        btnSprShowRules = new Sprite(btnTxtShowRules);
        btnSprShowRules.setPosition(260, 100);

        //Das Rendern wird alle 0,25 Sekunden durchgeführt. Alles was dargestellt werden soll,
        // muss zwischen begin ung end
        game.batch.begin();
       // game.batch.disableBlending();
        bgSprite.draw(game.batch);
        btnSprShowRules.draw(game.batch);
        btnSprJoinGame.draw(game.batch);
        btnSprCreateGame.draw(game.batch);

        game.batch.end();

        //Überprüfen ob der Bildschirm berührt wird
        if (Gdx.input.isTouched()) {

            //Hier wird die Position des Berührens mit der Position unserer "Camera" Position gleichgestellt
            //Diese könnte variieren, daher wird das damit sichergestellt
            //This is necessary because the coordinate system in which touch coordinates are reported
            // might be different than the coordinate system we use to represent objects in our world.
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            //Wenn der Button Regeln einsehen gedrückt wird (Button ist 283 Pixel breit), ...
            if (((touchPos.x > 259) &&  (touchPos.x < 544 )) && ((touchPos.y > 99) && (touchPos.y < 177))){
                game.setScreen(new RuleScreen(game));
            }

          //  dispose();
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
    //Alle gespeicherten Sachen werden aufgeräumt - gelöscht
    public void dispose() {
        bgTexture.dispose();
        btnTxtCreateGame.dispose();
        btnTxtJoinGame.dispose();
        btnTxtShowRules.dispose();

    }
}
