package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Piece;
import com.mygdx.clashofclans.Tokens.Warriors.Aerial;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;

public class Canyon extends Defense {

    private boolean attackingN;
    private boolean attackingS;
    private boolean attackingE;
    private boolean attackingW;
    private boolean attackingNW;
    private boolean attackingNE;
    private boolean attackingSW;
    private boolean attackingSE;
    
    private Animation<TextureRegion> canyonAttackingAnimation_N = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_ANIMATION_NORTH).read());
    private Animation<TextureRegion> canyonStaticAnimation_N = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_STATICANIMATION_NORTH).read());
    private Animation<TextureRegion> canyonAttackingAnimation_S = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_ANIMATION_SOUTH).read());
    private Animation<TextureRegion> canyonStaticAnimation_S = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_STATICANIMATION_SOUTH).read());
    private Animation<TextureRegion> canyonAttackingAnimation_E = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_ANIMATION_EAST).read());
    private Animation<TextureRegion> canyonStaticAnimation_E = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_STATICANIMATION_EAST).read());
    private Animation<TextureRegion> canyonAttackingAnimation_W = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_ANIMATION_WEST).read());
    private Animation<TextureRegion> canyonStaticAnimation_W = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_STATICANIMATION_WEST).read());

    private Animation<TextureRegion> canyonAttackingAnimation_NW = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_ANIMATION_WEST).read());
    private Animation<TextureRegion> canyonStaticAnimation_NW = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_STATICANIMATION_WEST).read());
    private Animation<TextureRegion> canyonAttackingAnimation_NE = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_ANIMATION_WEST).read());
    private Animation<TextureRegion> canyonStaticAnimation_NE = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_STATICANIMATION_WEST).read());
    private Animation<TextureRegion> canyonAttackingAnimation_SW = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_ANIMATION_WEST).read());
    private Animation<TextureRegion> canyonStaticAnimation_SW = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_STATICANIMATION_WEST).read());
    private Animation<TextureRegion> canyonAttackingAnimation_SE = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_ANIMATION_WEST).read());
    private Animation<TextureRegion> canyonStaticAnimation_SE = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(CANYON_DEFENSE_STATICANIMATION_WEST).read());


    public Canyon(float pInitialX, float pInitialY) {
        super(pInitialX, pInitialY, CANYON_DEFENSE_LIFE, CANYON_DEFENSE_RANGE, CANYON_DEFENSE_ATTACKRATE);
         attackingN = false;
         attackingS = false;
         attackingE = false;
         attackingW = false;
         attackingNW = false;
         attackingNE = false;
         attackingSW = false;
         attackingSE = false;
    }
    
    
    
    @Override
    public Animation<TextureRegion> draw() {
        setTargetLocation();
        if (attackingN){
            if(targetLocked){
                return canyonAttackingAnimation_N;
            } else return canyonStaticAnimation_N;
        }
        if (attackingS){
            if(targetLocked){
                return canyonAttackingAnimation_S;
            } else return canyonStaticAnimation_S;
        }
        if (attackingE){
            if(targetLocked){
                return canyonAttackingAnimation_E;
            } else return canyonStaticAnimation_E;
        }
        if (attackingW){
            if(targetLocked){
                return canyonAttackingAnimation_W;
            } else return canyonStaticAnimation_W;
        }
        if (attackingNW){
            if(targetLocked){
                return canyonAttackingAnimation_NW;
            } else return canyonStaticAnimation_NW;
        }
        if (attackingNE){
            if(targetLocked){
                return canyonAttackingAnimation_NE;
            } else return canyonStaticAnimation_NE;
        }
        if (attackingSW){
            if(targetLocked){
                return canyonAttackingAnimation_SW;
            } else return canyonStaticAnimation_SW;
        }
        if (attackingSE){
            if(targetLocked){
                return canyonAttackingAnimation_SE;
            } else return canyonStaticAnimation_SE;
        }
        return canyonStaticAnimation_E;
    }

    private void setTargetLocation(){

        if(targetLocked){
            if(initialX!=target.getInitialX()){
                float pendient = Calculations.distanceBetweenPoints(initialX, initialY, target.getInitialX(), target.getInitialY());
                if (pendient>0){
                    if (target.getInitialY()>initialY){
                        setAttackingNE();
                    } else{
                        setAttackingSW();
                    }
                } else if (target.getInitialY()<initialY){

                    if (target.getInitialY()>initialY){
                        setAttackingSE();
                    } else{
                        setAttackingNW();
                    }
                } else{
                    if (target.getInitialX()>initialX){
                        setAttackingE();
                    } else{
                        setAttackingW();
                    }
                }
            } else{
                if (target.getInitialY()>initialY){
                    setAttackingN();
                }else setAttackingS();
            }
        }

    }
    @Override
    public void setTarget(Piece target) {
        if (target instanceof TerrestrialWarrior){
            this.target = target;
            targetX = target.getInitialX();
            targetY = target.getInitialY();
            targetLocked = true;
        }

    }

    private void setAttackingN() {
        attackingN = true;
        attackingS = false;
        attackingE = false;
        attackingW = false;
        attackingNW = false;
        attackingNE = false;
        attackingSW = false;
        attackingSE = false;

    }
    private void setAttackingS() {
        attackingN = false;
        attackingS = true;
        attackingE = false;
        attackingW = false;
        attackingNW = false;
        attackingNE = false;
        attackingSW = false;
        attackingSE = false;

    }
    private void setAttackingE() {
        attackingN = false;
        attackingS = false;
        attackingE = true;
        attackingW = false;
        attackingNW = false;
        attackingNE = false;
        attackingSW = false;
        attackingSE = false;

    }
    private void setAttackingW() {
        attackingN = false;
        attackingS = false;
        attackingE = false;
        attackingW = true;
        attackingNW = false;
        attackingNE = false;
        attackingSW = false;
        attackingSE = false;

    }
    private void setAttackingNW() {
        attackingN = false;
        attackingS = false;
        attackingE = false;
        attackingW = true;
        attackingNE = false;
        attackingSW = false;
        attackingSE = false;

    }
    private void setAttackingNE() {
        attackingN = false;
        attackingS = false;
        attackingE = false;
        attackingW = false;
        attackingNW = false;
        attackingNE = true;
        attackingSW = false;
        attackingSE = false;

    }
    private void setAttackingSW() {
        attackingN = false;
        attackingS = false;
        attackingE = false;
        attackingW = false;
        attackingNW = false;
        attackingNE = false;
        attackingSW = true;
        attackingSE = false;

    }
    private void setAttackingSE() {
        attackingN = false;
        attackingS = false;
        attackingE = false;
        attackingW = false;
        attackingNW = false;
        attackingNE = false;
        attackingSW = false;
        attackingSE = true;

    }
}
