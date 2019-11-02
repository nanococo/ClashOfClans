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
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.Tokens.Warriors.*;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.*;
import com.mygdx.clashofclans.ClashOfClansGame;
import com.mygdx.clashofclans.Tokens.Defenses.Bomb;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.Hector;
import com.mygdx.clashofclans.Tokens.Warriors.Hero;

import java.util.ArrayList;
import java.util.Random;

public class LevelScreen implements Screen {

    private ClashOfClansGame game;

    private int counter;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    private TerrestrialWarrior warriorA;
    private TerrestrialWarrior warriorB;
    private TerrestrialWarrior warriorC;
    private TerrestrialWarrior warriorD;
    private TerrestrialWarrior warriorE;
    private TerrestrialWarrior hero;
    private Canyon bomb = new Canyon(303f, 450);
    private ArrayList<Warrior> army = new ArrayList<Warrior>();



    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();
    private float elapsed;

    public static final float unitScale = 1/16f;

    LevelScreen(ClashOfClansGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        map = new TmxMapLoader().load("Tiles/gameMap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        hero = new Hector(150,350f, (TiledMapTileLayer) map.getLayers().get("Grass"), map);
        warriorA = new Hector(200,230f,(TiledMapTileLayer) map.getLayers().get("Grass"), map);
        warriorB = new Yolanda(200,730f,(TiledMapTileLayer) map.getLayers().get("Grass"), map);
        warriorC = new Deuce(200,123f,(TiledMapTileLayer) map.getLayers().get("Grass"), map);
        warriorD = new Ringo(200,456f,(TiledMapTileLayer) map.getLayers().get("Grass"), map);
        warriorE = new Hector(200,357f,(TiledMapTileLayer) map.getLayers().get("Grass"), map);

        army.add(hero);
//        army.add(warriorA);
        //army.add(warriorB);
//        army.add(warriorC);
//        army.add(warriorD);
//        army.add(warriorE);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
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
        game.batch.begin();
        for(Warrior troop:army){
            troop.doAction();
            troop.setTarget(bomb.initialX, bomb.initialY);
            game.batch.draw(troop.draw().getKeyFrame(elapsed), troop.initialX, troop.initialY);
            game.batch.draw(troop.draw().getKeyFrame(elapsed), troop.initialX, troop.initialY);
        }
        game.batch.draw(bomb.draw().getKeyFrame(elapsed), bomb.initialX, bomb.initialY);

        game.batch.end();

        counter++;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
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
}
