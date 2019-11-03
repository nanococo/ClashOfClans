package com.mygdx.clashofclans.levelManager;

import java.io.Serializable;

public enum Levels implements Serializable {
    LEVEL1,
    LEVEL2,
    LEVEL3,
    LEVEL4,
    LEVEL5,
    LEVEL6,
    LEVEL7,
    LEVEL8,
    LEVEL9,
    LEVEL10,
    LEVEL11,
    LEVEL12,
    LEVEL13,
    LEVEL14,
    LEVEL15;

    private static Levels[] vals = values();
    public Levels next()
    {
        if(this.ordinal()+1>15){
            return LEVEL15;
        } else {
            return vals[(this.ordinal()+1) % vals.length];
        }

    }
}
