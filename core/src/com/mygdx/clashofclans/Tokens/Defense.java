package com.mygdx.clashofclans.Tokens;

import com.badlogic.gdx.Gdx;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.Tokens.Interfaces.IDefenseConstants;

import java.io.Serializable;

public abstract class Defense extends Piece implements IDefenseConstants, Serializable {

    public Defense(float pPositionX, float pPositionY, int pLife, int pAttackRange, double pAttackRate) {
        super(pPositionX, pPositionY, pLife, pAttackRange, pAttackRate);
    }

    @Override
    public void doAction(){
        updateRange();
        if (targetLocked){
            attack();
        }
    }

    public void updateRange(){
        if (targetLocked){
            if (Calculations.distanceBetweenPoints(initialX, initialY,  target.getInitialX(), target.getInitialY())>attackRange){
                targetLocked = false;
                target = null;
            }
        }

    }


}
