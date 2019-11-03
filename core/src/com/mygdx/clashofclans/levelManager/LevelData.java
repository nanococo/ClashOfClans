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
                defenseCount = 8;
                cannonCount = 5;
                bombCount = 3;
                towerCount = 0;
                ballistaCount = 0;
                mortarCount = 0;
                armySize = 20;
                actualLevel = 1;
                break;
            case LEVEL2:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 10;
                cannonCount = 7;
                bombCount = 3;
                towerCount = 0;
                ballistaCount = 2;
                mortarCount = 0;
                armySize = 25;
                actualLevel = 2;

                break;
            case LEVEL3:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 10;
                cannonCount = 5;
                bombCount = 2;
                towerCount = 0;
                ballistaCount = 0;
                mortarCount = 3;
                armySize = 30;
                actualLevel = 3;

                break;
            case LEVEL4:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 12;
                cannonCount = 6;
                bombCount = 4;
                towerCount = 0;
                ballistaCount = 0;
                mortarCount = 2;
                armySize = 35;
                actualLevel = 4;

                break;
            case LEVEL5:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 14;
                cannonCount = 8;
                bombCount = 6;
                towerCount = 0;
                ballistaCount = 0;
                mortarCount = 0;
                armySize = 40;
                actualLevel = 5;

                break;
            case LEVEL6:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 14;
                cannonCount = 10;
                bombCount = 0;
                towerCount = 0;
                ballistaCount = 0;
                mortarCount = 4;
                armySize = 45;
                actualLevel = 6;

                break;
            case LEVEL7:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 14;
                cannonCount = 6;
                bombCount = 6;
                towerCount = 0;
                ballistaCount = 0;
                mortarCount = 2;
                armySize = 50;
                actualLevel = 7;

                break;
            case LEVEL8:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 14;
                cannonCount = 14;
                bombCount = 0;
                towerCount = 0;
                ballistaCount = 0;
                mortarCount = 0;
                armySize = 55;
                actualLevel = 8;

                break;
            case LEVEL9:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 14;
                cannonCount = 7;
                bombCount = 0;
                towerCount = 0;
                ballistaCount = 7;
                mortarCount = 1;
                armySize = 60;
                actualLevel = 9;

                break;
            case LEVEL10:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 15;
                cannonCount = 0;
                bombCount = 14;
                towerCount = 1;
                ballistaCount = 0;
                mortarCount = 0;
                armySize = 65;
                actualLevel = 10;

                break;
            case LEVEL11:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 15;
                cannonCount = 6;
                bombCount = 5;
                towerCount = 1;
                ballistaCount = 2;
                mortarCount = 1;
                armySize = 70;
                actualLevel = 11;

                break;
            case LEVEL12:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 15;
                cannonCount = 6;
                bombCount = 6;
                towerCount = 0;
                ballistaCount = 2;
                mortarCount = 1;
                armySize = 75;
                actualLevel = 12;

                break;
            case LEVEL13:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 15;
                cannonCount = 5;
                bombCount = 2;
                towerCount = 1;
                ballistaCount = 2;
                mortarCount = 5;
                armySize = 80;
                actualLevel = 13;

                break;
            case LEVEL14:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 20;
                cannonCount = 5;
                bombCount = 5;
                towerCount = 3;
                ballistaCount = 2;
                mortarCount = 5;
                armySize = 85;
                actualLevel = 14;

                break;
            case LEVEL15:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 25;
                cannonCount = 5;
                bombCount = 5;
                towerCount = 5;
                ballistaCount = 5;
                mortarCount = 5;
                armySize = 90;
                actualLevel = 15;

                break;
            default:
                minBaseWidth = 660;
                maxBaseWidth = 1300;
                minBaseHeight = 350;
                maxBaseHeight = 900;
                defenseCount = 26;
                cannonCount = 4;
                bombCount = 6;
                towerCount = 2;
                ballistaCount = 6;
                mortarCount = 7;
                armySize = 95;
                actualLevel = 16;

                break;
        }

    }
}
