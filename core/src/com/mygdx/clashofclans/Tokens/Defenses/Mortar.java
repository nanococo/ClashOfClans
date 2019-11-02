package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Piece;

public class Mortar extends Defense {

    public Mortar(float pInitialX, float pInitialY) {
        super(pInitialX, pInitialY, MORTAR_DEFENSE_LIFE, MORTAR_DEFENSE_RANGE, MORTAR_DEFENSE_ATTACKRATE);
    }

    @Override
    public Animation<TextureRegion> draw() {
        return null;
    }

    @Override
    public void attack() {

    }
}
