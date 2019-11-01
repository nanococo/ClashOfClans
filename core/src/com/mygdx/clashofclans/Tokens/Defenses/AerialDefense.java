package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Token;

public class AerialDefense extends Defense {

    public AerialDefense(int pInitialX, int pInitialY) {
        super(pInitialX, pInitialY, AERIAL_DEFENSE_LIFE, AERIAL_DEFENSE_RANGE, AERIAL_DEFENSE_ATTACKRATE);
    }

    @Override
    public Animation<TextureRegion> draw() {
        return null;
    }

    @Override
    public void attack(Token pAttackTargets) {

    }
}
