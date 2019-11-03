package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.*;

public class WarriorFactory {
    private static Warrior warrior = null;
    public static Warrior getWarrior(int selectedWarrior, int x, int y, TiledMapTileLayer collisionLayer, TiledMap map){
        switch (selectedWarrior){
            case 0:
                warrior = new Deuce(x, y, collisionLayer, map);
                warrior.setWarriorType(selectedWarrior);
                return warrior;
            case 1:
                warrior.setWarriorType(selectedWarrior);
                warrior = new Yolanda(x, y, collisionLayer, map);
                return warrior;
            case 2:
                warrior.setWarriorType(selectedWarrior);
                warrior = new Hector(x, y, collisionLayer, map);
                return warrior;
            case 3:
                warrior.setWarriorType(selectedWarrior);
                warrior = new Bichillos(x, y);
                return warrior;
            case 4:
                warrior.setWarriorType(selectedWarrior);
                warrior = new Ringo(x, y, collisionLayer, map);
                return warrior;
            default:
                return null;
        }
    }
}
