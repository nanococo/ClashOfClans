package com.mygdx.clashofclans.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.ClashOfClansGame;
import com.mygdx.clashofclans.levelManager.Levels;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class MainMenu implements Screen {

    private Texture img;
    private Texture gameTitle;
    private Texture newGameTxt;
    private Texture newGameTxtHover;
    private Texture loadGameTxt;
    private Texture loadGameTxtHover;
    private Animation<TextureRegion> Hector;
    private Animation<TextureRegion> Yolanda;
    private Animation<TextureRegion> Deuce;
    private Animation<TextureRegion> Bichillos;
    private Animation<TextureRegion> Ringo;

    private float x;
    private float y;
    private float elapsed;
    private ClashOfClansGame game;

    public MainMenu(ClashOfClansGame game) {
        this.game = game;
        Hector = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Hector (Idle).gif").read());
        Yolanda = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Yolanda/Yolanda (Idle).gif").read());
        Deuce = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Deuce/Deuce (Idle).gif").read());
        Bichillos = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Bichillos/Bichillos (Flying).gif").read());
        Ringo = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Ringo/Ringo (Idle).gif").read());



        img = new Texture("mainMenuBackground.png");
        gameTitle = new Texture("GameTitle.png");
        loadGameTxt = new Texture("LoadGameTxt.png");
        newGameTxt = new Texture("NewGameTxt.png");
        newGameTxtHover = new Texture("NewGameTxtHover.png");
        loadGameTxtHover = new Texture("LoadGameTxtHover.png");
    }

    @Override
    public void show() {
        Pixmap pixmap = new Pixmap(Gdx.files.internal("Cursor/Cursor_1.png"));
        int xHotspot = pixmap.getWidth() / 2;
        int yHotspot = pixmap.getHeight() / 2;
        Cursor cursor = Gdx.graphics.newCursor(pixmap, xHotspot, yHotspot);
        Gdx.graphics.setCursor(cursor);
        pixmap.dispose();
    }

    @Override
    public void render(float delta) {
        elapsed += Gdx.graphics.getDeltaTime();
        //Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            y+=4;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y-=4;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x+=4;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x-=4;
        }

        int gameTitleCenterValue = ClashOfClansGame.WIDTH /2 - gameTitle.getWidth()/2;
        int gameTitleHeight = 800;
        int newGameTxtCenterValue = ClashOfClansGame.WIDTH /2 - newGameTxt.getWidth()/2;
        int newGameTxtHeight = 600;
        int loadGameTxtCenterValue = ClashOfClansGame.WIDTH /2 - loadGameTxt.getWidth()/2;
        int loadGameTxtHeight = 500;

        game.batch.begin();
        game.batch.draw(img, 0, 0, ClashOfClansGame.WIDTH, ClashOfClansGame.HEIGHT);
        game.batch.draw(gameTitle, gameTitleCenterValue, gameTitleHeight, gameTitle.getWidth(), gameTitle.getHeight());

        if(Gdx.input.getX() < newGameTxtCenterValue+newGameTxt.getWidth() && Gdx.input.getX() > newGameTxtCenterValue && ClashOfClansGame.HEIGHT - Gdx.input.getY() < newGameTxtHeight+newGameTxt.getHeight() && ClashOfClansGame.HEIGHT - Gdx.input.getY() > newGameTxtHeight){
            game.batch.draw(newGameTxtHover, newGameTxtCenterValue, newGameTxtHeight, newGameTxt.getWidth(), newGameTxt.getHeight());
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new LevelScreen(game, "Tiles/gameMap15.tmx", Levels.LEVEL15));
            }
        } else {
            game.batch.draw(newGameTxt, newGameTxtCenterValue, newGameTxtHeight, newGameTxt.getWidth(), newGameTxt.getHeight());
        }

        if(Gdx.input.getX() < newGameTxtCenterValue+loadGameTxt.getWidth() && Gdx.input.getX() > newGameTxtCenterValue && ClashOfClansGame.HEIGHT - Gdx.input.getY() < loadGameTxtHeight+loadGameTxt.getHeight() && ClashOfClansGame.HEIGHT - Gdx.input.getY() > loadGameTxtHeight){
            game.batch.draw(loadGameTxtHover, loadGameTxtCenterValue, loadGameTxtHeight, loadGameTxt.getWidth(), loadGameTxt.getHeight());
            if(Gdx.input.isTouched()){
//                this.dispose();
//                HashMap<String,Object> retreived = null;
//                try {
//                    FileInputStream fis = new FileInputStream("C:\\GitHub_Projects\\ClashOfClans\\android\\assets\\SaveFiles\\save.obj");
//                    ObjectInputStream ois = new ObjectInputStream(fis);
//
//                    retreived = (HashMap<String,Object>)ois.readObject();
//                    fis.close();
//                }catch (Exception e){
//                    System.out.println(e.getMessage());
//                }
//
//                game.setScreen(new LevelScreen(game, retreived));
            }
        } else {
            game.batch.draw(loadGameTxt, loadGameTxtCenterValue, loadGameTxtHeight, loadGameTxt.getWidth(), loadGameTxt.getHeight());
        }

        game.batch.draw(Hector.getKeyFrame(elapsed), x, y);
        game.batch.draw(Yolanda.getKeyFrame(elapsed), x+100, y);
        game.batch.draw(Deuce.getKeyFrame(elapsed), x+200, y);
        game.batch.draw(Ringo.getKeyFrame(elapsed), x+300, y);
        game.batch.draw(Bichillos.getKeyFrame(elapsed), x+400, y);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
