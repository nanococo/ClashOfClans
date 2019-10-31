package com.mygdx.clashofclans.Tokens.Warriors.Characters;

import com.mygdx.clashofclans.Tokens.Warriors.MidRange;

public class Yolanda extends MidRange {

    private static String PATH_TO_IDLE_ANIMATION = "Hector/Hector (Idle).gif";
    private static String PATH_TO_WALKING_ANIMATION = "Hector/Hector (Walking).gif";
    private static String PATH_TO_ATTACK_ANIMATION = "Hector/Hector (Attack).gif";
    private static String PATH_TO_HURT_ANIMATION = "Hector/Hector (Hurt).gif";

    public Yolanda(int pInitialX, int pInitialY) {
        super(pInitialX, pInitialY, new String[]{PATH_TO_IDLE_ANIMATION, PATH_TO_WALKING_ANIMATION, PATH_TO_ATTACK_ANIMATION, PATH_TO_HURT_ANIMATION});
    }
}
