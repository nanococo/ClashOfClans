package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Token;

public class Canyon extends Defense {

    public Canyon(int pInitialX, int pInitialY) {
        super(pInitialX, pInitialY, CANYON_DEFENSE_LIFE, CANYON_DEFENSE_RANGE, CANYON_DEFENSE_ATTACKRATE);
    }

    @Override
    public Animation<TextureRegion> draw() {
        return null;
    }

    @Override
    public void attack(Token pAttackTargets) {

    }
}
