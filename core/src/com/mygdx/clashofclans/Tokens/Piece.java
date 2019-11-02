package com.mygdx.clashofclans.Tokens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Piece extends Sprite {

    public float initialX;
    public float initialY;
    protected int animationHeight;
    protected int animationWidth;
    private int attackRange;
    private double attackRate;
    private float targetX;
    private float targetY;
    private Piece target;
    private int life;
    private int level;

    protected boolean dead;
    protected boolean attacking;


    public Piece(float pInitialX, float pInitialY, int pLife, int pAttackRange, double pAttackRate){
        initialX = pInitialX;
        initialY = pInitialY;
        attackRange = pAttackRange;
        life = pLife;
        attackRate = pAttackRate;
        level = 1;
        targetX = 450;
        targetY = 450;
        target = null;
    }

    public void initFlags(){

    }

    public float getTargetX() {
        return targetX;
    }
    public float getTargetY() {
        return targetY;
    }
    public abstract Animation<TextureRegion> draw();
    public void attack(){
        attacking = true;
        float time  = 0;

        if(time >= attackRate){
            target.recieveDamage();
            time = 0;
        }
        time += Gdx.graphics.getDeltaTime();
        if (target.life <= 0){
            target.setDead(true);
            kill();
        }

    }

    public void kill(){
        target = null;
    }

    public void setTargetDirection(float x, float y){
        targetX = x;
        targetY = y;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void recieveDamage(){
        life--;
    }



}
