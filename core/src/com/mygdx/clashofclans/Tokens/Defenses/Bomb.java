package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Token;

public class Bomb extends Defense {

    Animation<TextureRegion> bombAnimation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(BOMB_DEFENSE_ANIMATION).read());

    public Bomb(int pInitialX, int pInitialY) {
        super(pInitialX, pInitialY, BOMB_DEFENSE_LIFE, BOMB_DEFENSE_RANGE, BOMB_DEFENSE_ATTACKRATE);
    }

    @Override
    public Animation<TextureRegion> draw() {
        return bombAnimation;
    }

    @Override
    public void attack(Token pAttackTargets) {

    }
}
