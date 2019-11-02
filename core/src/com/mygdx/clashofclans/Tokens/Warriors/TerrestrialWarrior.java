package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Warrior;

public class TerrestrialWarrior extends Warrior {

    private String[] animations;


    private boolean movingRight;
    private boolean walking;




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


    public TerrestrialWarrior(float pInitialX, float pInitialY, int pLife, int pAttackRange, int pLevelAvailable, int pConsumptionInArmy, double pAttackRate, double pUpgradeRate, String[] pAnimations,
                              TiledMapTileLayer collisionLayer, TiledMap map) {
        super(pInitialX, pInitialY, pLife, pAttackRange, pLevelAvailable, pConsumptionInArmy, pAttackRate, pUpgradeRate);
        animations = pAnimations;
        this.collisionLayer = collisionLayer;
        this.map = map;
        setAnimations();
        initFlags();
    }

    public void initFlags() {
        movingRight = true;
        walking = true;
        attacking = false;
        dead = false;
    }
    private void setAnimations(){
        idleAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[0]).read());
        walkingAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[1]).read());
        attackAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[2]).read());
        hurtAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[3]).read());
        idleAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[4]).read());
        walkingAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[5]).read());
        attackAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[6]).read());
        hurtAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[7]).read());

        animationHeight = 32;
        animationWidth = 32;
    }

    private void walk(){
        float greaterIncrease = calcGreaterIncrease();

        if (Math.abs(getTargetX()-initialX) > Math.abs(getTargetY()-initialY)){
            if (initialX < super.getTargetX()){
                //Right
                movingRight = true;
                if (!collidesRight()) {
                    initialX += greaterIncrease;
                }
            }
            if (initialX > super.getTargetX()) {
                //Left
                movingRight = false;
                if (!collidesLeft()) {
                    initialX -= greaterIncrease;
                }
            }
            if (initialY < super.getTargetY()){
                //Up
                if (!collidesTop()) {
                    initialY++;
                }
            }
            if (initialY > super.getTargetY()) {
                //Down
                if (!collidesBottom()) {
                    initialY--;
                }
            }
        } else{
            if (initialX < super.getTargetX()){
                //Right
                movingRight = true;
                if (!collidesRight()) {
                    initialX++;
                }
            }
            if (initialX > super.getTargetX()) {
                //Left
                movingRight = false;
                if (!collidesLeft()) {
                    initialX--;
                }
            }
            if (initialY < super.getTargetY()){
                //Up
                if (!collidesTop()) {
                    initialY += greaterIncrease;
                }
            }
            if (initialY > super.getTargetY()) {
                //Down
                if (!collidesBottom()) {
                    initialY -= greaterIncrease;
                }
            }
        }

        attack();
    }
    private float calcGreaterIncrease(){
        float trayectory;
        if (Math.abs(getTargetX()-initialX) > Math.abs(getTargetY()-initialY)){
            trayectory = Math.abs(getTargetX()-initialX)/Math.abs(getTargetY()-initialY);
        } else{
            trayectory = Math.abs(getTargetY()-initialY)/Math.abs(getTargetX()-initialX);
        }
        if (trayectory<3)
            return trayectory;
        else return 3;
    }


    @Override
    public Animation<TextureRegion> draw(){
        if (movingRight){
            if(walking){
                return walkingAnimation;
            }
            else if(attacking){
                return attackAnimation;
            }
            else if(dead){
                return idleAnimation;
            }
        }
        else{
            if(walking){
                return walkingAnimationL;
            }
            else if(attacking){
                return attackAnimationL;
            }
            else if(dead){
                return idleAnimationL;
            }
        }
        return null;
    }

    @Override
    public void doAction() {
        if(walking){
            walk();
        }
        else if(attacking){
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
