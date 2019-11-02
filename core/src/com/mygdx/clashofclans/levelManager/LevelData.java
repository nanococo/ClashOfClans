package com.mygdx.clashofclans.levelManager;

public class LevelData {
    private int minBaseWidth;
    private int minBaseHeight;
    private int maxBaseWidth;
    private int maxBaseHeight;

    public LevelData(){
        this.minBaseWidth = 0;
        this.minBaseHeight = 0;
        this.maxBaseWidth = 0;
        this.minBaseHeight = 0;
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
                minBaseWidth = 900;
        }
    }
}
