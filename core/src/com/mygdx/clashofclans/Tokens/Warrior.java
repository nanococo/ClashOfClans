package com.mygdx.clashofclans.Tokens;


import com.mygdx.clashofclans.Tokens.Defenses.Bomb;
import com.mygdx.clashofclans.Tokens.Interfaces.IWarriorConstants;

public abstract class Warrior extends Piece implements IWarriorConstants {

    private int consumptionInArmy;
    private int levelAvailable;
    private double upgradeRate;

    public Warrior(float pInitialX, float pInitialY, int pLife, int pAttackRange, int pLevelAvailable, int pConsumptionInArmy, double pAttackRate, double pUpgradeRate) {
        super(pInitialX, pInitialY, pLife, pAttackRange, pAttackRate);
        levelAvailable = pLevelAvailable;
        consumptionInArmy = pConsumptionInArmy;
        upgradeRate = pUpgradeRate;
    }

    public int getConsumptionInArmy() {
        return consumptionInArmy;
    }

    public int getLevelAvailable() {
        return levelAvailable;
    }

    public double getUpgradeRate() {
        return upgradeRate;
    }

    @Override
    public void setTarget(Piece target){
        if (!(target instanceof Bomb)){
            this.target = target;
            targetLocked = true;
        }

    }
}
