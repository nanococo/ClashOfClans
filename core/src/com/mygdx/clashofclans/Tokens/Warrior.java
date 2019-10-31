package com.mygdx.clashofclans.Tokens;


import com.mygdx.clashofclans.Tokens.Interfaces.IWarriorConstants;
import com.mygdx.clashofclans.Tokens.Token;

public abstract class Warrior extends Token implements IWarriorConstants {

    private int consumptionInArmy;
    private int levelAvailable;
    private double upgradeRate;


    public Warrior(int pInitialX, int pInitialY, int pLife, int pAttackRange, int pLevelAvailable, int pConsumptionInArmy, double pAttackRate, double pUpgradeRate) {
        super(pInitialX, pInitialY, pLife, pAttackRange, pAttackRate);
        levelAvailable = pLevelAvailable;
        consumptionInArmy = pConsumptionInArmy;
        upgradeRate = pUpgradeRate;
    }
}
