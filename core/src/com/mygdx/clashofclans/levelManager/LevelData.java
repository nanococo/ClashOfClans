package com.mygdx.clashofclans.levelManager;

/**
 * Singleton class for level Data
 * @author sebas
 */
public class LevelData {
    private static LevelData levelData = null;

    private int minBaseWidth;
    private int minBaseHeight;
    private int maxBaseWidth;
    private int maxBaseHeight;

    private LevelData(){
        this.minBaseWidth = 0;
        this.minBaseHeight = 0;
        this.maxBaseWidth = 0;
        this.minBaseHeight = 0;
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

    public void setLevel(Levels level){
        switch (level){
            case LEVEL1:
                minBaseWidth = 660;
                maxBaseWidth = 1250;
                minBaseHeight = 350;
                maxBaseHeight = 900;
        }
    }
}
