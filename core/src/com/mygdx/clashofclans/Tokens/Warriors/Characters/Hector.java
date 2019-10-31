package com.mygdx.clashofclans.Tokens.Warriors.Characters;

import com.mygdx.clashofclans.Tokens.Warriors.Hero;

public class Hector extends Hero {

    private static String PATH_TO_IDLE_ANIMATION = "Hector/Hector (Idle).gif";
    private static String PATH_TO_WALKING_ANIMATION = "Hector/Hector (Walking).gif";
    private static String PATH_TO_ATTACK_ANIMATION = "Hector/Hector (Attack).gif";
    private static String PATH_TO_HURT_ANIMATION = "Hector/Hector (Hurt).gif";
    private static String PATH_TO_IDLE_ANIMATION_L = "Hector/Hector L(Idle).gif";
    private static String PATH_TO_WALKING_ANIMATION_L = "Hector/Hector L(Walking).gif";
    private static String PATH_TO_ATTACK_ANIMATION_L = "Hector/Hector L(Attack).gif";
    private static String PATH_TO_HURT_ANIMATION_L = "Hector/Hector L(Hurt).gif";

    public Hector(int pInitialX, int pInitialY) {
        super(pInitialX, pInitialY, new String[]{PATH_TO_IDLE_ANIMATION,
                                                PATH_TO_WALKING_ANIMATION,
                                                PATH_TO_ATTACK_ANIMATION,
                                                PATH_TO_HURT_ANIMATION,
                                                PATH_TO_IDLE_ANIMATION_L,
                                                PATH_TO_WALKING_ANIMATION_L,
                                                PATH_TO_ATTACK_ANIMATION_L,
                                                PATH_TO_HURT_ANIMATION_L});
    }


}
