package com.mygdx.clashofclans.Tokens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.levelManager.LevelData;

import java.io.Serializable;

public abstract class Piece extends Sprite implements Serializable {

    protected int animationHeight;
    protected int animationWidth;
    protected int attackRange;
    protected int life;
    protected int level;
    protected double attackRate;

    protected float initialX;
    protected float initialY;
    protected float nextAttack;
    protected boolean dead;
    protected boolean targetLocked;
    protected boolean attacking;
    protected boolean timer;
    protected long start;
    protected long finish;
    protected boolean hitted;
    protected Piece target;
    protected LevelData levelData = LevelData.getInstance();



    public Piece(float pInitialX, float pInitialY, int pLife, int pAttackRange, double pAttackRate){
        initialX = pInitialX;
        initialY = pInitialY;
        attackRange = pAttackRange;
        life = pLife;
        attackRate = pAttackRate;
        level = levelData.getActualLevel();

        target = null;
        nextAttack = 0;
    }

    public void initFlags(){
        dead = false;
        targetLocked = false;
        attacking = false;
        hitted = false;
    }

    public abstract Animation<TextureRegion> draw();

    public void attack(){
       if (targetLocked){
           if(nextAttack >= attackRate){
               target.receiveDamage();
               nextAttack = 0;
           }
           nextAttack += Gdx.graphics.getDeltaTime();
           if (target.life <= 0){
               target.setDead(true);
               killedTarget();
           }
       }
    }
    protected void killedTarget(){

        target = null;
        targetLocked = false;

    }

    public void setTarget(Piece target) {
        if (target!=null){
            this.target = target;
            targetLocked = true;
        }

    }

    public void doAction(){
        if (targetLocked){
            attack();
        }
    }


    public boolean isAttacking() {
        return attacking;
    }
    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    public void receiveDamage(){
        life--;
        hitted = true;
        if(life<=0){
            dead = true;
        }
    }


    public void setInitialX(float initialX) {
        this.initialX = initialX;
    }

    public void setInitialY(float initialY) {
        this.initialY = initialY;
    }


    public float getInitialX() {
        return initialX;
    }
    public float getInitialY() {
        return initialY;
    }

    public int getAttackRange() {
        return attackRange;
    }


    public double getAttackRate() {
        return attackRate;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getNextAttack() {
        return nextAttack;
    }

    public void setNextAttack(float nextAttack) {
        this.nextAttack = nextAttack;
    }

    public boolean isTargetLocked() {
        return targetLocked;
    }

    public void setTargetLocked(boolean targetLocked) {
        this.targetLocked = targetLocked;
    }

    public Piece getTarget() {
        return target;
    }

    void attackAnimation(){
        if (!timer){
            start = System.currentTimeMillis();
            timer = true;
        }
        finish = System.currentTimeMillis();
        if(finish-start>=2000){
            System.out.println("Hello");
            timer = false;
        }
    }

}
