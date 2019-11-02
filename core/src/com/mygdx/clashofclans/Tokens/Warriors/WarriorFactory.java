package com.mygdx.clashofclans.Tokens.Warriors;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.Tokens.Warriors.Characters.*;

public class WarriorFactory {
    public static Warrior getWarrior(int selectedWarrior, int x, int y, TiledMapTileLayer collisionLayer, TiledMap map){
        switch (selectedWarrior){
            case 0:
                return new Deuce(x, y, collisionLayer, map);
            case 1:
                return new Yolanda(x, y, collisionLayer, map);
            case 2:
                return new Hector(x, y, collisionLayer, map);
            case 3:
                return new Bichillos(x, y);
            case 4:
                return new Ringo(x, y, collisionLayer, map);
            default:
                return null;
        }
    }
}
