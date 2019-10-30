package com.mygdx.clashofclans.Tokens.Warriors;

import com.mygdx.clashofclans.Tokens.Interfaces.ITerrestrialWarrior;
import com.mygdx.clashofclans.Tokens.Interfaces.IWarriorConstants;
import com.mygdx.clashofclans.Tokens.Warrior;

public class MidRange extends Warrior implements ITerrestrialWarrior {


    public MidRange(int pInitialX, int pInitialY, int pAttackRange) {
        super(pInitialX, pInitialY, MIDRANGE_WARRIOR_LIFE, pAttackRange, MIDRANGE_WARRIOR_LEVELAVAILABLE, MIDRANGE_WARRIOR_TROOPS_CONSUMED, MIDRANGE_WARRIOR_TROOPS_CONSUMED, MIDRANGE_WARRIOR_UPGRADERATE);
    }

    @Override
    public void move() {

    }
}
