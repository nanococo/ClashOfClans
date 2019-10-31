package com.mygdx.clashofclans.Tokens;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Token extends Sprite {

    public int initialX;
    public int initialY;
    private int attackRange;
    private double attackRate;

    private int life;
    private int level;

    public Token(int pInitialX, int pInitialY, int pLife, int pAttackRange, double pAttackRate){
        initialX = pInitialX;
        initialY = pInitialY;
        attackRange = pAttackRange;
        life = pLife;
        attackRate = pAttackRate;
        level = 1;
    }

    public abstract Animation<TextureRegion> draw();
    public void attack(int pRange, Token pAttackTargets){}
    public void die(){}



}
