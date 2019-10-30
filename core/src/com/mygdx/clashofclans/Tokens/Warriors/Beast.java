package com.mygdx.clashofclans.Tokens.Warriors;

import com.mygdx.clashofclans.Tokens.Interfaces.ITerrestrialWarrior;
import com.mygdx.clashofclans.Tokens.Interfaces.IWarriorConstants;
import com.mygdx.clashofclans.Tokens.Warrior;

public class Beast extends Warrior implements ITerrestrialWarrior {


    public Beast(int pInitialX, int pInitialY, int pAttackRange) {
        super(pInitialX, pInitialY, BEAST_WARRIOR_LIFE, pAttackRange, BEAST_WARRIOR_LEVELAVAILABLE, BEAST_WARRIOR_TROOPS_CONSUMED, BEAST_WARRIOR_ATTACKRATE, BEAST_WARRIOR_UPGRADERATE);
    }

    @Override
    public void move() {

    }

}
