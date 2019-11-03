package com.mygdx.clashofclans.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.clashofclans.ClashOfClansGame;
import com.mygdx.clashofclans.Teams.Army;
import com.mygdx.clashofclans.Teams.Defenses;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.Deuce;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.Hector;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.Ringo;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.Yolanda;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;
import com.mygdx.clashofclans.levelManager.LevelData;
import com.mygdx.clashofclans.levelManager.Levels;

public class LevelScreen implements Screen {

    private ClashOfClansGame game;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private LevelData levelData;

    private Army army;
    private Defenses defenses;

    private int counter;

    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();
    private float elapsed;

    private Texture hectorFrame = new Texture("Hector/Frame/Hector (Frame).png");
    private Texture yolandaFrame = new Texture("Yolanda/Frame/Yolanda (Frame).png");
    private Texture deuceFrame = new Texture("Deuce/Frame/Deuce (Frame).png");
    private Texture bichilloFrame = new Texture("Bichillos/Frame/Bichillos (Frame).png");


    LevelScreen(ClashOfClansGame game) {
        this.game = game;
        counter = 0;
    }

    @Override
    public void show() {

        map = new TmxMapLoader().load("Tiles/gameMap.tmx");
        levelData = new LevelData();
        levelData.setLevel(Levels.LEVEL1);
        renderer = new OrthogonalTiledMapRenderer(map);
        TiledMapTileLayer collisionLayer = (TiledMapTileLayer) map.getLayers().get("Grass");

        camera = new OrthographicCamera();

        defenses = new Defenses(1, 5, collisionLayer, levelData);
        defenses.addDefense(1);
        defenses.addDefense(1);
        defenses.addDefense(2);
        defenses.addDefense(3);
        defenses.addDefense(4);


        army = new Army(1, 50, defenses);
        army.addTroop(new Yolanda(0,0, collisionLayer, map));
        army.addTroop(new Hector(500,100, collisionLayer, map));
        army.addTroop(new Ringo(1600,0, collisionLayer, map));
        army.addTroop(new Deuce(0,451, collisionLayer, map));
        army.addTroop(new Hector(500,0, collisionLayer, map));
        army.addTroop(new Deuce(0,1600, collisionLayer, map));

        defenses.setEnemies(army);

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
        game.batch.draw(hectorFrame, 200,15);
        game.batch.draw(yolandaFrame, 300,15);
        game.batch.draw(deuceFrame, 400,15);
        game.batch.draw(bichilloFrame, 500,15);

        for (Defense defense: defenses.getDefenses()){
            defense.doAction();
            game.batch.draw(defense.draw().getKeyFrame(elapsed), defense.getInitialX(), defense.getInitialY());
        }
        for (Warrior troop:army.getTroops()){
            troop.doAction();
            game.batch.draw(troop.draw().getKeyFrame(elapsed), troop.getInitialX(), troop.getInitialY());
        }

        army.searchAndSetTargets();
        defenses.searchAndSetTargets();

        game.batch.end();
        defenses.removeCasualties();
        army.removeCasualties();
        counter = 0;

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

    void changeMap() {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() { //Post runnable posts the below task in opengl thread
                map = new TmxMapLoader().load("Tiles/gameMap2.tmx"); //load the new map
                renderer.getMap().dispose(); //dispose the old map
                renderer.setMap(map); //set the map in your renderer
            }
        });
    }
}
