package com.mygdx.clashofclans.Tokens;

import com.mygdx.clashofclans.Tokens.Interfaces.IDefenseConstants;
import com.mygdx.clashofclans.Tokens.Token;

public class Defense extends Token implements IDefenseConstants {

    public Defense(int pInitialX, int pInitialY, int pLife, int pAttackRange, double pAttackRate) {
        super(pInitialX, pInitialY, pLife, pAttackRange, pAttackRate);
    }

}
