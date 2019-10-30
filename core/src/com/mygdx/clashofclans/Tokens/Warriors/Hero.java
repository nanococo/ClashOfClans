package com.mygdx.clashofclans.Tokens.Warriors;

import com.mygdx.clashofclans.Tokens.Interfaces.ITerrestrialWarrior;
import com.mygdx.clashofclans.Tokens.Warrior;

public class Hero extends Warrior implements ITerrestrialWarrior {


    public Hero(int pInitialX, int pInitialY, int pLife, int pAttackRange) {

        super(pInitialX, pInitialY, pLife, pAttackRange);
    }

    @Override
    public void move() {

    }
}
