package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Interfaces.ITerrestrialWarrior;
import com.mygdx.clashofclans.Tokens.Interfaces.IWarriorConstants;
import com.mygdx.clashofclans.Tokens.Warrior;

public class Beast extends Warrior implements ITerrestrialWarrior {

    private String[] animations;
    public Animation<TextureRegion> idleAnimation;
    public Animation<TextureRegion> walkingAnimation;
    public Animation<TextureRegion> attackAnimation;
    public Animation<TextureRegion> hurtAnimation;


    public Beast(int pInitialX, int pInitialY, String[] pAnimations) {
        super(pInitialX, pInitialY, BEAST_WARRIOR_LIFE, BEAST_WARRIOR_RANGE, BEAST_WARRIOR_LEVELAVAILABLE, BEAST_WARRIOR_TROOPS_CONSUMED, BEAST_WARRIOR_ATTACKRATE, BEAST_WARRIOR_UPGRADERATE);
        animations = pAnimations;
        idleAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[0]).read());
        walkingAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[1]).read());
        attackAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[2]).read());
        hurtAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[3]).read());
    }

    @Override
    public void move() {

    }

    @Override
    public Animation<TextureRegion> draw() {
        return null;
    }
}
