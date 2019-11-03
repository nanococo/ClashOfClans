package com.mygdx.clashofclans.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mygdx.clashofclans.ClashOfClansGame;
import com.mygdx.clashofclans.Teams.Army;
import com.mygdx.clashofclans.Teams.Defenses;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Defenses.House;
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.Tokens.Warriors.WarriorFactory;
import com.mygdx.clashofclans.levelManager.LevelData;
import com.mygdx.clashofclans.levelManager.Levels;
import com.mygdx.clashofclans.saveFileHelper.GameDataHolder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LevelScreen implements Screen {

    private ClashOfClansGame game;

    private TiledMap map;
    private TiledMapTileLayer collisionLayer;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private LevelData levelData;

    private Army army;
    private Defenses defenses;

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

    private Texture continueText = new Texture("Continue.png");
    private Texture saveGame = new Texture("SaveAndExit.png");

    private int continueX = ClashOfClansGame.WIDTH /2 - continueText.getWidth()/2;
    private int saveAndQuitX = ClashOfClansGame.WIDTH /2 - saveGame.getWidth()/2;

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
    private Levels level;
    private String mapPath;
    boolean isPaused = false;
    boolean lost = false;

    private HashMap<String,Object> retrieved;

    LevelScreen(ClashOfClansGame game, String levelMap, Levels levels) {
        this.game = game;
        this.level = levels;
        this.mapPath = levelMap;
        levelData = LevelData.getInstance();
        try {
            map = new TmxMapLoader().load(levelMap);
        } catch (Exception e){
            map = new TmxMapLoader().load("Tiles/gameMap15.tmx");
        }


        levelData.setLevel(levels);
        renderer = new OrthogonalTiledMapRenderer(map);
        collisionLayer = (TiledMapTileLayer) map.getLayers().get("Grass");
        camera = new OrthographicCamera();

        defenses = new Defenses(levels, levelData.getDefenseCount(), collisionLayer, levelData);
        defenses.addDefense(House.getInstance());
        defenses.generateDefenses(levelData.getCannonCount(), levelData.getBombCount(), levelData.getBallistaCount(), levelData.getTowerCount(), levelData.getMortarCount());

        army = new Army(levels, levelData.getArmySize(), defenses);

        defenses.setEnemies(army);


    }

    LevelScreen(ClashOfClansGame game, HashMap<String, Object> saved) {

        try {
            FileInputStream fis = new FileInputStream("test.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);

            retrieved = (HashMap<String,Object>)ois.readObject();
            fis.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        this.game = game;
        this.level = (Levels) retrieved.get("0");
        this.mapPath = (String) retrieved.get("1");
        levelData = LevelData.getInstance();
        map = new TmxMapLoader().load(mapPath);


        levelData.setLevel(level);
        renderer = new OrthogonalTiledMapRenderer(map);
        collisionLayer = (TiledMapTileLayer) map.getLayers().get("Grass");
        camera = new OrthographicCamera();

        defenses = new Defenses(level, levelData.getDefenseCount(), collisionLayer, levelData);
        defenses.addDefense(House.getInstance());
        defenses.setDefenses((ArrayList<Defense>) retrieved.get("2"));
        //defenses.generateDefenses(levelData.getCannonCount(), levelData.getBombCount(), levelData.getBallistaCount(), levelData.getTowerCount(), levelData.getMortarCount());

        army = new Army(level, levelData.getArmySize(), defenses);
        army.setTroops((ArrayList<Warrior>)retrieved.get("3"));
        army.setTroopsAvailable((Integer) retrieved.get("4"));
        defenses.setEnemies(army);


    }

    @Override
    public void show() {
        camera.setToOrtho(false, w, h);
        camera.position.x = ClashOfClansGame.WIDTH / 2f;
        camera.position.y = ClashOfClansGame.HEIGHT / 2f;
        camera.update();
    }

    @Override
    public void render(float delta) {
        if (House.getInstance().isDead()){
            House.getInstance().setDead(false);
            House.getInstance().setLife(20);
            House.getInstance().setPosition();
            win();
        }

        if(!lost){
            if(!isPaused){
                elapsed += Gdx.graphics.getDeltaTime();
                Gdx.gl.glClearColor(0,0,0,1);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


                camera.position.x = ClashOfClansGame.WIDTH / 2f;
                camera.position.y = ClashOfClansGame.HEIGHT / 2f;
                camera.update();


                renderer.setView(camera);
                renderer.render();



                game.batch.begin();
                game.batch.draw(House.getInstance().draw().getKeyFrame(elapsed), House.getInstance().getInitialX(), House.getInstance().getInitialY());


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
                } else {
                    if (army.getTroops().size()==0){
                        lost = true;
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

                if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
                    isPaused = true;
                }
            } else {
                Gdx.gl.glClearColor(98, 45, 0, 1);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

                game.batch.begin();
                game.batch.draw(continueText, continueX, 800);
                game.batch.draw(saveGame, ClashOfClansGame.WIDTH /2 - saveGame.getWidth()/2, 500);
                game.batch.end();

                if(Gdx.input.getX() < continueX+continueText.getWidth() && Gdx.input.getX() > continueX && ClashOfClansGame.HEIGHT - Gdx.input.getY() < 800+continueText.getHeight() && ClashOfClansGame.HEIGHT - Gdx.input.getY() > 800){
                    setHandCursor();
                    if(Gdx.input.justTouched()){


                        isPaused = false;
                    }
                } else if(Gdx.input.getX() < saveAndQuitX+saveGame.getWidth() && Gdx.input.getX() > saveAndQuitX && ClashOfClansGame.HEIGHT - Gdx.input.getY() < 500+saveGame.getHeight() && ClashOfClansGame.HEIGHT - Gdx.input.getY() > 500){
                    if(Gdx.input.justTouched()){
                        win();

                        ArrayList<Float> xCoords = new ArrayList<>();
                        ArrayList<Float> yCoords = new ArrayList<>();
                        ArrayList<Integer> armyType = new ArrayList<>();
                        for(Warrior war : army.getTroops()){
                            xCoords.add(war.getInitialX());
                            yCoords.add(war.getInitialY());
                            armyType.add(war.getWarriorType());
                        }


//                    HashMap<String, Object> saved = new HashMap<String, Object>();
//                    saved.put("0", level);
//                    saved.put("1", mapPath);
//                    saved.put("2", defenses.getDefenses());
//                    saved.put("3", army.getTroops());
//                    saved.put("4", army.getTroopsAvailable());
//
//                    try {
//                        FileOutputStream fos = new FileOutputStream("SaveFiles/save.obj");
//                        ObjectOutputStream oos = new ObjectOutputStream(fos);
//                        oos.writeObject(saved);
//                        oos.flush();
//                        oos.close();
//                        fos.close();
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }


////                    game.dispose();
////                    Gdx.app.exit();
//                    try {
////                        GameDataHolder gameDataHolder = new GameDataHolder(this.mapPath);
////                        gameDataHolder.level_SAVED = level;
////                        //gameDataHolder.mapPath = "Hola";
//////                        gameDataHolder.defenses_SAVED = defenses;
//////                        gameDataHolder.defensesArray_SAVED = defenses.getDefenses();
//////                        gameDataHolder.army_SAVED = army;
//////                        gameDataHolder.troops_SAVED = army.getTroops();
////                        writeJSON(gameDataHolder, "SaveFiles/save.json");
//                    } catch (Exception e){
//                        System.out.println(e.getMessage());
//                    }
//
//                    isPaused = false;
                    }
                } else {
                    setNormalCursor();
                }
            }
        } else {
            Gdx.gl.glClearColor(98, 45, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            game.batch.begin();
            game.batch.draw(continueText, continueX, 800);
            game.batch.end();

            if(Gdx.input.getX() < continueX+continueText.getWidth() && Gdx.input.getX() > continueX && ClashOfClansGame.HEIGHT - Gdx.input.getY() < 800+continueText.getHeight() && ClashOfClansGame.HEIGHT - Gdx.input.getY() > 800){
                setHandCursor();
                if(Gdx.input.justTouched()){
                    lost = false;
                    this.dispose();
                    game.setScreen(new LevelScreen(game, "Tiles/gameMap1.tmx", Levels.LEVEL1));
                }
            }
        }



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

    private static <E> void writeJSON(E object, String path)throws IOException {
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter(path);
        writer.write(gson.toJson(object));
        writer.close();
    }

    private void win(){
        this.dispose();
        if(level==Levels.LEVEL15){
            game.setScreen(new LevelScreen(game, "Tiles/gameMap15.tmx", Levels.LEVEL15));
        } else {
            game.setScreen(new LevelScreen(game, "Tiles/gameMap"+(level.ordinal()+1)+".tmx", level.next()));
        }
    }

}
