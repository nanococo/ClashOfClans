package com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarriors;

//public class Hero extends TerrestrialWarrior{
//
//    public Hero(float pInitialX, float pInitialY, String[] pAnimations) {
//        super(pInitialX, pInitialY, HERO_WARRIOR_LIFE, HERO_WARRIOR_RANGE, HERO_WARRIOR_LEVELAVAILABLE, HERO_WARRIOR_TROOPS_CONSUMED, HERO_WARRIOR_TROOPS_CONSUMED, HERO_WARRIOR_UPGRADERATE, pAnimations);

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;

public class Hero extends TerrestrialWarrior {

    public Hero(float pInitialX, float pInitialY, String[] pAnimations, TiledMapTileLayer collisionLayer, TiledMap map) {
        super(pInitialX, pInitialY, HERO_WARRIOR_LIFE, HERO_WARRIOR_RANGE, HERO_WARRIOR_LEVELAVAILABLE, HERO_WARRIOR_TROOPS_CONSUMED, HERO_WARRIOR_ATTACKRATE, pAnimations, collisionLayer, map);
    }
}

