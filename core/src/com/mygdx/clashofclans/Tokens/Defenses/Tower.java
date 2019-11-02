package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Piece;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;

public class Tower extends Defense {

    public Tower(float pInitialX, float pInitialY) {
        super(pInitialX, pInitialY, TOWER_DEFENSE_LIFE, TOWER_DEFENSE_RANGE, TOWER_DEFENSE_ATTACKRATE);
    }

    @Override
    public Animation<TextureRegion> draw() {
        return null;
    }

}
