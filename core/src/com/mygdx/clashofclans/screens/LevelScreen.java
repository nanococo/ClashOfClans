package com.mygdx.clashofclans.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.characters.Hero;
import com.mygdx.clashofclans.clashOfClansGame;

public class LevelScreen implements Screen {

    private clashOfClansGame game;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Animation<TextureRegion> animation;

    private Hero hero;

    public static final float unitScale = 1/16f;
    float w = Gdx.graphics.getWidth();
    float h = Gdx.graphics.getHeight();
    private static int WIDTH;
    private static int HEIGHT;
    private int[][] board;
    private float elapsed;


    LevelScreen(clashOfClansGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        map = new TmxMapLoader().load("Tiles/gameMap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Hector (Idle).gif").read());

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        WIDTH = 900;
        HEIGHT = 900;
        board = new int[WIDTH][HEIGHT];
        camera.position.x = WIDTH / 2f;
        camera.position.y = HEIGHT / 2f;
        camera.update();
    }

    @Override
    public void render(float delta) {
        elapsed += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        camera.position.x = WIDTH / 2f;
        camera.position.y = HEIGHT / 2f;
        camera.update();

        renderer.setView(camera);
        renderer.render();

        game.batch.begin();
        game.batch.draw(animation.getKeyFrame(elapsed), 0, 0);
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
