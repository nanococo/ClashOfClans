package com.mygdx.clashofclans.Tokens.Warriors.Characters;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Tokens.Warriors.Beast;

public class Ringo extends Beast {

    private static String PATH_TO_IDLE_ANIMATION = "Ringo/Ringo (Idle).gif";
    private static String PATH_TO_WALKING_ANIMATION = "Ringo/Ringo (Walking).gif";
    private static String PATH_TO_ATTACK_ANIMATION = "Ringo/Ringo (Attack).gif";
    private static String PATH_TO_HURT_ANIMATION = "Ringo/Ringo (Hurt).gif";
    private static String PATH_TO_IDLE_ANIMATION_L = "Ringo/Ringo L(Idle).gif";
    private static String PATH_TO_WALKING_ANIMATION_L = "Ringo/Ringo L(Walking).gif";
    private static String PATH_TO_ATTACK_ANIMATION_L = "Ringo/Ringo L(Attack).gif";
    private static String PATH_TO_HURT_ANIMATION_L = "Ringo/Ringo L(Hurt).gif";

    public Ringo(float pInitialX, float pInitialY, TiledMapTileLayer mapTileLayer, TiledMap map) {
        super(pInitialX, pInitialY, new String[]{PATH_TO_IDLE_ANIMATION,
                PATH_TO_WALKING_ANIMATION,
                PATH_TO_ATTACK_ANIMATION,
                PATH_TO_HURT_ANIMATION,
                PATH_TO_IDLE_ANIMATION_L,
                PATH_TO_WALKING_ANIMATION_L,
                PATH_TO_ATTACK_ANIMATION_L,
                PATH_TO_HURT_ANIMATION_L}, mapTileLayer, map);
    }

}
