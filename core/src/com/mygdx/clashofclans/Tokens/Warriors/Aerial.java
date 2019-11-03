package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Warrior;

public class Aerial extends Warrior {

    private String[] animations;
    private Defense initialTarget;
    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> attackAnimation;
    private Animation<TextureRegion> hurtAnimation;


    public void setInitialTarget(Defense initialTarget) {
        this.initialTarget = initialTarget;
    }

    public Aerial(float pInitialX, float pInitialY, String[] pAnimations) {
        super(pInitialX, pInitialY, AERIAL_WARRIOR_LIFE, AERIAL_WARRIOR_RANGE, AERIAL_WARRIOR_LEVELAVAILABLE, AERIAL_WARRIOR_TROOPS_CONSUMED, AERIAL_WARRIOR_ATTACKRATE, AERIAL_WARRIOR_UPGRADERATE);
        animations = pAnimations;
        idleAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[0]).read());
        attackAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[1]).read());
        hurtAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[2]).read());

    }

    @Override
    public Animation<TextureRegion> draw() {
        return null;
    }

    @Override
    public void doAction() {

    }
}
