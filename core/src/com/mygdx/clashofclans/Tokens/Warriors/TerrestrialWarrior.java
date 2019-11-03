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
                    initialX += greaterIncrease;
                } else if (isCellBlocked(initialX, initialY)){
                    destroyWall(Directions.CENTER);
                } else {
                    destroyWall(Directions.RIGHT);
                }
            }
            if (initialX > super.getTargetX()) {
                //Left
                movingRight = false;
                if (!collidesLeft()) {
                    initialX -= greaterIncrease;
                } else if (isCellBlocked(initialX, initialY)){
                    destroyWall(Directions.CENTER);
                } else {
                    destroyWall(Directions.LEFT);
                }
            }
            if (initialY < super.getTargetY()){
                //Up
                if (!collidesTop()) {
                    initialY++;
                } else if (isCellBlocked(initialX, initialY)){
                    destroyWall(Directions.CENTER);
                } else {
                    destroyWall(Directions.TOP);
                }
            }
            if (initialY > super.getTargetY()) {
                //Down
                if (!collidesBottom()) {
                    initialY--;
                }else if (isCellBlocked(initialX, initialY)){
                    destroyWall(Directions.CENTER);
                } else {
                    destroyWall(Directions.BOTTOM);
                }
            }
        } else{
            if (initialX < super.getTargetX()){
                //Right
                movingRight = true;
                if (!collidesRight()) {
                    initialX++;
                } else if (isCellBlocked(initialX, initialY)){
                    destroyWall(Directions.CENTER);
                } else  {
                    destroyWall(Directions.RIGHT);
                }
            }
            if (initialX > super.getTargetX()) {
                //Left
                movingRight = false;
                if (!collidesLeft()) {
                    initialX--;
                } else if (isCellBlocked(initialX, initialY)){
                    destroyWall(Directions.CENTER);
                } else {
                    destroyWall(Directions.LEFT);
                }
            }
            if (initialY < super.getTargetY()){
                //Up
                if (!collidesTop()) {
                    initialY += greaterIncrease;
                } else if (isCellBlocked(initialX, initialY)){
                    destroyWall(Directions.CENTER);
                } else {
                    destroyWall(Directions.TOP);
                }
            }
            if (initialY > super.getTargetY()) {
                //Down
                if (!collidesBottom()) {
                    initialY -= greaterIncrease;
                } else if (isCellBlocked(initialX, initialY)){
                    destroyWall(Directions.CENTER);
                } else {
                    destroyWall(Directions.BOTTOM);
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
        else{
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

    @Override
    public void doAction() {
        if(targetLocked){
            attack();
        }
        else if(walking){
            checkDestination();
            walk();
        } else {
            walking = true;
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
                break;
            } else if (isCellBlocked(initialX+4 + animationWidth, initialY + step)){
                collides=true;
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

    private boolean collidesBottom(){
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

    private void destroyWall(Directions directions){
        TiledMapTileLayer.Cell cell;
        switch (directions){
            case TOP:
                cell = collisionLayer.getCell(((int) Math.floor(((initialX+animationWidth)/collisionLayer.getTileWidth()))), ((int) Math.floor(((initialY+animationWidth/2f)/collisionLayer.getTileHeight())))+1);
                break;
            case BOTTOM:
                cell = collisionLayer.getCell(((int) Math.floor(((initialX+animationWidth)/collisionLayer.getTileWidth()))), ((int) Math.floor(((initialY+animationWidth/2f)/collisionLayer.getTileHeight())))-1);
                break;
            case LEFT:
                cell = collisionLayer.getCell(((int) Math.floor(((initialX+animationWidth)/collisionLayer.getTileWidth())))-1, (int) Math.floor(((initialY+animationWidth/2f)/collisionLayer.getTileHeight())));
                break;
            case RIGHT:
                cell = collisionLayer.getCell(((int) Math.floor(((initialX+animationWidth)/collisionLayer.getTileWidth())))+1, (int) Math.floor(((initialY+animationWidth/2f)/collisionLayer.getTileHeight())));
                break;
            default:
                //Center is default
                cell = collisionLayer.getCell(((int) Math.floor(((initialX+animationWidth)/collisionLayer.getTileWidth()))), (int) Math.floor(((initialY+animationWidth/2f)/collisionLayer.getTileHeight())));
                break;
        }
        removeCell(cell);

    }

    void removeCell(TiledMapTileLayer.Cell cell){
        if(map.getTileSets().getTileSet(0).getTile(33)!=null && cell!=null && cell.getTile().getId()!=313){
            if(cell.getTile().getId()!=313){
                System.out.println(cell.getTile().getId());
                cell.setTile(map.getTileSets().getTileSet(0).getTile(33));
            }
        }
    }

    // function to find the number closest to n
    // and divisible by m
    static int closestNumber(int n, int m)
    {
        // find the quotient
        int q = n / m;

        // 1st possible closest number
        int n1 = m * q;

        // 2nd possible closest number
        int n2 = (n * m) > 0 ? (m * (q + 1)) : (m * (q - 1));

        // if true, then n1 is the required closest number
        if (Math.abs(n - n1) < Math.abs(n - n2))
            return n1;

        // else n2 is the required closest number
        return n2;
    }
}
