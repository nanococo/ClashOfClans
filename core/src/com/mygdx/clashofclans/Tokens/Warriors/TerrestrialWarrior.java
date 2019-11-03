package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Warrior;

enum Directions {LEFT, RIGHT, TOP, BOTTOM, CENTER};

public class TerrestrialWarrior extends Warrior {

    private String[] animations;

    private boolean movingRight;
    private boolean walking;
    private boolean attackingWall;

    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> walkingAnimation;
    private Animation<TextureRegion> attackAnimation;
    private Animation<TextureRegion> hurtAnimation;
    private Animation<TextureRegion> idleAnimationL;
    private Animation<TextureRegion> walkingAnimationL;
    private Animation<TextureRegion> attackAnimationL;
    private Animation<TextureRegion> hurtAnimationL;
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
        movingRight = false;
        walking = false;
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

        animationHeight = 28;
        animationWidth = 28;
    }
    private void walk(){

        float greaterIncrease = calcGreaterIncrease();
        if (Math.abs(getTargetX()-initialX) > Math.abs(getTargetY()-initialY)){
            if (initialX < super.getTargetX()){
                //Right
                movingRight = true;
                if (!collidesRight()) {
                    if(!timer) {
                        initialX += greaterIncrease;
                    }
                } else {
                    removeWallDelay();
                }
            }
            if (initialX > super.getTargetX()) {
                //Left
                movingRight = false;
                if (!collidesLeft()) {
                    if(!timer) {
                        initialX -= greaterIncrease;
                    }
                } else {
                    removeWallDelay();
                }
            }
            if (initialY < super.getTargetY()){
                //Up
                if (!collidesTop()) {
                    if(!timer) {
                        initialY++;
                    }
                } else {
                    removeWallDelay();
                }
            }
            if (initialY > super.getTargetY()) {
                //Down
                if (!collidesBottom()) {
                    if(!timer) {
                        initialY--;
                    }
                } else {
                    removeWallDelay();
                }
            }
        } else{
            if (initialX < super.getTargetX()){
                //Right
                movingRight = true;
                if (!collidesRight()) {
                    if(!timer) {
                        initialX++;
                    }
                } else {
                    removeWallDelay();
                }
            }
            if (initialX > super.getTargetX()) {
                //Left
                movingRight = false;
                if (!collidesLeft()) {
                    if(!timer) {
                        initialX--;
                    }
                } else {
                    removeWallDelay();
                }
            }
            if (initialY < super.getTargetY()){
                //Up
                if (!collidesTop()) {
                    if(!timer) {
                        initialY += greaterIncrease;
                    }
                } else {
                    removeWallDelay();
                }
            }
            if (initialY > super.getTargetY()) {
                //Down
                if (!collidesBottom()) {
                    if(!timer) {
                        initialY -= greaterIncrease;
                    }
                } else {
                    removeWallDelay();
                }
            }
        }
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
            if(attackingWall){
                return attackAnimation;
            } else {
                if (hitted){
                    hitted = false;
                    return hurtAnimation;
                }
                if(dead){
                    return super.dieAnimation;
                }
                else if(targetLocked){
                    return attackAnimation;
                }
                else if(walking){
                    return walkingAnimation;
                } else return idleAnimation;
            }
        }
        else{
            if(attackingWall){
                return attackAnimationL;
            } else {
                if (hitted){
                    hitted = false;
                    return hurtAnimation;
                }
                if(dead){
                    return super.dieAnimationL;
                }
                else if(targetLocked){
                    return attackAnimationL;
                }
                else if(walking){
                    return walkingAnimationL;
                }else return idleAnimationL;
            }
        }
    }

    @Override
    public void doAction() {
        if(!attackingWall){
            if(targetLocked){
                attack();
            }
            else if(walking){
                checkDestination();
                walk();
            } else {
                walking = true;
            }
        }else if(walking){
            checkDestination();
            walk();
        } else {
            walking = true;
        }
        if(timer){
            removeWallDelay();
        }
    }

    public void checkDestination(){
        if (walking){
            if (initialX == targetX && initialY == targetY) walking = false;
        }
    }

    private boolean isCellBlocked(float x, float y){
        TiledMapTileLayer.Cell cell = collisionLayer.getCell((int) (x/collisionLayer.getTileWidth()), (int) (y/collisionLayer.getTileHeight()));
        return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey("Attackable");
    }

    private boolean collidesRight(){
        boolean collides = false;

        for (float step = 0; step < animationWidth; step+=(collisionLayer.getTileHeight())/2){
            collides = isCellBlocked(initialX + animationWidth, initialY + step);
            if (collides){
                removeWallDelay(collisionLayer.getCell((int) ((initialX + animationWidth)/collisionLayer.getTileWidth()), (int) ((initialY + step)/collisionLayer.getTileHeight())));
                break;
            }
        }
        return collides;
    }

    private boolean collidesLeft(){
        boolean collides = false;

        for (float step = 0; step < animationWidth; step+=collisionLayer.getTileHeight()/2){
            collides = isCellBlocked(initialX, initialY + step);
            if (collides){
                removeWallDelay(collisionLayer.getCell((int) ((initialX)/collisionLayer.getTileWidth()), (int) ((initialY + step)/collisionLayer.getTileHeight())));
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
                removeWallDelay(collisionLayer.getCell((int) ((initialX + step)/collisionLayer.getTileWidth()), (int) ((initialY + (animationHeight))/collisionLayer.getTileHeight())));
                break;
            }
        }
        return collides;
    }

    private boolean collidesBottom(){
        boolean collides = false;

        for (float step = 0; step < animationWidth; step+=collisionLayer.getTileWidth()/2){
            collides = isCellBlocked(initialX + step, initialY);
            if (collides){
                removeWallDelay(collisionLayer.getCell((int) ((initialX + step)/collisionLayer.getTileWidth()), (int) ((initialY)/collisionLayer.getTileHeight())));
                break;
            }
        }
        return collides;
    }

    private void removeCell(TiledMapTileLayer.Cell cell){
        if(map.getTileSets().getTileSet(0).getTile(227)!=null && cell!=null && cell.getTile().getId()!=313){
            if(cell.getTile().getId()!=313){
                cell.setTile(map.getTileSets().getTileSet(0).getTile(227));
            }
        }
    }

    private void removeWallDelay(TiledMapTileLayer.Cell cell){
        if (!timer){
            start = System.currentTimeMillis();
            timer = true;
            attackingWall = true;
        }
        finish = System.currentTimeMillis();
        if(finish-start>=1000){
            System.out.println("Stopped");
            removeCell(cell);
            timer = false;
            attackingWall = false;
        }
    }

    private void removeWallDelay(){
        if (timer){
            finish = System.currentTimeMillis();
            if(finish-start>=1000){
                System.out.println("Stopped");
                timer = false;
                attackingWall = false;
            }
        }
    }
}
