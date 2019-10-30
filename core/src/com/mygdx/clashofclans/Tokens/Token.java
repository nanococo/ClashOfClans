package com.mygdx.clashofclans.Tokens;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Token extends Sprite {

    private int initialX;
    private int initialY;
    private int attackRange;
    private int life;

    public Token(int pInitialX, int pInitialY, int pLife, int pAttackRange){

        initialX = pInitialX;
        initialY = pInitialY;
        attackRange = pAttackRange;
        life = pLife;

    }

    public void attack(int pRange, Token pAttackTargets){}
    public void die(){}

}
