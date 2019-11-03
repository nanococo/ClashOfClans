package com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarriors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.Tokens.Interfaces.MakesSound;
import com.mygdx.clashofclans.Tokens.Piece;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;

public class Contact extends TerrestrialWarrior implements MakesSound {

    private float levelBonus;
    private Sound idleSound;
    private Sound attackSound;


    public Contact(float pInitialX, float pInitialY, String[] pAnimations, TiledMapTileLayer mapTileLayer, TiledMap map) {
        super(pInitialX, pInitialY, CONTACT_WARRIOR_LIFE, CONTACT_WARRIOR_RANGE, CONTACT_WARRIOR_LEVELAVAILABLE, CONTACT_WARRIOR_TROOPS_CONSUMED, CONTACT_WARRIOR_ATTACKRATE, pAnimations, mapTileLayer, map);
        levelBonus = Calculations.levelBonus(levelAvailable, level, (float)upgradeRate);
        idleSound = Gdx.audio.newSound(Gdx.files.internal("SoundEffects/ContactWarrior/minecraft-villager-sound-effect.mp3"));
        attackSound = Gdx.audio.newSound(Gdx.files.internal("SoundEffects/ContactWarrior/Sword Swing-SoundBible.com-639083727.mp3"));
        addBonusLevel();
    }
    private void addBonusLevel(){
        life+=levelBonus;
        attackRate+=levelBonus;
    }

    @Override
    public Animation<TextureRegion> draw(){
        if (movingRight){
            if(attackingWall){
                playSound();
                return attackAnimation;
            } else {
                if(dead){
                    return super.dieAnimation;
                }
                else if(targetLocked){
                    playSound();
                    return attackAnimation;
                }
                else if(walking){
                    return walkingAnimation;
                } else{
                    playSound();
                    return idleAnimation;
                }
            }
        }
        else{
            if(attackingWall){
                playSound();
                return attackAnimationL;
            } else {
                if(dead){
                    return super.dieAnimationL;
                }
                else if(targetLocked){
                    playSound();
                    return attackAnimationL;
                }
                else if(walking){
                    return walkingAnimationL;
                } else {
                    playSound();
                    return idleAnimationL;
                }
            }
        }

    }

    @Override
    public void playSound() {
        if (!timer) {
            start = System.currentTimeMillis();
            timer = true;
        }
        finish = System.currentTimeMillis();
        if (finish - start >= 2000) {
            if (targetLocked) attackSound.play();
            else if(!walking) idleSound.play();
            timer = false;
        }
    }
}
