package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Piece;

public class Tower extends Defense {

    private Animation<TextureRegion> towerAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(TOWER_DEFENSE_ANIMATION).read());


    public Tower(float pInitialX, float pInitialY) {
        super(pInitialX, pInitialY, TOWER_DEFENSE_LIFE, TOWER_DEFENSE_RANGE, TOWER_DEFENSE_ATTACKRATE);
    }

    @Override
    public Animation<TextureRegion> draw() {
        return towerAnimation;
    }


}
