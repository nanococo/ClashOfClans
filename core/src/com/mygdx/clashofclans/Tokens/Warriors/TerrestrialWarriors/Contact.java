package com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarriors;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.Tokens.Interfaces.MakesSound;
import com.mygdx.clashofclans.Tokens.Piece;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;

public class Contact extends TerrestrialWarrior implements MakesSound {

    private float levelBonus;
    public Contact(float pInitialX, float pInitialY, String[] pAnimations, TiledMapTileLayer mapTileLayer, TiledMap map) {
        super(pInitialX, pInitialY, CONTACT_WARRIOR_LIFE, CONTACT_WARRIOR_RANGE, CONTACT_WARRIOR_LEVELAVAILABLE, CONTACT_WARRIOR_TROOPS_CONSUMED, CONTACT_WARRIOR_ATTACKRATE, pAnimations, mapTileLayer, map);
        levelBonus = Calculations.levelBonus(levelAvailable, level, (float)upgradeRate);
        addBonusLevel();
    }
    private void addBonusLevel(){
        life+=levelBonus;
        attackRate+=levelBonus;
    }
}
