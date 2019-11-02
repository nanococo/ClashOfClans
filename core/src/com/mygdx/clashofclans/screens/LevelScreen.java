package com.mygdx.clashofclans.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.clashofclans.Teams.Army;
import com.mygdx.clashofclans.Teams.Defenses;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Defenses.Canyon;
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.*;
import com.mygdx.clashofclans.ClashOfClansGame;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.Hector;

public class LevelScreen implements Screen {

    private ClashOfClansGame game;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Army army;
    private Defenses defenses;

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
        camera = new OrthographicCamera();

        defenses = new Defenses(1, 5);
        defenses.addDefense(new Canyon(1000, 1000));
        defenses.addDefense(new Canyon(255, 356));
        defenses.addDefense(new Canyon(456, 645));

        army = new Army(1, 50, defenses);
        //army.addTroop(new Yolanda(0,0,(TiledMapTileLayer) map.getLayers().get("Grass"), map));
        //army.addTroop(new Hector(0,500,(TiledMapTileLayer) map.getLayers().get("Grass"), map));
        army.addTroop(new Ringo(1600,0,(TiledMapTileLayer) map.getLayers().get("Grass"), map));


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
        for (Defense defense: defenses.getDefenses()){
            game.batch.draw(defense.draw().getKeyFrame(elapsed), defense.getInitialX(), defense.getInitialY());
        }
        for (Warrior troop:army.getTroops()){
            game.batch.draw(troop.draw().getKeyFrame(elapsed), troop.getInitialX(), troop.getInitialY());
            troop.doAction();
            troop.setTargetDirection(defenses.getDefenses().get(0).getInitialX(),defenses.getDefenses().get(0).getInitialY());
        }
        army.searchAndSetTargets();
        System.out.println(defenses.getDefenses().get(0).getLife());
        game.batch.end();

        defenses.removeCasualties();

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
