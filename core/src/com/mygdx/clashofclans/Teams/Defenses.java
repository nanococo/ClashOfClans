package com.mygdx.clashofclans.Teams;

import com.mygdx.clashofclans.Mathematics;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Defenses.DefenseFactory;

import java.util.ArrayList;
import java.util.Random;

public class Defenses {
    private int level;
    private int troopsAvailable;
    private ArrayList<Defense> defenses;

    public Defenses(int level, int troopsAvailable) {
        this.level = level;
        this.troopsAvailable = troopsAvailable;
        defenses = new ArrayList<>();
    }
    public void removeCasualties(){
        for (Defense defense: defenses){
            if (defense.getLife()<=0) defenses.remove(defense);
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

    public void addDefense(int specificDefense){
        int spawnX = generateRandomIntIntRange(660, 1250);
        int spawnY = generateRandomIntIntRange(350, 900);

        defenses.add(DefenseFactory.getDefense(specificDefense, spawnX, spawnY));
    }

    public ArrayList<Defense> getDefenses() {
        return defenses;
    }
}
