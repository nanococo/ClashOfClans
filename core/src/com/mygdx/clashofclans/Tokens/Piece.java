package com.mygdx.clashofclans.Tokens;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Piece extends Sprite {

    public float initialX;
    public float initialY;
    public int animationHeight;
    public int animationWidth;
    private int attackRange;
    private double attackRate;
    private float targetX;
    private float targetY;
    private int life;
    private int level;

    public Piece(float pInitialX, float pInitialY, int pLife, int pAttackRange, double pAttackRate){
        initialX = pInitialX;
        initialY = pInitialY;
        attackRange = pAttackRange;
        life = pLife;
        attackRate = pAttackRate;
        level = 1;
        targetX = 450;
        targetY = 450;
    }

    public float getTargetX() {
        return targetX;
    }
    public float getTargetY() {
        return targetY;
    }
    public abstract Animation<TextureRegion> draw();
    public void attack(Piece pAttackTarget){

    }
    public void die(){

    }
    public void setTarget(float x, float y){
        targetX = x;
        targetY = y;
    }




}
