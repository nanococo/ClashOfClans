package com.mygdx.clashofclans.Tokens.Interfaces;

/*
+life if the amount of hits a defense can take before being destroyed
+range is the radius in which a defense can lock and attack a target
+attack rate is the amount of hits per second the defense launches
 */

public interface IDefenseConstants {

    int CANYON_DEFENSE_LIFE = 5; //life
    int CANYON_DEFENSE_RANGE = 150; //range
    double CANYON_DEFENSE_ATTACKRATE = 0.5; //attack rate
    String CANYON_DEFENSE_ANIMATION_LEFT = "Objects/Cañón/Cañón (Left).gif";
    String CANYON_DEFENSE_ANIMATION_RIGHT = "Objects/Cañón/Cañón (Right).gif";


    int MORTAR_DEFENSE_LIFE = 5; //life
    int MORTAR_DEFENSE_RANGE = 500; //range
    double MORTAR_DEFENSE_ATTACKRATE = 0.5; //attack rate
    String MORTAR_DEFENSE_ANIMATION_LEFT = "Objects/Mortero/Mortero.gif";
    String MORTAR_DEFENSE_ANIMATION_RIGHT = "Objects/Mortero/Mortero.gif";

    int TOWER_DEFENSE_LIFE = 5; //life
    int TOWER_DEFENSE_RANGE = 500; //range
    double TOWER_DEFENSE_ATTACKRATE = 0.2; //attack rate
    String TOWER_DEFENSE_ANIMATION_LEFT = "Objects/Torre/Torre.gif";
    String TOWER_DEFENSE_ANIMATION_RIGHT = "Objects/Torre/Torre.gif";

    int BOMB_DEFENSE_LIFE = 5; //life
    int BOMB_DEFENSE_RANGE = 10; //range
    double BOMB_DEFENSE_ATTACKRATE = 10; //attack rate
    String BOMB_DEFENSE_ANIMATION = "Objects/Bomba/Bomba.gif";

    int AERIAL_DEFENSE_LIFE = 5; //life
    int AERIAL_DEFENSE_RANGE = 40; //range
    double AERIAL_DEFENSE_ATTACKRATE = 3; //attack rate
    String AERIAL_DEFENSE_ANIMATION = "Objects/Ballesta/Ballesta.gif";

}
