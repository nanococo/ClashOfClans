package com.mygdx.clashofclans.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.clashofclans.Tokens.Warriors.*;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.*;
import com.mygdx.clashofclans.ClashOfClansGame;

public class LevelScreen implements Screen {

    private ClashOfClansGame game;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    private Hero hero = new Hector(0,0);

    public static final float unitScale = 1/16f;
    float w = Gdx.graphics.getWidth();
    float h = Gdx.graphics.getHeight();
    private int[][] board;
    private float elapsed;


    LevelScreen(ClashOfClansGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        map = new TmxMapLoader().load("Tiles/gameMap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);


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

        hero.move();

        game.batch.begin();
        game.batch.draw(hero.draw().getKeyFrame(elapsed), hero.initialX, hero.initialY);
        game.batch.end();

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
