package com.mygdx.clashofclans.Tokens.Defenses;

import com.mygdx.clashofclans.Tokens.Defense;

/**
 * Factory Method Creator class
 * @author sebas
 */
public class DefenseFactory {
    private static Defense defense = null;
    public static Defense getDefense(int index, int x, int y){
        switch (index){
            case 0:
                defense = new Canyon(x, y);
                defense.setDefType(index);
                return defense;
            case 1:
                defense = new Bomb(x, y);
                defense.setDefType(index);
                return defense;
            case 2:
                defense = new AerialDefense(x, y);
                defense.setDefType(index);
                return defense;
            case 3:
                defense = new Mortar(x, y);
                defense.setDefType(index);
                return defense;
            case 4:
                defense = new Tower(x, y);
                defense.setDefType(index);
                return defense;
            default:
                return null;
        }
    }
}
