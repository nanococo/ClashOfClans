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
import com.mygdx.clashofclans.ClashOfClansGame;
import com.mygdx.clashofclans.Tokens.Defenses.Bomb;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.Hector;
import com.mygdx.clashofclans.Tokens.Warriors.Hero;

public class LevelScreen implements Screen {

    private ClashOfClansGame game;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Hero hero;
    private Bomb bomb = new Bomb(500, 500);
    private Animation<TextureRegion> house;


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

        hero.move();

        game.batch.begin();
        game.batch.draw(hero.draw().getKeyFrame(elapsed), hero.initialX, hero.initialY);
        game.batch.draw(bomb.draw().getKeyFrame(elapsed), bomb.initialX, bomb.initialY);
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
