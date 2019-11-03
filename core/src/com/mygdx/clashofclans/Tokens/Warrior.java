package com.mygdx.clashofclans.Tokens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defenses.Bomb;
import com.mygdx.clashofclans.Tokens.Interfaces.IWarriorConstants;

import java.io.Serializable;

public abstract class Warrior extends Piece implements IWarriorConstants, Serializable {

    protected int warriorType;
    protected int consumptionInArmy;
    protected int levelAvailable;
    protected double upgradeRate;

    protected Animation<TextureRegion> dieAnimation;
    protected Animation<TextureRegion> dieAnimationL;


    public Warrior(float pInitialX, float pInitialY, int pLife, int pAttackRange, int pLevelAvailable, int pConsumptionInArmy, double pAttackRate) {
        super(pInitialX, pInitialY, pLife, pAttackRange, pAttackRate);
        dieAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(PERSON_DEAD_ANIMATION_RIGHT).read());
        dieAnimationL = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(PERSON_DEAD_ANIMATION_LEFT).read());
        levelAvailable = pLevelAvailable;
        consumptionInArmy = pConsumptionInArmy;
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

    public int getWarriorType() {
        return warriorType;
    }

    public void setWarriorType(int warriorType) {
        this.warriorType = warriorType;
    }

    @Override
    public void setTarget(Piece target){
        if (!(target instanceof Bomb)){
            this.target = target;
            targetLocked = true;
        }

    }


}
