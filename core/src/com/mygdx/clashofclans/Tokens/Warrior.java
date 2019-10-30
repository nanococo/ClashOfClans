package com.mygdx.clashofclans.Tokens;


import com.mygdx.clashofclans.Tokens.Token;

public class Warrior extends Token {

    private String name;
    private int life;
    private int attackRate;
    private int consumptionInArmy;
    private int levelAvailable;


    public Warrior(int pInitialX, int pInitialY, int pLife, int pAttackRange) {
        super(pInitialX, pInitialY, pLife, pAttackRange);
    }
}
