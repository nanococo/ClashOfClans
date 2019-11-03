package com.mygdx.clashofclans.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
import com.mygdx.clashofclans.Tokens.Warriors.WarriorFactory;
import com.mygdx.clashofclans.levelManager.LevelData;
import com.mygdx.clashofclans.levelManager.Levels;

public class LevelScreen implements Screen {

    private ClashOfClansGame game;

    private TiledMap map;
    private TiledMapTileLayer collisionLayer;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private LevelData levelData;

    private Army army;
    private Defenses defenses;

    private int counter;

    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();
    private float elapsed;

    private boolean gameStart = false;
    private boolean setWarrior = false;

    private Texture hectorFrame = new Texture("Hector/Frame/Hector (Frame).png");
    private Texture yolandaFrame = new Texture("Yolanda/Frame/Yolanda (Frame).png");
    private Texture deuceFrame = new Texture("Deuce/Frame/Deuce (Frame).png");
    private Texture bichilloFrame = new Texture("Bichillos/Frame/Bichillos (Frame).png");
    private Texture ringoFrame = new Texture("Ringo/Frame/Ringo (Frame).png");
    private Texture goFrame = new Texture("Go.png");

    //All frames have same width and height so take one as reference
    private final int COMMON_FRAME_WIDTH = hectorFrame.getWidth();
    private final int COMMON_FRAME_HEIGHT = hectorFrame.getHeight();

    private final int COMMON_Y_FRAMES = 15;
    private final int HECTOR_FRAME_X = 200;
    private final int YOLANDA_FRAME_X = 300;
    private final int DEUCE_FRAME_X = 400;
    private final int BICHILLO_FRAME_X = 500;
    private final int RINGO_FRAMEX = 600;
    private final int GO_FRAMES_X = 700;

    private Warrior placeHolderWarrior;
    private boolean timer;
    long start;
    long finish;





    LevelScreen(ClashOfClansGame game) {
        this.game = game;

        levelData = LevelData.getInstance();
    }

