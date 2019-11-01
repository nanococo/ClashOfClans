package com.mygdx.clashofclans.Tokens;

import com.mygdx.clashofclans.Tokens.Interfaces.IDefenseConstants;

public abstract class Defense extends Piece implements IDefenseConstants {

    public Defense(float pPositionX, float pPositionY, int pLife, int pAttackRange, double pAttackRate) {
        super(pPositionX, pPositionY, pLife, pAttackRange, pAttackRate);
    }

}
