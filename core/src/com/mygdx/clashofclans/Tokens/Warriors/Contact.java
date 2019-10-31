package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Interfaces.ITerrestrialWarrior;
import com.mygdx.clashofclans.Tokens.Interfaces.IWarriorConstants;
import com.mygdx.clashofclans.Tokens.Warrior;

public class Contact extends Warrior implements ITerrestrialWarrior {


    private String[] animations;
    public Animation<TextureRegion> idleAnimation;
    public Animation<TextureRegion> walkingAnimation;
    public Animation<TextureRegion> attackAnimation;
    public Animation<TextureRegion> hurtAnimation;


    public Contact(int pInitialX, int pInitialY, String[] pAnimations) {
        super(pInitialX, pInitialY, CONTACT_WARRIOR_LIFE, CONTACT_WARRIOR_RANGE, CONTACT_WARRIOR_LEVELAVAILABLE, CONTACT_WARRIOR_TROOPS_CONSUMED, CONTACT_WARRIOR_ATTACKRATE, CONTACT_WARRIOR_UPGRADERATE);
        animations = pAnimations;
        idleAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[0]).read());
        walkingAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[1]).read());
        attackAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[2]).read());
        hurtAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(animations[3]).read());
    }

    @Override
    public void move() {

    }

}
