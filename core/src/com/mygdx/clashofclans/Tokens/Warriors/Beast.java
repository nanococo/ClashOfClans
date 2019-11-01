package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Tokens.Piece;

public class Beast extends TerrestrialWarrior {

    public Beast(float pInitialX, float pInitialY, String[] pAnimations, TiledMapTileLayer mapTileLayer, TiledMap map) {
        super(pInitialX, pInitialY, BEAST_WARRIOR_LIFE, BEAST_WARRIOR_RANGE, BEAST_WARRIOR_LEVELAVAILABLE, BEAST_WARRIOR_TROOPS_CONSUMED, BEAST_WARRIOR_TROOPS_CONSUMED, BEAST_WARRIOR_UPGRADERATE, pAnimations, mapTileLayer, map);
    }

    @Override
    public void attack(Piece pAttackTargets) {

    }
}
