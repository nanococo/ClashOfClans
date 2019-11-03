package com.mygdx.clashofclans.Tokens.Defenses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.clashofclans.GifDecoder;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Interfaces.MakesSound;
import com.mygdx.clashofclans.Tokens.Piece;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;

public class Mortar extends Defense implements MakesSound {

    private Animation<TextureRegion> mortarAttackingAnimation_R = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(MORTAR_DEFENSE_ANIMATION_RIGHT).read());
    private Animation<TextureRegion> mortarAttackingAnimation_L = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(MORTAR_DEFENSE_ANIMATION_LEFT).read());
    private Animation<TextureRegion> mortarStaticAnimation_R = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(MORTAR_DEFENSE_STATICANIMATION_RIGHT).read());
    private Animation<TextureRegion> mortarStaticAnimation_L = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(MORTAR_DEFENSE_STATICANIMATION_LEFT).read());

    private boolean attackingRight;

    private Sound mortarSound;


    public Mortar(float pInitialX, float pInitialY) {
        super(pInitialX, pInitialY, MORTAR_DEFENSE_LIFE, MORTAR_DEFENSE_RANGE, MORTAR_DEFENSE_ATTACKRATE);
        attackingRight = false;
        mortarSound = Gdx.audio.newSound(Gdx.files.internal("SoundEffects/Canyon/shotgun-old_school-RA_The_Sun_God-1129942741.mp3"));

    }

    @Override
    public Animation<TextureRegion> draw() {
        setTargetLocation();
        if (attackingRight){
            if(targetLocked){
                playSound();
                return mortarAttackingAnimation_R;
            }else{
                return mortarStaticAnimation_R;
            }
        }else{
            if(targetLocked){
                playSound();
                return mortarAttackingAnimation_L;
            }else{
                return mortarStaticAnimation_L;
            }
        }
    }

    @Override
    public void setTarget(Piece target) {
        if (target instanceof TerrestrialWarrior){
            this.target = target;

            targetLocked = true;
        }

    }


    private void setTargetLocation() {
        if(targetLocked)
        attackingRight = target.getInitialX() > initialX;
    }
    @Override
    public void playSound() {
        if (!timer) {
            start = System.currentTimeMillis();
            timer = true;
        }
        finish = System.currentTimeMillis();
        if (finish - start >= 2000) {
            mortarSound.play(0.4f);
            timer = false;
        }
    }

}
