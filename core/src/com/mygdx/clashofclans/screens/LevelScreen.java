package com.mygdx.clashofclans.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.clashofclans.ClashOfClansGame;
import com.mygdx.clashofclans.Teams.Army;
import com.mygdx.clashofclans.Teams.Defenses;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.Hector;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.Ringo;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.Yolanda;

public class LevelScreen implements Screen {

    private ClashOfClansGame game;

    private TiledMap map;
    private TiledMapTileLayer collisionLayer;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    private Army army;
    private Defenses defenses;

    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();
    private float elapsed;



    LevelScreen(ClashOfClansGame game) {
        this.game = game;
    }

    @Override
    public void show() {

        map = new TmxMapLoader().load("Tiles/gameMap.tmx");
        collisionLayer = (TiledMapTileLayer) map.getLayers().get("Grass");
        renderer = new OrthogonalTiledMapRenderer(map);

        camera = new OrthographicCamera();

        defenses = new Defenses(1, 5, collisionLayer);
        defenses.addDefense(0);
        defenses.addDefense(1);
        defenses.addDefense(0);

        army = new Army(1, 10, defenses);
        army.addTroop(new Yolanda(0,0, collisionLayer, map));
        army.addTroop(new Hector(0,500,collisionLayer, map));
        army.addTroop(new Ringo(1600,0,collisionLayer, map));


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
            troop.doAction();
            game.batch.draw(troop.draw().getKeyFrame(elapsed), troop.getInitialX(), troop.getInitialY());
            if (defenses.getDefenses().size()>0)
            troop.setTargetDirection(defenses.getDefenses().get(0).getInitialX(),defenses.getDefenses().get(0).getInitialY());
        }

        army.searchAndSetTargets();


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
