package com.mygdx.clashofclans.Tokens;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Token {

    public int initialX;
    public int initialY;
    public int animationHeight;
    public int animationWidth;
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
    public abstract void attack(Token pAttackTargets);
    public void die(){}



}
