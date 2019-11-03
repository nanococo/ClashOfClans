package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.Teams.Army;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Interfaces.MakesSound;
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;

import java.util.ArrayList;

public class Bomb extends Defense implements MakesSound {

    private Animation<TextureRegion> bombAnimation;
    private Animation<TextureRegion> bombExplosionAnimation;
    private ArrayList<TerrestrialWarrior> reachableTargets;
    private Army enemies;

    private Sound bombSound;



    Bomb(float pInitialX, float pInitialY) {
        super(pInitialX, pInitialY, BOMB_DEFENSE_LIFE, BOMB_DEFENSE_RANGE, BOMB_DEFENSE_ATTACKRATE);
        reachableTargets = new ArrayList<TerrestrialWarrior>();
        bombAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(BOMB_DEFENSE_ANIMATION).read());
        bombExplosionAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(BOMB_DEFENSE_EXPLOSIONANIMATION).read());
        bombSound = Gdx.audio.newSound(Gdx.files.internal("SoundEffects/Explosion/Explosion_Ultra_Bass-Mark_DiAngelo-1810420658.mp3"));

    }

    @Override
    public Animation<TextureRegion> draw() {
       if (dead){
           return bombExplosionAnimation;
       }
       else{
           return bombAnimation;
       }
    }

    @Override
    public void attack() {

        if (targetLocked){
            setReachableTargets();
            bombExplosion();
        }
    }
    private void bombExplosion(){
        playSound();
        for (TerrestrialWarrior reachableTarget:reachableTargets){
            reachableTarget.setLife(reachableTarget.getLife()-5);
            if (reachableTarget.getLife()<=0){
                reachableTarget.setDead(true);
                killedTarget();
            }
        }
        dead = true;
        life = 0;
    }

    private void setReachableTargets() {
        for (Warrior enemy: enemies.getTroops()){
            if (Calculations.distanceBetweenPoints(initialX, initialY, enemy.getInitialX(), enemy.getInitialY())<=attackRange+100
                && enemy instanceof TerrestrialWarrior){
                   reachableTargets.add((TerrestrialWarrior)enemy);
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
            bombSound.play();
            timer = false;
        }
    }

    public void setEnemies(Army enemies) {
        this.enemies = enemies;
    }

}
