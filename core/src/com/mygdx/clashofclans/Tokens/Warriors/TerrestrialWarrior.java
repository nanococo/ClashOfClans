package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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


    public TerrestrialWarrior(float pInitialX, float pInitialY, int pLife, int pAttackRange, int pLevelAvailable, int pConsumptionInArmy, double pAttackRate, double pUpgradeRate, String[] pAnimations) {
        super(pInitialX, pInitialY, pLife, pAttackRange, pLevelAvailable, pConsumptionInArmy, pAttackRate, pUpgradeRate);
        animations = pAnimations;
        idleAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[0]).read());
        walkingAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[1]).read());
        attackAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[2]).read());
        hurtAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[3]).read());
        idleAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[4]).read());
        walkingAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[5]).read());
        attackAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[6]).read());
        hurtAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[7]).read());
        movingRight = true;
        walking = true;
    }

    public void walk(){
        float greaterEncrease = calcGreaterEncrease();

        if (Math.abs(getTargetX()-initialX) > Math.abs(getTargetY()-initialY)){
            if (initialX < super.getTargetX()){
                movingRight = true;
                initialX+=greaterEncrease;
            }
            if (initialX > super.getTargetX()) {
                movingRight = false;
                initialX-=greaterEncrease;
            }
            if (initialY < super.getTargetY()){
                initialY++;
            }
            if (initialY > super.getTargetY()) {
                initialY--;
            }
        } else{
            if (initialX < super.getTargetX()){
                movingRight = true;
                initialX++;
            }
            if (initialX > super.getTargetX()) {
                movingRight = false;
                System.out.println("hola");
                initialX--;
            }
            if (initialY < super.getTargetY()){
                initialY+=greaterEncrease;
            }
            if (initialY > super.getTargetY()) {
                initialY-=greaterEncrease;
            }
        }
    }

    public float calcGreaterEncrease(){
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
            return walkingAnimation;
        }
        else{
            return walkingAnimationL;
        }

    }

    @Override
    public void doAction() {
        if(walking){
            walk();
        }
    }
}
