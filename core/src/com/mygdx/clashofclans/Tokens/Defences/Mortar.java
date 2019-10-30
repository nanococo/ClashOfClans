package com.mygdx.clashofclans.Tokens.Defences;

import com.mygdx.clashofclans.Tokens.Defense;

public class Mortar extends Defense {

    public Mortar(int pInitialX, int pInitialY) {
        super(pInitialX, pInitialY, MORTAR_DEFENSE_LIFE, MORTAR_DEFENSE_RANGE, MORTAR_DEFENSE_ATTACKRATE);
    }
}
