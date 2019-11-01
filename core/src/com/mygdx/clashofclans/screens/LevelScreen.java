package com.mygdx.clashofclans.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.clashofclans.Tokens.Defenses.Canyon;
import com.mygdx.clashofclans.Tokens.Warriors.*;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.*;
import com.mygdx.clashofclans.ClashOfClansGame;
import com.mygdx.clashofclans.Tokens.Defenses.Bomb;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.Hector;
import com.mygdx.clashofclans.Tokens.Warriors.Hero;

public class LevelScreen implements Screen {

    private ClashOfClansGame game;

    private int counter;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    //private TerrestrialWarrior warriorA = new Hector(504f,230f);
//    private TerrestrialWarrior warriorB = new Yolanda(704f,730f);
//    private TerrestrialWarrior warriorC = new Deuce(321f,123f);
//    private TerrestrialWarrior warriorD = new Ringo(800f,456f);
    //private TerrestrialWarrior warriorE = new Hector(654f,357f);
    private Hero hero;
    private Canyon bomb = new Canyon(303f, 553f);

    float w = Gdx.graphics.getWidth();
    float h = Gdx.graphics.getHeight();
    private int[][] board;
    private float elapsed;

    public static final float unitScale = 1/16f;

    LevelScreen(ClashOfClansGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        map = new TmxMapLoader().load("Tiles/gameMap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        hero = new Hector(150,350, (TiledMapTileLayer) map.getLayers().get("Grass"), map);


        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        board = new int[ClashOfClansGame.WIDTH][ClashOfClansGame.HEIGHT];
        camera.position.x = ClashOfClansGame.WIDTH / 2f;
        camera.position.y = ClashOfClansGame.HEIGHT / 2f;
        camera.update();
    }

    @Override
    public void render(float delta) {
        elapsed += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        camera.position.x = ClashOfClansGame.WIDTH / 2f;
        camera.position.y = ClashOfClansGame.HEIGHT / 2f;
        camera.update();

        renderer.setView(camera);
        renderer.render();

//        if(counter==100){
//            bomb.initialX = 222;
//            bomb.initialY = 500;
//        }
//        if (counter==200){
//            bomb.initialX = 333;
//            bomb.initialY = 213;
//        }
//        if (counter==300){
//            bomb.initialX = 354;
//            bomb.initialY = 213;
//        }
//        if (counter==400){
//            bomb.initialX = 333;
//            bomb.initialY = 245;
//        }
//        if (counter==500){
//            bomb.initialX = 365;
//            bomb.initialY = 245;
//        }
//        if(counter==600){
//            bomb.initialX = 222;
//            bomb.initialY = 500;
//        }
//        if (counter==800){
//            bomb.initialX = 333;
//            bomb.initialY = 213;
//        }
//        if (counter==900){
//            bomb.initialX = 354;
//            bomb.initialY = 213;
//        }
//        if (counter==1000){
//            bomb.initialX = 333;
//            bomb.initialY = 245;
//        }
//        if (counter==1100){
//            bomb.initialX = 365;
//            bomb.initialY = 245;
//        }

        //warriorA.doAction();
//        warriorB.doAction();
//        warriorC.doAction();
//        warriorD.doAction();
        //warriorE.doAction();
        hero.doAction();
        hero.setTargetX(bomb.initialX);
        hero.setTargetY(bomb.initialY);

        //warriorA.setTargetX(bomb.initialX);
        //warriorA.setTargetY(bomb.initialY);

//        warriorB.setTargetX(bomb.initialX);
//        warriorB.setTargetY(bomb.initialY);
//
//        warriorC.setTargetX(bomb.initialX);
//        warriorC.setTargetY(bomb.initialY);
//
//        warriorD.setTargetX(bomb.initialX);
//        warriorD.setTargetY(bomb.initialY);

        //warriorE.setTargetX(bomb.initialX);
        //warriorE.setTargetY(bomb.initialY);

        game.batch.begin();
        //game.batch.draw(warriorA.draw().getKeyFrame(elapsed), warriorA.initialX, warriorA.initialY);
//        game.batch.draw(warriorB.draw().getKeyFrame(elapsed), warriorB.initialX, warriorB.initialY);
//        game.batch.draw(warriorC.draw().getKeyFrame(elapsed), warriorC.initialX, warriorC.initialY);
//        game.batch.draw(warriorD.draw().getKeyFrame(elapsed), warriorD.initialX, warriorD.initialY);
        //game.batch.draw(warriorE.draw().getKeyFrame(elapsed), warriorE.initialX, warriorE.initialY);

        game.batch.draw(hero.draw().getKeyFrame(elapsed), hero.initialX, hero.initialY);
        game.batch.draw(bomb.draw().getKeyFrame(elapsed), bomb.initialX, bomb.initialY);

        game.batch.end();

        counter++;
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportHeight = height;
        camera.viewportWidth = width;
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
    }

    public void removeBlock(){
//        Gdx.app.postRunnable(() -> { //Post runnable posts the below task in opengl thread
//            try {
//                TiledMap testMap = map.clone(); //load the new map
//                testMap.getLayers().get("Grass").get
//                renderer.getMap().dispose(); //dispose the old map
//                renderer.setMap(testMap); //set the map in your renderer
//            } catch (CloneNotSupportedException e){
//
//            }
//        });

    }
}
