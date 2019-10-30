package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Interfaces.ITerrestrialWarrior;
import com.mygdx.clashofclans.Tokens.Warrior;

public class Hero extends Warrior implements ITerrestrialWarrior{

    private final static String PATH_TO_IDLE_ANIMATION = "Hector/Hector (Idle).gif";
    private final static String PATH_TO_WALKING_ANIMATION = "Hector/Hector (Walking).gif";
    private final static String PATH_TO_ATTACK_ANIMATION = "Hector/Hector (Attack).gif";
    private final static String PATH_TO_HURT_ANIMATION = "Hector/Hector (Hurt).gif";

    public Animation<TextureRegion> idleAnimation;
    public Animation<TextureRegion> walkingAnimation;
    public Animation<TextureRegion> attackAnimation;
    public Animation<TextureRegion> hurtAnimation;

    public Hero(int pInitialX, int pInitialY, int pAttackRange) {
        super(pInitialX, pInitialY, HERO_WARRIOR_LIFE, pAttackRange, HERO_WARRIOR_LEVELAVAILABLE, HERO_WARRIOR_TROOPS_CONSUMED, HERO_WARRIOR_ATTACKRATE, HERO_WARRIOR_UPGRADERATE);
        idleAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(PATH_TO_IDLE_ANIMATION).read());
        walkingAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(PATH_TO_WALKING_ANIMATION).read());
        attackAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(PATH_TO_ATTACK_ANIMATION).read());
        hurtAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(PATH_TO_HURT_ANIMATION).read());
    }

    @Override
    public void move() {

    }

}
