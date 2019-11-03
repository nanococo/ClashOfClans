package com.mygdx.clashofclans.Tokens.Interfaces;

/*
+life if the amount of hits a defense can take before being destroyed
+range is the radius in which a defense can lock and attack a target
+attack rate is the amount of hits per second the defense launches
 */

public interface IDefenseConstants {

    int CANYON_DEFENSE_LIFE = 5; //life
    int CANYON_DEFENSE_RANGE = 300; //range
    double CANYON_DEFENSE_ATTACKRATE = 2; //attack rate
    String CANYON_DEFENSE_ANIMATION_WEST = "Objects/Cañón/Cañón (Left).gif";
    String CANYON_DEFENSE_ANIMATION_EAST = "Objects/Cañón/Cañón (Right).gif";
    String CANYON_DEFENSE_ANIMATION_NORTH = "Objects/Cañón/Cañón (Up).gif";
    String CANYON_DEFENSE_ANIMATION_SOUTH = "Objects/Cañón/Cañón (Down).gif";
    String CANYON_DEFENSE_ANIMATION_NORTHWEST = "Objects/Cañón/Cañón (Left).gif";
    String CANYON_DEFENSE_ANIMATION_NORTHEAST = "Objects/Cañón/Cañón (Right).gif";
    String CANYON_DEFENSE_ANIMATION_SOUTHEAST = "Objects/Cañón/Cañón (Up).gif";
    String CANYON_DEFENSE_ANIMATION_SOUTHWEST = "Objects/Cañón/Cañón (Down).gif";
    String CANYON_DEFENSE_STATICANIMATION_WEST = "Objects/Cañón/Cañón Estático (Left).gif";
    String CANYON_DEFENSE_STATICANIMATION_EAST = "Objects/Cañón/Cañón Estático (Right).gif";
    String CANYON_DEFENSE_STATICANIMATION_NORTH = "Objects/Cañón/Cañón Estático (Up).gif";
    String CANYON_DEFENSE_STATICANIMATION_SOUTH = "Objects/Cañón/Cañón Estático (Down).gif";
    String CANYON_DEFENSE_STATICANIMATION_NORTHWEST = "Objects/Cañón/Cañón Estático (Left).gif";
    String CANYON_DEFENSE_STATICANIMATION_NORTHEAST = "Objects/Cañón/Cañón Estático (Right).gif";
    String CANYON_DEFENSE_STATICANIMATION_SOUTHEAST = "Objects/Cañón/Cañón Estático (Up).gif";
    String CANYON_DEFENSE_STATICANIMATION_SOUTHWEST = "Objects/Cañón/Cañón Estático (Down).gif";


    int MORTAR_DEFENSE_LIFE = 5; //life
    int MORTAR_DEFENSE_RANGE = 350; //range
    double MORTAR_DEFENSE_ATTACKRATE = 2; //attack rate
    String MORTAR_DEFENSE_ANIMATION_LEFT = "Objects/Mortero/Mortero.gif";
    String MORTAR_DEFENSE_ANIMATION_RIGHT = "Objects/Mortero/Mortero R.gif";
    String MORTAR_DEFENSE_STATICANIMATION_LEFT = "Objects/Mortero/Mortero Estático.gif";
    String MORTAR_DEFENSE_STATICANIMATION_RIGHT = "Objects/Mortero/Mortero R Estático.gif";

    int TOWER_DEFENSE_LIFE = 5; //life

    int TOWER_DEFENSE_RANGE = 300; //range
    double TOWER_DEFENSE_ATTACKRATE = 5; //attack rate
    String TOWER_DEFENSE_ANIMATION_LEFT = "Objects/Torre/Torre.gif";
    String TOWER_DEFENSE_ANIMATION_RIGHT = "Objects/Torre/Torre R.gif";
    String TOWER_DEFENSE_STATICANIMATION_LEFT = "Objects/Torre/Torre.gif";
    String TOWER_DEFENSE_STATICANIMATION_RIGHT = "Objects/Torre/Torre R.gif";


    int BOMB_DEFENSE_LIFE = 1; //life
    int BOMB_DEFENSE_RANGE = 60; //range
    double BOMB_DEFENSE_ATTACKRATE = 0; //attack rate
    String BOMB_DEFENSE_ANIMATION = "Objects/Bomba/Bomba estática.gif";
    String BOMB_DEFENSE_EXPLOSIONANIMATION = "Objects/Bomba/Explosión.gif";

    int AERIAL_DEFENSE_LIFE = 5; //life
    int AERIAL_DEFENSE_RANGE = 200; //range
    double AERIAL_DEFENSE_ATTACKRATE = 3; //attack rate
    String AERIAL_DEFENSE_ANIMATION = "Objects/Ballesta/Ballesta.gif";
    String AERIAL_DEFENSE_STATICANIMATION = "Objects/Ballesta/Ballesta Estático.gif";


}
