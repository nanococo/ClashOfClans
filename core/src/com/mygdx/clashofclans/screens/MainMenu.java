package com.mygdx.clashofclans.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.clashOfClansGame;

public class MainMenu implements Screen {

    private Texture img;
    private Texture gameTitle;
    private Texture newGameTxt;
    private Texture newGameTxtHover;
    private Texture loadGameTxt;
    private Texture loadGameTxtHover;
    private Animation<TextureRegion> animation;

    private float x;
    private float y;
    private float elapsed;
    private clashOfClansGame game;

    public MainMenu(clashOfClansGame game) {
        this.game = game;
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Hector (Idle).gif").read());
        img = new Texture("mainMenuBackground.png");
        gameTitle = new Texture("GameTitle.png");
        loadGameTxt = new Texture("LoadGameTxt.png");
        newGameTxt = new Texture("NewGameTxt.png");
        newGameTxtHover = new Texture("NewGameTxtHover.png");
        loadGameTxtHover = new Texture("LoadGameTxtHover.png");
    }

    @Override
    public void show() {

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

        int gameTitleCenterValue = clashOfClansGame.WIDTH /2 - gameTitle.getWidth()/2;
        int gameTitleHeight = 800;
        int newGameTxtCenterValue = clashOfClansGame.WIDTH /2 - newGameTxt.getWidth()/2;
        int newGameTxtHeight = 600;
        int loadGameTxtCenterValue = clashOfClansGame.WIDTH /2 - loadGameTxt.getWidth()/2;
        int loadGameTxtHeight = 500;

        game.batch.begin();
        game.batch.draw(img, 0, 0, clashOfClansGame.WIDTH, clashOfClansGame.HEIGHT);
        game.batch.draw(gameTitle, gameTitleCenterValue, gameTitleHeight, gameTitle.getWidth(), gameTitle.getHeight());

        if(Gdx.input.getX() < newGameTxtCenterValue+newGameTxt.getWidth() && Gdx.input.getX() > newGameTxtCenterValue && clashOfClansGame.HEIGHT - Gdx.input.getY() < newGameTxtHeight+newGameTxt.getHeight() && clashOfClansGame.HEIGHT - Gdx.input.getY() > newGameTxtHeight){
            game.batch.draw(newGameTxtHover, newGameTxtCenterValue, newGameTxtHeight, newGameTxt.getWidth(), newGameTxt.getHeight());
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new LevelScreen(game));
            }
        } else {
            game.batch.draw(newGameTxt, newGameTxtCenterValue, newGameTxtHeight, newGameTxt.getWidth(), newGameTxt.getHeight());
        }

        if(Gdx.input.getX() < newGameTxtCenterValue+loadGameTxt.getWidth() && Gdx.input.getX() > newGameTxtCenterValue && clashOfClansGame.HEIGHT - Gdx.input.getY() < loadGameTxtHeight+loadGameTxt.getHeight() && clashOfClansGame.HEIGHT - Gdx.input.getY() > loadGameTxtHeight){
            game.batch.draw(loadGameTxtHover, loadGameTxtCenterValue, loadGameTxtHeight, loadGameTxt.getWidth(), loadGameTxt.getHeight());
        } else {
            game.batch.draw(loadGameTxt, loadGameTxtCenterValue, loadGameTxtHeight, loadGameTxt.getWidth(), loadGameTxt.getHeight());
        }

        game.batch.draw(animation.getKeyFrame(elapsed), x, y);
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
