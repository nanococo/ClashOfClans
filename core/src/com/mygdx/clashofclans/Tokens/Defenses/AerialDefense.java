package com.mygdx.clashofclans.Tokens.Defenses;

import com.mygdx.clashofclans.Tokens.Defense;

public class AerialDefense extends Defense {

    public AerialDefense(int pInitialX, int pInitialY) {
        super(pInitialX, pInitialY, AERIAL_DEFENSE_LIFE, AERIAL_DEFENSE_RANGE, AERIAL_DEFENSE_ATTACKRATE);
    }
}
