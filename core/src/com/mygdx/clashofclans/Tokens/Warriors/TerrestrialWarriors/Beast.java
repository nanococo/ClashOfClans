package com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarriors;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Tokens.Piece;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;

public class Beast extends TerrestrialWarrior {

    public Beast(float pInitialX, float pInitialY, String[] pAnimations, TiledMapTileLayer mapTileLayer, TiledMap map) {
        super(pInitialX, pInitialY, BEAST_WARRIOR_LIFE, BEAST_WARRIOR_RANGE, BEAST_WARRIOR_LEVELAVAILABLE, BEAST_WARRIOR_TROOPS_CONSUMED, BEAST_WARRIOR_ATTACKRATE, pAnimations, mapTileLayer, map);
    }

}
