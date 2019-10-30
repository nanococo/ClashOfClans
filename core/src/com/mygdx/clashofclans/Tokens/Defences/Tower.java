package com.mygdx.clashofclans.Tokens.Defences;

import com.mygdx.clashofclans.Tokens.Defense;

public class Tower extends Defense {

    public Tower(int pInitialX, int pInitialY) {
        super(pInitialX, pInitialY, TOWER_DEFENSE_LIFE, TOWER_DEFENSE_RANGE, TOWER_DEFENSE_ATTACKRATE);
    }
}
