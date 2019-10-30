package com.mygdx.clashofclans.Tokens;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Token extends Sprite {

    private int initialX;
    private int initialY;
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

    public void attack(int pRange, Token pAttackTargets){}
    public void die(){}

}
