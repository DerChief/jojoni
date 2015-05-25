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
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


public class MainMenuScreen implements Screen {

    private Stage stage;
    private Table table;
    Button btnShowRules;
    Button btnCreateGame;
    Button btnJoinGame;
    Button.ButtonStyle btnStShowRules;
    Button.ButtonStyle btnStCreateGame;
    Button.ButtonStyle btnStJoinGame;
    Skin skin;
    TextureAtlas btnAtlas;

    final com.jojoni.kartenspiel.SekaGame game;

    OrthographicCamera camera;

    public MainMenuScreen(final com.jojoni.kartenspiel.SekaGame gam) {
        game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        skin = new Skin();
        btnAtlas = new TextureAtlas(Gdx.files.internal("img/Buttons.pack"));
        skin.addRegions(btnAtlas);

        btnStShowRules = new Button.ButtonStyle();
        btnStShowRules.up = skin.getDrawable("ButtonRegelnEinsehen");
 //       btnStShowRules.down = skin.getDrawable("img/ButtonRegelnEinsehen.png");
 //       btnStShowRules.checked = skin.getDrawable("img/ButtonRegelnEinsehen.png");

        btnStCreateGame = new Button.ButtonStyle();
        btnStCreateGame.up = skin.getDrawable("ButtonSpielStarten");

        btnStJoinGame = new Button.ButtonStyle();
        btnStJoinGame.up = skin.getDrawable("ButtonSpielBeitreten");


        table = new Table();
        table.setFillParent(true);
        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("img/BackgroundMenuSmall.png"))));

        float screenWidth = table.getWidth();
        float screenHeight = table.getHeight();
        int btnWidth = 700;
        int btnHeight = 150;


        btnShowRules = new Button(btnStShowRules);
        btnShowRules.setPosition(600, 100);
       // btnShowRules.setPosition((screenWidth/2) - (btnWidth/2), 100);
        btnShowRules.setSize(btnWidth, btnHeight);

        btnCreateGame = new Button(btnStCreateGame);
        btnCreateGame.setPosition(200, 600);
        btnCreateGame.setSize(btnWidth, btnHeight);

        btnJoinGame = new Button(btnStJoinGame);
        btnJoinGame.setPosition(1000, 600);
        btnJoinGame.setSize(btnWidth, btnHeight);

        //Die Listener, die bei Berührung der Knöpfe etwas tun
        btnShowRules.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new RuleScreen(game));
            }
        });

        btnCreateGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
             //   game.setScreen(new RuleScreen(game));
            }
        });

        btnJoinGame.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            //    game.setScreen(new RuleScreen(game));
            }
        });


        table.addActor(btnShowRules);
        table.addActor(btnCreateGame);
        table.addActor(btnJoinGame);
        stage.addActor(table);


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

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);
        //Hintergrundbild setzen


        //Das Rendern wird alle 0,25 Sekunden durchgefuehrt. Alles was dargestellt werden soll,
        // muss zwischen begin ung end
        game.batch.begin();

        stage.draw();

        game.batch.end();
/*
        //Ueberpruefen ob der Bildschirm beruehrt wird
        if (Gdx.input.isTouched()) {

            //Hier wird die Position des Beruehrens mit der Position unserer "Camera" Position gleichgestellt
            //Diese koennte variieren, daher wird das damit sichergestellt
            //This is necessary because the coordinate system in which touch coordinates are reported
            // might be different than the coordinate system we use to represent objects in our world.
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            //Wenn der Button Regeln einsehen gedrueckt wird (Button ist 283 Pixel breit), ...

            if (((touchPos.x > 259) &&  (touchPos.x < 544 )) && ((touchPos.y > 99) && (touchPos.y < 177))){
                game.setScreen(new RuleScreen(game));
            }

          //  dispose();
        }*/
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
    //Alle gespeicherten Sachen werden aufgeraeumt - geloescht
    public void dispose() {

    }
}
