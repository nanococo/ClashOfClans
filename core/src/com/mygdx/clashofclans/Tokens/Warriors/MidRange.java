package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Tokens.Piece;

public class MidRange extends TerrestrialWarrior {
    public MidRange(float pInitialX, float pInitialY, String[] pAnimations, TiledMapTileLayer mapTileLayer, TiledMap map) {
        super(pInitialX, pInitialY, MIDRANGE_WARRIOR_LIFE, MIDRANGE_WARRIOR_RANGE, MIDRANGE_WARRIOR_LEVELAVAILABLE, MIDRANGE_WARRIOR_TROOPS_CONSUMED, MIDRANGE_WARRIOR_ATTACKRATE, MIDRANGE_WARRIOR_UPGRADERATE, pAnimations, mapTileLayer,map);
    }
}
