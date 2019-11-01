package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Piece;

public class Canyon extends Defense {

    Animation<TextureRegion> canyonAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_ANIMATION_LEFT).read());


    public Canyon(float pInitialX, float pInitialY) {
        super(pInitialX, pInitialY, CANYON_DEFENSE_LIFE, CANYON_DEFENSE_RANGE, CANYON_DEFENSE_ATTACKRATE);
    }

    @Override
    public Animation<TextureRegion> draw() {
        return canyonAnimation;
    }

    @Override
    public void attack(Piece pAttackTargets) {

    }
}
