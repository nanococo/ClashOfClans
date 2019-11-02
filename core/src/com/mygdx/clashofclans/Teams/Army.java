package com.mygdx.clashofclans.Teams;

import com.mygdx.clashofclans.Mathematics;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Warrior;

import java.util.ArrayList;

public class Army {
    private int level;
    private int troopsAvailable;
    private ArrayList<Warrior> troops;
    private Defenses enemies;

    public Army(int level, int troopsAvailable, Defenses pEnemies) {
        this.level = level;
        this.troopsAvailable = troopsAvailable;
        troops = new ArrayList<Warrior>();
        enemies = pEnemies;
    }
    public void removeCasualties(){
        for (Warrior troop:troops){
            if (troop.getLife()<=0)troops.remove(troop);
        }
    }
    public Warrior returnAttackable(float pX, float pY, float pRange){
        for (Warrior troop:troops){
            if (Mathematics.distanceBetweenPoints(pX, pY, troop.getInitialX(), troop.getInitialY()) <= pRange) return troop;
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
    public boolean addTroop(Warrior newSoldier){

        boolean added = false;
        if (troopsAvailable-newSoldier.getConsumptionInArmy()>0){
            troops.add(newSoldier);
            troopsAvailable-=newSoldier.getConsumptionInArmy();
            added = true;
        }
        return added;

    }

}
