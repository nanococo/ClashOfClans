package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Interfaces.ITerrestrialWarrior;
import com.mygdx.clashofclans.Tokens.Token;
import com.mygdx.clashofclans.Tokens.Warrior;

import java.util.Iterator;

public class Hero extends Warrior implements ITerrestrialWarrior{

    private String[] animations;
  
    public Animation<TextureRegion> idleAnimation;
    public Animation<TextureRegion> walkingAnimation;
    public Animation<TextureRegion> attackAnimation;
    public Animation<TextureRegion> hurtAnimation;
    public Animation<TextureRegion> idleAnimationL;
    public Animation<TextureRegion> walkingAnimationL;
    public Animation<TextureRegion> attackAnimationL;
    public Animation<TextureRegion> hurtAnimationL;
    private TiledMapTileLayer collisionLayer;
    private TiledMap map;


    public Hero(int pInitialX, int pInitialY, String[] pAnimations, TiledMapTileLayer collisionLayer, TiledMap map) {
        super(pInitialX, pInitialY, HERO_WARRIOR_LIFE, HERO_WARRIOR_RANGE, HERO_WARRIOR_LEVELAVAILABLE, HERO_WARRIOR_TROOPS_CONSUMED, HERO_WARRIOR_ATTACKRATE, HERO_WARRIOR_UPGRADERATE);
        animations = pAnimations;
        this.collisionLayer = collisionLayer;
        idleAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[0]).read());
        walkingAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[1]).read());
        attackAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[2]).read());
        hurtAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[3]).read());
        idleAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[4]).read());
        walkingAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[5]).read());
        attackAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[6]).read());
        hurtAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[7]).read());
        //animationHeight = idleAnimation.getKeyFrame(0).getRegionHeight();
        animationHeight = 32;
        //animationWidth = idleAnimation.getKeyFrame(0).getRegionWidth();
        animationWidth = 32;
        this.map = map;
    }

    @Override
    public void move() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            if (!collidesTop()){
                initialY+=4;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if (!collidesBottom()){
                initialY-=4;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if (!collidesRight()){
                initialX+=4;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if (!collidesLeft()){
                initialX-=4;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            attack();
        }
    }

    private boolean isCellBlocked(float x, float y){
        TiledMapTileLayer.Cell cell = collisionLayer.getCell((int) (x/collisionLayer.getTileWidth()), (int) (y/collisionLayer.getTileHeight()));
        return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey("Attackable");

    }

    public boolean collidesRight(){
        boolean collides = false;

        for (float step = 0; step < animationWidth; step+=(collisionLayer.getTileHeight())/2){
            collides = isCellBlocked(initialX + animationWidth, initialY + step);
            if (collides){
                break;
            } else if (isCellBlocked(initialX+4 + animationWidth, initialY + step)){
                collides=true;
                break;
            }
        }
        return collides;
    }

    public boolean collidesLeft(){
        boolean collides = false;

        for (float step = 0; step < animationWidth; step+=collisionLayer.getTileHeight()/2){
            collides = isCellBlocked(initialX, initialY + step);
            if (collides){
                break;
            } else if (isCellBlocked(initialX-4, initialY + step)){
                collides=true;
                break;
            }
        }
        return collides;
    }

    private boolean collidesTop(){
        boolean collides = false;

        for (float step = 0; step < animationWidth; step+=collisionLayer.getTileWidth()/2){
            collides = isCellBlocked(initialX + step, initialY + (animationHeight));
            if (collides){
                break;
            } else if (isCellBlocked(initialX + step, initialY+4 + (animationHeight))){
                collides=true;
                break;
            }
        }
        return collides;
    }

    public boolean collidesBottom(){
        boolean collides = false;

        for (float step = 0; step < animationWidth; step+=collisionLayer.getTileWidth()/2){
            collides = isCellBlocked(initialX + step, initialY);
            if (collides){
                break;
            } else if (isCellBlocked(initialX + step, initialY-4)){
                collides=true;
                break;
            }
        }
        return collides;
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

    @Override
    public void attack(Token pAttackTargets) {

    }

    private void destroyWall(){
        TiledMapTileLayer.Cell cell = collisionLayer.getCell(((int) ((initialX+animationWidth)/collisionLayer.getTileWidth()))+1, (int) ((initialY+animationWidth/2)/collisionLayer.getTileHeight()));

        if(map.getTileSets().getTileSet(0).getTile(33)!=null && cell!=null){
            System.out.println("here");
            cell.setTile(map.getTileSets().getTileSet(0).getTile(33));
        }

    }

    public void attack(){
        if(collidesRight()){
            destroyWall();
        }
    }

}
