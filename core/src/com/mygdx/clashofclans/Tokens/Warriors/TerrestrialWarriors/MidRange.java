package com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarriors;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.Tokens.Piece;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;

public class MidRange extends TerrestrialWarrior {
    private float levelBonus;
    public MidRange(float pInitialX, float pInitialY, String[] pAnimations, TiledMapTileLayer mapTileLayer, TiledMap map) {
        super(pInitialX, pInitialY, MIDRANGE_WARRIOR_LIFE, MIDRANGE_WARRIOR_RANGE, MIDRANGE_WARRIOR_LEVELAVAILABLE, MIDRANGE_WARRIOR_TROOPS_CONSUMED, MIDRANGE_WARRIOR_ATTACKRATE, pAnimations, mapTileLayer,map);
        levelBonus = Calculations.levelBonus(levelAvailable, level, (float)upgradeRate);
        addBonusLevel();
    }
    private void addBonusLevel(){
        life+=levelBonus;
        attackRate+=levelBonus;
    }

}
