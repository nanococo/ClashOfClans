package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Interfaces.ITerrestrialWarrior;
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.screens.LevelScreen;

public class Hero extends Warrior implements ITerrestrialWarrior{

    private String[] animations;
    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> walkingAnimation;
    private Animation<TextureRegion> attackAnimation;
    private Animation<TextureRegion> hurtAnimation;
    private TiledMapTileLayer collisionLayer;

    public Hero(int pInitialX, int pInitialY, String[] pAnimations) {
        super(pInitialX, pInitialY, HERO_WARRIOR_LIFE, HERO_WARRIOR_RANGE, HERO_WARRIOR_LEVELAVAILABLE, HERO_WARRIOR_TROOPS_CONSUMED, HERO_WARRIOR_ATTACKRATE, HERO_WARRIOR_UPGRADERATE);
        collisionLayer = LevelScreen.tileLayer;
        animations = pAnimations;
        idleAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[0]).read());
        walkingAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[1]).read());
        attackAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[2]).read());
        hurtAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[3]).read());
    }

    @Override
    public void move() {
        float oldX = initialX;
        float oldY = initialY;
        float tileWidth = collisionLayer.getTileWidth();
        float tileHeight = collisionLayer.getTileHeight();
        boolean collisionX = false;
        boolean collisionY = false;


        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            //y+=4;
            initialY+=4;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            // y-=4;
            initialY-=4;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            //x+=4;
            initialX+=4;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            //x-=4;
            //collisionX = collisionLayer.getCell((int) (initialX / tileWidth), initialY)

            initialX-=4;


        }
    }

    @Override
    public Animation<TextureRegion> draw(){
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            return walkingAnimation;
        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            return attackAnimation;
        } else {
            return idleAnimation;
        }
    }
}
