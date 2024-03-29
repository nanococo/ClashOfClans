package com.mygdx.clashofclans.Tokens.Warriors.Characters;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarriors.Contact;

public class Deuce extends Contact {

    private static String PATH_TO_IDLE_ANIMATION = "Deuce/Deuce (Idle).gif";
    private static String PATH_TO_WALKING_ANIMATION = "Deuce/Deuce (Walking).gif";
    private static String PATH_TO_ATTACK_ANIMATION = "Deuce/Deuce (Attack).gif";
    private static String PATH_TO_HURT_ANIMATION = "Deuce/Deuce (Hurt).gif";
    private static String PATH_TO_IDLE_ANIMATION_L = "Deuce/Deuce L(Idle).gif";
    private static String PATH_TO_WALKING_ANIMATION_L = "Deuce/Deuce L(Walking).gif";
    private static String PATH_TO_ATTACK_ANIMATION_L = "Deuce/Deuce L(Attack).gif";
    private static String PATH_TO_HURT_ANIMATION_L = "Deuce/Deuce L(Hurt).gif";

    public Deuce(float pInitialX, float pInitialY, TiledMapTileLayer mapTileLayer, TiledMap map) {
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
