package com.mygdx.clashofclans.Tokens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.levelManager.LevelData;

public abstract class Piece extends Sprite {

    protected int animationHeight;
    protected int animationWidth;
    protected int attackRange;
    protected int life;
    protected int level;
    protected double attackRate;
    protected float targetX;
    protected float targetY;
    protected float initialX;
    protected float initialY;
    protected float nextAttack;
    protected boolean dead;
    protected boolean targetLocked;
    protected boolean attacking;
    protected Piece target;
    protected LevelData levelData = LevelData.getInstance();


    public Piece(float pInitialX, float pInitialY, int pLife, int pAttackRange, double pAttackRate){
        initialX = pInitialX;
        initialY = pInitialY;
        attackRange = pAttackRange;
        life = pLife;
        attackRate = pAttackRate;
        level = 1;
        targetX = Calculations.getBaseCenter(levelData.getMinBaseWidth(), levelData.getMaxBaseWidth());
        targetY = Calculations.getBaseCenter(levelData.getMinBaseHeight(), levelData.getMaxBaseHeight());
        target = null;
        nextAttack = 0;
    }

    public void initFlags(){
        dead = false;
        targetLocked = false;
        attacking = false;
    }

    public float getTargetX() {
        return targetX;
    }
    public float getTargetY() {
        return targetY;
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

    public void setTargetDirection(float x, float y){
        targetX = x;
        targetY = y;
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

    public void setTargetX(float targetX) {
        this.targetX = targetX;
    }

    public void setTargetY(float targetY) {
        this.targetY = targetY;
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
}
