package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;

public class Tower extends Defense {

    private Animation<TextureRegion> towerAttackingAnimation_L = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(TOWER_DEFENSE_ANIMATION_LEFT).read());
    private Animation<TextureRegion> towerAttackingAnimation_R = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(TOWER_DEFENSE_ANIMATION_RIGHT).read());
    private Animation<TextureRegion> towerStaticAnimation_R = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(TOWER_DEFENSE_STATICANIMATION_RIGHT).read());
    private Animation<TextureRegion> towerStaticAnimation_L = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(TOWER_DEFENSE_STATICANIMATION_RIGHT).read());

    private boolean attackingRight;


    public Tower(float pInitialX, float pInitialY) {
        super(pInitialX, pInitialY, TOWER_DEFENSE_LIFE, TOWER_DEFENSE_RANGE, TOWER_DEFENSE_ATTACKRATE);
        attackingRight = true;
    }


    @Override
    public Animation<TextureRegion> draw() {
        setTargetLocation();
        if (attackingRight){
           if(targetLocked){
               return towerAttackingAnimation_R;
           }else{
               return towerStaticAnimation_R;
           }
        }else{
            if(targetLocked){
                return towerAttackingAnimation_L;
            }else{
                return towerStaticAnimation_L;
            }
        }
    }

    private void setTargetLocation() {
        if(targetLocked)
            attackingRight = target.getInitialX() > initialX;
    }

}
