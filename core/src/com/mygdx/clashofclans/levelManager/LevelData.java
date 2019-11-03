package com.mygdx.clashofclans.levelManager;

import java.io.Serializable;

/**
 * Singleton class for level Data
 * @author sebas
 */
public class LevelData implements Serializable {
    private static LevelData levelData = null;

    private int minBaseWidth;
    private int minBaseHeight;
    private int maxBaseWidth;
    private int maxBaseHeight;
    private int cannonCount;
    private int ballistaCount;
    private int bombCount;
    private int towerCount;
    private int mortarCount;
    private int armySize;
    private int defenseCount;
    private int actualLevel;

    private LevelData(){
        this.minBaseWidth = 0;
        this.minBaseHeight = 0;
        this.maxBaseWidth = 0;
        this.minBaseHeight = 0;
        this.cannonCount = 0;
        this.ballistaCount = 0;
        this.bombCount = 0;
        this.towerCount = 0;
        this.mortarCount = 0;
        this.armySize = 0;
    }

    public static LevelData getInstance(){
        if (levelData == null)
            levelData = new LevelData();

        return levelData;
    }

    public int getMinBaseWidth() {
        return minBaseWidth;
    }
    public int getMinBaseHeight() {
        return minBaseHeight;
    }
    public int getMaxBaseWidth() {
        return maxBaseWidth;
    }
    public int getMaxBaseHeight() {
        return maxBaseHeight;
    }
    public int getCannonCount() {
        return cannonCount;
    }
    public int getBallistaCount() {
        return ballistaCount;
    }
    public int getBombCount() {
        return bombCount;
    }
    public int getTowerCount() {
        return towerCount;
    }
    public int getMortarCount() {
        return mortarCount;
    }
    public int getArmySize() {
        return armySize;
    }
    public int getDefenseCount() {
        return defenseCount;
    }
    public int getActualLevel(){
        return actualLevel;
    }

    public void setLevel(Levels level){
        switch (level){
            case LEVEL1:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 50;
                cannonCount = 2;
                bombCount = 0;
                towerCount = 0;
                ballistaCount = 0;
                mortarCount = 0;
                armySize = 50;
                actualLevel = 1;
                break;
            case LEVEL2:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 6;
                cannonCount = 2;
                bombCount = 2;
                towerCount = 0;
                ballistaCount = 2;
                mortarCount = 0;
                armySize = 10;
                actualLevel = 2;

                break;
            case LEVEL3:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 8;
                cannonCount = 2;
                bombCount = 2;
                towerCount = 0;
                ballistaCount = 2;
                mortarCount = 1;
                armySize = 12;
                actualLevel = 3;

                break;
        }

    }
}
