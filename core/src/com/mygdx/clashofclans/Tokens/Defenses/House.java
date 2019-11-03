package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;

public class House extends Defense {

    private static House mInstance;
    private Animation<TextureRegion> house = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(HOUSE).read());
    private Animation<TextureRegion> houseDestroyed = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(HOUSE_DESTROYED).read());

    private House() {

        super(0, 0, 20,0,0);
        setInitialX(Calculations.getBaseCenter(levelData.getMinBaseWidth()-(house.getKeyFrame(0).getRegionWidth()/2), levelData.getMaxBaseWidth()));
        setInitialY(Calculations.getBaseCenter(levelData.getMinBaseHeight()-(house.getKeyFrame(0).getRegionHeight()/2), levelData.getMaxBaseHeight()));
    }

    public static House getInstance() {
        if (mInstance == null) {
            mInstance = new House();
        }
        return mInstance;
    }

    public void setPosition(){
        setInitialX(Calculations.getBaseCenter(levelData.getMinBaseWidth()-(house.getKeyFrame(0).getRegionWidth()/2), levelData.getMaxBaseWidth()));
        setInitialY(Calculations.getBaseCenter(levelData.getMinBaseHeight()-(house.getKeyFrame(0).getRegionHeight()/2), levelData.getMaxBaseHeight()));
    }

    @Override
    public Animation<TextureRegion> draw() {
        if(!dead)
            return house;
        else{
            return houseDestroyed;
        }
    }

    @Override
    public void attack(){

    }
}
