package com.mygdx.clashofclans.Teams;

import com.mygdx.clashofclans.Mathematics;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Warrior;

import java.util.ArrayList;

public class Defenses {
    private int level;
    private int troopsAvailable;
    private ArrayList<Defense> defenses;

    public Defenses(int level, int troopsAvailable) {
        this.level = level;
        this.troopsAvailable = troopsAvailable;
        defenses = new ArrayList<Defense>();
    }
    public void removeCasualties(){
        for (Defense defense: defenses){
            if (defense.getLife()<=0) defenses.remove(defense);

        }
    }
    public Defense returnAttackable(float pX, float pY, float pRange){
        for (Defense defense: defenses){
            if (Mathematics.distanceBetweenPoints(pX, pY, defense.getInitialX(), defense.getInitialY()) <= pRange) {
                System.out.println(Mathematics.distanceBetweenPoints(pX, pY, defense.getInitialX(), defense.getInitialY()));
                return defense;
            }
        }
        return null;
    }
    public void addDefense(Defense newDefense){
        defenses.add(newDefense);
    }

    public ArrayList<Defense> getDefenses() {
        return defenses;
    }
}
