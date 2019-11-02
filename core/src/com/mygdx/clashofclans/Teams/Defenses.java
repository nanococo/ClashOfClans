package com.mygdx.clashofclans.Teams;

import com.mygdx.clashofclans.Mathematics;
import com.mygdx.clashofclans.Tokens.Defense;
import com.mygdx.clashofclans.Tokens.Defenses.Bomb;
import com.mygdx.clashofclans.Tokens.Defenses.DefenseFactory;
import com.mygdx.clashofclans.Tokens.Warrior;
import com.mygdx.clashofclans.Tokens.Warriors.TerrestrialWarrior;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Defenses {
    private int level;
    private int troopsAvailable;
    private ArrayList<Defense> defenses;
    private Army enemies;

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

    public void setEnemies(Army enemies) {
        this.enemies = enemies;
    }
}


