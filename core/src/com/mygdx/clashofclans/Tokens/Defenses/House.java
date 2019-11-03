package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;

public class House extends Defense {

    private Animation<TextureRegion> house = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(HOUSE).read());

    public House() {
        super(0, 0, 0,0,0);
    }

    @Override
    public Animation<TextureRegion> draw() {
        return house;
    }

    public Animation<TextureRegion> getHouse() {
        return house;
    }
}
