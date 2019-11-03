package com.mygdx.clashofclans.saveFileHelper;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Teams.Army;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.levelManager.LevelData;
import com.mygdx.clashofclans.levelManager.Levels;

import java.util.ArrayList;
import java.util.List;

public final class GameDataHolder {
    public Levels level_SAVED = null;
    public String mapPath_SAVED = "";
    public Defenses defenses;





    private static class Defenses{
        public Levels level;
        public int troopsAvailable;
        public ArrayList<Defense> defenses;
        public Army enemies;
        public TiledMapTileLayer collisionLayer;
        public LevelData levelData;

        public Defenses(Levels level, int troopsAvailable, ArrayList<Defense> defenses, Army enemies, TiledMapTileLayer collisionLayer, LevelData levelData) {
            this.level = level;
            this.troopsAvailable = troopsAvailable;
            this.defenses = defenses;
            this.enemies = enemies;
            this.collisionLayer = collisionLayer;
            this.levelData = levelData;
        }

        static class Defense{

        }
    }

//    public Defenses defenses_SAVED = null;
//    public ArrayList<Defense> defensesArray_SAVED = null;
//    public Army army_SAVED = null;
//    public ArrayList<Warrior> troops_SAVED = null;

    public GameDataHolder(String mapPath){
        this.mapPath_SAVED = mapPath;
    }
}
