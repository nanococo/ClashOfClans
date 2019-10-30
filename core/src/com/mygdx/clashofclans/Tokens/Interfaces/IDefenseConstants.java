package com.mygdx.clashofclans.Tokens.Interfaces;

/*
+life if the amount of hits a defense can take before being destroyed
+range is the radius in which a defense can lock and attack a target
+attack rate is the amount of hits per second the defense launches
 */

public interface IDefenseConstants {

    int CANYON_DEFENSE_LIFE = 5; //life
    int CANYON_DEFENSE_RANGE = 10; //range
    double CANYON_DEFENSE_ATTACKRATE = 1; //attack rate

    int MORTAR_DEFENSE_LIFE = 5; //life
    int MORTAR_DEFENSE_RANGE = 15; //range
    double MORTAR_DEFENSE_ATTACKRATE = 0.5; //attack rate

    int TOWER_DEFENSE_LIFE = 5; //life
    int TOWER_DEFENSE_RANGE = 20; //range
    double TOWER_DEFENSE_ATTACKRATE = 0.2; //attack rate

    int BOMB_DEFENSE_LIFE = 5; //life
    int BOMB_DEFENSE_RANGE = 1; //range
    double BOMB_DEFENSE_ATTACKRATE = 10; //attack rate

    int AERIAL_DEFENSE_LIFE = 5; //life
    int AERIAL_DEFENSE_RANGE = 40; //range
    double AERIAL_DEFENSE_ATTACKRATE = 3; //attack rate

}
