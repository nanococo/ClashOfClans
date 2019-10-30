package com.mygdx.clashofclans.Tokens.Warriors;

import com.mygdx.clashofclans.Tokens.Warrior;

public class Aerial extends Warrior {


    public Aerial(int pInitialX, int pInitialY, int pAttackRange) {
        super(pInitialX, pInitialY, AERIAL_WARRIOR_LIFE, pAttackRange, AERIAL_WARRIOR_LEVELAVAILABLE, AERIAL_WARRIOR_TROOPS_CONSUMED, AERIAL_WARRIOR_ATTACKRATE, AERIAL_WARRIOR_UPGRADERATE);
    }
}
