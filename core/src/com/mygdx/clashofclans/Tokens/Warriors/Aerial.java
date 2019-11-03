package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Interfaces.MakesSound;
import com.mygdx.clashofclans.Tokens.Piece;
import com.mygdx.clashofclans.Tokens.Warrior;

public class Aerial extends Warrior implements MakesSound {

    private String[] animations;
    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> attackAnimation;
    private Animation<TextureRegion> hurtAnimation;
    private float levelBonus;



    public Aerial(float pInitialX, float pInitialY, String[] pAnimations) {
        super(pInitialX, pInitialY, AERIAL_WARRIOR_LIFE, AERIAL_WARRIOR_RANGE, AERIAL_WARRIOR_LEVELAVAILABLE, AERIAL_WARRIOR_TROOPS_CONSUMED, AERIAL_WARRIOR_ATTACKRATE);
        levelBonus = Calculations.levelBonus(levelAvailable, level, (float)upgradeRate);
        animations = pAnimations;
        addBonusLevel();
        idleAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[0]).read());
        attackAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[1]).read());
        hurtAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[2]).read());

    }


    @Override
    public Animation<TextureRegion> draw() {
        if(hitted){
            hitted = false;
            return hurtAnimation;
        }
        if(targetLocked){
            return attackAnimation;
        }else{
            return idleAnimation;
        }
    }

    @Override
    public void doAction(){
        updateRange();
        if (targetLocked){
            attack();
        }
    }

    public void updateRange(){
        if (targetLocked){
            if (Calculations.distanceBetweenPoints(initialX, initialY,  target.getInitialX(), target.getInitialY())>attackRange){
                targetLocked = false;
                target = null;
            }
        }

    }
    private void addBonusLevel(){
        life+=levelBonus;
        attackRate+=levelBonus;
    }

    public void setTarget(Piece target) {

        if (target!=null){
            this.target = target;
            targetX = target.getInitialX();
            targetY = target.getInitialY();
            targetLocked = true;
        }

    }
}
