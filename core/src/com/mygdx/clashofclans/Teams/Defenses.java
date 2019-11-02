package com.mygdx.clashofclans.Teams;

import com.mygdx.clashofclans.Mathematics;
import com.mygdx.clashofclans.Tokens.Defense;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static com.mygdx.clashofclans.Teams.Defenses.generateRandomIntIntRange;

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
        for (Iterator<Defense> iterator = defenses.iterator(); iterator.hasNext();) {
            Defense defense = iterator.next();
            if (defense.getLife()==0) {
                iterator.remove();
            }
        }
    }

    Defense returnAttackable(float pX, float pY, float pRange){
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

    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void addDefense(){
        int spawnX = generateRandomIntIntRange(660, 1250);
        int spawnY = generateRandomIntIntRange(350, 900);


    }

    public ArrayList<Defense> getDefenses() {
        return defenses;
    }
}
