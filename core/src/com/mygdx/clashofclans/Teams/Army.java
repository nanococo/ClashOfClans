package com.mygdx.clashofclans.Teams;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.clashofclans.Calculations;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.Tokens.Warriors.WarriorFactory;
import com.mygdx.clashofclans.levelManager.Levels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Army implements Serializable {
    private Levels level;
    private int troopsAvailable;
    private ArrayList<Warrior> troops;
    private Defenses enemies;

    public Army(Levels level, int troopsAvailable, Defenses pEnemies) {
        this.level = level;
        this.troopsAvailable = troopsAvailable;
        troops = new ArrayList<Warrior>();
        enemies = pEnemies;
    }
    public void removeCasualties(){
        for (Iterator<Warrior> iterator = troops.iterator(); iterator.hasNext();) {
            Warrior troop = iterator.next();
            if (troop.getLife()<=0) {
                iterator.remove();
                System.out.println("rip");
            }
        }
    }
    public Warrior returnAttackable(float pX, float pY, float pRange){
        for (Warrior troop:troops){
            if (Calculations.distanceBetweenPoints(pX, pY, troop.getInitialX(), troop.getInitialY()) <= pRange) return troop;
        }
        return null;
    }
    public void searchAndSetTargets(){
        for (Warrior troop:troops){
            Defense possibleTarget = enemies.returnAttackable(troop.getInitialX(), troop.getInitialY(), troop.getAttackRange());
            if (possibleTarget!=null){
                troop.setTarget(possibleTarget);
            }
        }
    }

    public ArrayList<Warrior> getTroops() {
        return troops;
    }

    public void setTroops(ArrayList<Warrior> troops) {
        this.troops = troops;
    }

    public int getTroopsAvailable() {
        return troopsAvailable;
    }

    public void setTroopsAvailable(int troopsAvailable) {
        this.troopsAvailable = troopsAvailable;
    }

    public boolean addTroop(Warrior newSoldier){
        boolean added = false;
        if (troopsAvailable-newSoldier.getConsumptionInArmy()>0){
            troops.add(newSoldier);
            troopsAvailable-=newSoldier.getConsumptionInArmy();
            added = true;
        }
        return added;
    }

    public boolean addTroop(int specificTroop, int x, int y, TiledMapTileLayer collisionLayer, TiledMap map){
        boolean added = false;
        Warrior newSoldier = WarriorFactory.getWarrior(specificTroop, x, y, collisionLayer, map);

        if(newSoldier!=null){
            System.out.println("Level: "+newSoldier.getLevel());
            if (troopsAvailable-newSoldier.getConsumptionInArmy()>0){
                troops.add(newSoldier);
                troopsAvailable-=newSoldier.getConsumptionInArmy();
                added = true;
            }
        }
        return added;
    }

}
