package com.mygdx.clashofclans.Tokens.Defenses;

import com.mygdx.clashofclans.Tokens.Defense;

/**
 * Factory Method Creator class
 */
public class DefenseFactory {
    public static Defense getDefense(int index, int x, int y){
        switch (index){
            case 0:
                return new Canyon(x, y);
            case 1:
                return new Bomb(x, y);
            case 2:
                return new AerialDefense(x, y);
            case 3:
                return new Mortar(x, y);
            case 4:
                return new Tower(x, y);
            default:
                return null;
        }
    }
}
