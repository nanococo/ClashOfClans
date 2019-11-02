package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Piece;

public class AerialDefense extends Defense {

    private Animation<TextureRegion> aerialAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(AERIAL_DEFENSE_ANIMATION).read());


    AerialDefense(int pInitialX, int pInitialY) {
        super(pInitialX, pInitialY, AERIAL_DEFENSE_LIFE, AERIAL_DEFENSE_RANGE, AERIAL_DEFENSE_ATTACKRATE);
    }

    @Override
    public Animation<TextureRegion> draw() {
        return aerialAnimation;
    }

}
