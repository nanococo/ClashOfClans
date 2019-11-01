package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Tokens.Piece;

public class Contact extends TerrestrialWarrior{


    public Contact(float pInitialX, float pInitialY, String[] pAnimations, TiledMapTileLayer mapTileLayer, TiledMap map) {
        super(pInitialX, pInitialY, CONTACT_WARRIOR_LIFE, CONTACT_WARRIOR_RANGE, CONTACT_WARRIOR_LEVELAVAILABLE, CONTACT_WARRIOR_TROOPS_CONSUMED, CONTACT_WARRIOR_TROOPS_CONSUMED, CONTACT_WARRIOR_UPGRADERATE, pAnimations, mapTileLayer, map);
    }

    @Override
    public void attack(Piece pAttackTargets) {

    }
}
