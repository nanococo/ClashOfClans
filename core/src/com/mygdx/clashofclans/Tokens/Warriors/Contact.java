package com.mygdx.clashofclans.Tokens.Warriors;

import com.mygdx.clashofclans.Tokens.Interfaces.ITerrestrialWarrior;
import com.mygdx.clashofclans.Tokens.Interfaces.IWarriorConstants;
import com.mygdx.clashofclans.Tokens.Warrior;

public class Contact extends Warrior implements ITerrestrialWarrior {


    public Contact(int pInitialX, int pInitialY, int pAttackRange) {
        super(pInitialX, pInitialY, CONTACT_WARRIOR_LIFE, pAttackRange, CONTACT_WARRIOR_LEVELAVAILABLE, CONTACT_WARRIOR_TROOPS_CONSUMED, CONTACT_WARRIOR_ATTACKRATE, CONTACT_WARRIOR_UPGRADERATE);
    }

    @Override
    public void move() {

    }

}