    @Override
    public void show() {


        map = new TmxMapLoader().load("Tiles/gameMap4.tmx");

        levelData.setLevel(Levels.LEVEL1);
        renderer = new OrthogonalTiledMapRenderer(map);
        collisionLayer = (TiledMapTileLayer) map.getLayers().get("Grass");

        camera = new OrthographicCamera();

        defenses = new Defenses(1, 5, collisionLayer, levelData);

        defenses.generateDefenses(levelData.getCannonCount(), levelData.getBombCount(), levelData.getBallistaCount(), levelData.getTowerCount(), levelData.getMortarCount());

        army = new Army(1, levelData.getArmySize(), defenses);
//        System.out.println(army.addTroop(1, 0,0,collisionLayer, map));
//        System.out.println(army.addTroop(2, 500, 100, collisionLayer, map));
//
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

        if(!gameStart){

            if(!setWarrior){
                if(Gdx.input.getX() > HECTOR_FRAME_X && Gdx.input.getX() < HECTOR_FRAME_X+COMMON_FRAME_WIDTH && ClashOfClansGame.HEIGHT - Gdx.input.getY() > COMMON_Y_FRAMES && ClashOfClansGame.HEIGHT - Gdx.input.getY() < COMMON_Y_FRAMES+COMMON_FRAME_HEIGHT){
                    setHandCursor();
                    if(Gdx.input.justTouched()){
                        placeHolderWarrior = WarriorFactory.getWarrior(2,0,0, collisionLayer, map);
                        setWarrior = true;
                    }
                } else {
                    if(Gdx.input.getX() > YOLANDA_FRAME_X && Gdx.input.getX() < YOLANDA_FRAME_X+COMMON_FRAME_WIDTH && ClashOfClansGame.HEIGHT - Gdx.input.getY() > COMMON_Y_FRAMES && ClashOfClansGame.HEIGHT - Gdx.input.getY() < COMMON_Y_FRAMES+COMMON_FRAME_HEIGHT){
                        setHandCursor();
                        if(Gdx.input.justTouched()){
                            placeHolderWarrior = WarriorFactory.getWarrior(1,0,0, collisionLayer, map);
                            setWarrior = true;
                        }
                    } else {
                        if(Gdx.input.getX() > DEUCE_FRAME_X && Gdx.input.getX() < DEUCE_FRAME_X+COMMON_FRAME_WIDTH && ClashOfClansGame.HEIGHT - Gdx.input.getY() > COMMON_Y_FRAMES && ClashOfClansGame.HEIGHT - Gdx.input.getY() < COMMON_Y_FRAMES+COMMON_FRAME_HEIGHT){
                            setHandCursor();
                            if(Gdx.input.justTouched()){
                                placeHolderWarrior = WarriorFactory.getWarrior(0,0,0, collisionLayer, map);
                                setWarrior = true;
                            }
                        } else {
                            if(Gdx.input.getX() > BICHILLO_FRAME_X && Gdx.input.getX() < BICHILLO_FRAME_X+COMMON_FRAME_WIDTH && ClashOfClansGame.HEIGHT - Gdx.input.getY() > COMMON_Y_FRAMES && ClashOfClansGame.HEIGHT - Gdx.input.getY() < COMMON_Y_FRAMES+COMMON_FRAME_HEIGHT){
                                setHandCursor();
                                if(Gdx.input.justTouched()){
                                    placeHolderWarrior = WarriorFactory.getWarrior(3,0,0, collisionLayer, map);
                                    setWarrior = true;
                                }
                            } else {
                                if(Gdx.input.getX() > RINGO_FRAMEX && Gdx.input.getX() < RINGO_FRAMEX+COMMON_FRAME_WIDTH && ClashOfClansGame.HEIGHT - Gdx.input.getY() > COMMON_Y_FRAMES && ClashOfClansGame.HEIGHT - Gdx.input.getY() < COMMON_Y_FRAMES+COMMON_FRAME_HEIGHT){
                                    setHandCursor();
                                    if(Gdx.input.justTouched()){
                                        placeHolderWarrior = WarriorFactory.getWarrior(4,0,0, collisionLayer, map);
                                        setWarrior = true;
                                    }
                                } else {
                                    if(Gdx.input.getX() > GO_FRAMES_X && Gdx.input.getX() < GO_FRAMES_X+COMMON_FRAME_WIDTH && ClashOfClansGame.HEIGHT - Gdx.input.getY() > COMMON_Y_FRAMES && ClashOfClansGame.HEIGHT - Gdx.input.getY() < COMMON_Y_FRAMES+COMMON_FRAME_HEIGHT){
                                        setHandCursor();
                                        if(Gdx.input.justTouched()){
                                            gameStart = true;
                                            setWarrior = false;
                                            setNormalCursor();
                                        }
                                    } else {
                                        setNormalCursor();
                                    }
                                }
                            }
                        }
                    }
                }

                game.batch.draw(hectorFrame, 200,15);
                game.batch.draw(yolandaFrame, 300,15);
                game.batch.draw(deuceFrame, 400,15);
                game.batch.draw(bichilloFrame, 500,15);
                game.batch.draw(ringoFrame, 600, 15);
                game.batch.draw(goFrame, 700, 15);
            } else {
                if (Gdx.input.justTouched()){
                    placeHolderWarrior.setInitialX(Gdx.input.getX());
                    placeHolderWarrior.setInitialY(ClashOfClansGame.HEIGHT-Gdx.input.getY());
                    army.addTroop(placeHolderWarrior);
                    placeHolderWarrior = null;
                    setWarrior = false;
                }
            }
        }

        if (setWarrior){
            game.batch.draw(placeHolderWarrior.draw().getKeyFrame(elapsed), Gdx.input.getX(), ClashOfClansGame.HEIGHT-Gdx.input.getY());
        }




        for (Defense defense: defenses.getDefenses()){
            if(gameStart){
                defense.doAction();
            }
            game.batch.draw(defense.draw().getKeyFrame(elapsed), defense.getInitialX(), defense.getInitialY());
        }
        for (Warrior troop:army.getTroops()){
            if (gameStart){
                troop.doAction();
            }
            game.batch.draw(troop.draw().getKeyFrame(elapsed), troop.getInitialX(), troop.getInitialY());
        }

        army.searchAndSetTargets();
        defenses.searchAndSetTargets();

        game.batch.end();



        if (setWarrior){
            game.shape.setProjectionMatrix(camera.combined);
            game.shape.begin(ShapeRenderer.ShapeType.Line);
            game.shape.setColor(Color.RED);
            game.shape.rect(levelData.getMinBaseWidth(), levelData.getMinBaseHeight(), levelData.getMaxBaseWidth()-levelData.getMinBaseWidth(), levelData.getMaxBaseHeight()-levelData.getMinBaseHeight());
            game.shape.end();
        }

        defenses.removeCasualties();
        army.removeCasualties();

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

    void setHandCursor(){
        Pixmap pixmap = new Pixmap(Gdx.files.internal("Cursor/handCursor.png"));
        int xHotspot = pixmap.getWidth() / 2;
        int yHotspot = pixmap.getHeight() / 2;
        Cursor cursor = Gdx.graphics.newCursor(pixmap, xHotspot, yHotspot);
        Gdx.graphics.setCursor(cursor);
        pixmap.dispose();
    }

    void setNormalCursor(){
        Pixmap pixmap = new Pixmap(Gdx.files.internal("Cursor/Cursor_1.png"));
        int xHotspot = pixmap.getWidth() / 2;
        int yHotspot = pixmap.getHeight() / 2;
        Cursor cursor = Gdx.graphics.newCursor(pixmap, xHotspot, yHotspot);
        Gdx.graphics.setCursor(cursor);
        pixmap.dispose();
    }

//    void testEllapsed(){
//        if (!timer){
//           start = System.currentTimeMillis();
//           timer = true;
//        }
//        finish = System.currentTimeMillis();
//        if(finish-start>=2000){
//            System.out.println("Hello");
//            timer = false;
//        }
//    }
}
