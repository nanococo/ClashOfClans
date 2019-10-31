package com.mygdx.clashofclans.Tokens.Defenses;

import com.mygdx.clashofclans.Tokens.Defense;

public class Bomb extends Defense {

    public Bomb(int pInitialX, int pInitialY) {
        super(pInitialX, pInitialY, BOMB_DEFENSE_LIFE, BOMB_DEFENSE_RANGE, BOMB_DEFENSE_ATTACKRATE);
    }
}
