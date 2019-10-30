package com.mygdx.clashofclans.Tokens.Warriors;

import com.mygdx.clashofclans.Tokens.Interfaces.ITerrestrialWarrior;
import com.mygdx.clashofclans.Tokens.Interfaces.IWarriorConstants;
import com.mygdx.clashofclans.Tokens.Warrior;

public class Hero extends Warrior implements ITerrestrialWarrior{


    public Hero(int pInitialX, int pInitialY, int pAttackRange) {
        super(pInitialX, pInitialY, HERO_WARRIOR_LIFE, pAttackRange, HERO_WARRIOR_LEVELAVAILABLE, HERO_WARRIOR_TROOPS_CONSUMED, HERO_WARRIOR_ATTACKRATE, HERO_WARRIOR_UPGRADERATE);
    }

    @Override
    public void move() {

    }
}
