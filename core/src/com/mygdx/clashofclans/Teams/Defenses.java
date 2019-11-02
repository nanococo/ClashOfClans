package com.mygdx.clashofclans.Teams;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Defenses.Bomb;
import com.mygdx.clashofclans.Tokens.Defenses.DefenseFactory;

import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.mygdx.clashofclans.levelManager.LevelData;

import java.util.ArrayList;
import java.util.Iterator;

public class Defenses {
    private int level;
    private int troopsAvailable;
    private ArrayList<Defense> defenses;

    private Army enemies;

    private TiledMapTileLayer collisionLayer;
    private LevelData levelData;

    public Defenses(int level, int troopsAvailable, TiledMapTileLayer collisionLayer, LevelData levelData) {
        this.level = level;
        this.troopsAvailable = troopsAvailable;
        defenses = new ArrayList<>();
        this.collisionLayer = collisionLayer;
        this.levelData = levelData;
    }
    public void removeCasualties(){
        for (Iterator<Defense> iterator = defenses.iterator(); iterator.hasNext();) {
            Defense defense = iterator.next();
            if (defense.getLife()==0) {
                iterator.remove();
            }
        }
    }

    Defense returnAttackable(float pX, float pY, float pRange){
        for (Defense defense: defenses){
            if (Calculations.distanceBetweenPoints(pX, pY, defense.getInitialX(), defense.getInitialY()) <= pRange) {
                System.out.println(Calculations.distanceBetweenPoints(pX, pY, defense.getInitialX(), defense.getInitialY()));
                return defense;
            }
        }
        return null;
    }


    public void searchAndSetTargets(){
        for (Defense defense:defenses){
            Warrior possibleTarget = enemies.returnAttackable(defense.getInitialX(), defense.getInitialY(), defense.getAttackRange());
            if (possibleTarget!=null){
                defense.setTarget(possibleTarget);
            }
            if (defense instanceof Bomb){
              ((Bomb) defense).setEnemies(enemies);
            }
        }
    }



    /**
     * Method adds specific defense
     * @param newDefense is the specific defense to add
     */

    public void addDefense(Defense newDefense){
        defenses.add(newDefense);
    }


    /**
     * Method creates defense on random position
     * @param specificDefense is int selector for DefenseFactory
     */
    public void addDefense(int specificDefense){
        int spawnX = Calculations.generateRandomIntIntRange(levelData.getMinBaseWidth(), levelData.getMaxBaseWidth());
        int spawnY = Calculations.generateRandomIntIntRange(levelData.getMinBaseHeight(), levelData.getMaxBaseHeight());

        if (Calculations.collidesLeft(spawnX, spawnY, collisionLayer) || Calculations.collidesRight(spawnX, spawnY, collisionLayer)
        || Calculations.collidesTop(spawnX, spawnY, collisionLayer) || Calculations.collidesBottom(spawnX, spawnY, collisionLayer)){
            addDefense(specificDefense);
        } else {
            defenses.add(DefenseFactory.getDefense(specificDefense, spawnX, spawnY));
        }
    }

    public ArrayList<Defense> getDefenses() {
        return defenses;
    }

    public void setEnemies(Army enemies) {
        this.enemies = enemies;
    }
}


