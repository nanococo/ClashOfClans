package com.mygdx.clashofclans.Tokens.Warriors.Characters;

import com.mygdx.clashofclans.Tokens.Warriors.Aerial;

public class Bichillos extends Aerial {

    private static String PATH_TO_IDLE_ANIMATION = "Bichillos/Bichillos (Idle).gif";
    private static String PATH_TO_ATTACK_ANIMATION = "Bichillos/Bichillos (Attack).gif";
    private static String PATH_TO_HURT_ANIMATION = "Bichillos/Bichillos (Hurt).gif";

    public Bichillos(int pInitialX, int pInitialY) {
        super(pInitialX, pInitialY, new String[]{PATH_TO_IDLE_ANIMATION, PATH_TO_ATTACK_ANIMATION, PATH_TO_HURT_ANIMATION});
    }
}
