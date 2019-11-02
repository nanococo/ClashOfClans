package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;

public class Mortar extends Defense {

    private Animation<TextureRegion> mortarAttackingAnimation_R = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(MORTAR_DEFENSE_ANIMATION_LEFT).read());


    public Mortar(float pInitialX, float pInitialY) {
        super(pInitialX, pInitialY, MORTAR_DEFENSE_LIFE, MORTAR_DEFENSE_RANGE, MORTAR_DEFENSE_ATTACKRATE);
    }

    @Override
    public Animation<TextureRegion> draw() {
        return mortarAttackingAnimation_R;
    }

}
