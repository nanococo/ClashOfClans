package com.mygdx.clashofclans.Tokens.Interfaces;

/*
 +Attack rates is hits per second of each troop
 +Life is how many hits a troop can take before dying
 +Level available is in witch level each troop is unlocked
 +Upgrade rate is how fast a troop improves with each level
 +Troops consumed is how many troops a warrior consumes from the army
 +Range is the radius in which a troop can lock and attack a target
 */

public interface IWarriorConstants {

    int CONTACT_WARRIOR_LIFE = 4; //life
    double CONTACT_WARRIOR_ATTACKRATE = 1; //attack rate
    int CONTACT_WARRIOR_LEVELAVAILABLE = 1; //level available
    double CONTACT_WARRIOR_UPGRADERATE = 1; //upgrade rate
    int CONTACT_WARRIOR_TROOPS_CONSUMED = 1; //troops consumed
    int CONTACT_WARRIOR_RANGE = 32;


    int MIDRANGE_WARRIOR_LIFE = 3; //life
    double MIDRANGE_WARRIOR_ATTACKRATE = 2; //attack rate
    int MIDRANGE_WARRIOR_LEVELAVAILABLE = 1; //level available
    double MIDRANGE_WARRIOR_UPGRADERATE = 0.9; //upgrade rate
    int MIDRANGE_WARRIOR_TROOPS_CONSUMED = 1; //troops consumed
    int MIDRANGE_WARRIOR_RANGE = 100;


    int HERO_WARRIOR_LIFE = 10; //life
    double HERO_WARRIOR_ATTACKRATE = 1; //attack rate
    int HERO_WARRIOR_LEVELAVAILABLE = 8; //level available
    int HERO_WARRIOR_TROOPS_CONSUMED = 10; //troops consumed
    int HERO_WARRIOR_RANGE = 32;


    int BEAST_WARRIOR_LIFE = 25; //life
    double BEAST_WARRIOR_ATTACKRATE = 1/2f; //attack rate
    int BEAST_WARRIOR_LEVELAVAILABLE = 10; //level available
    int BEAST_WARRIOR_TROOPS_CONSUMED = 15; //troops consumed
    int BEAST_WARRIOR_RANGE = 100;

    int AERIAL_WARRIOR_LIFE = 25; //life
    double AERIAL_WARRIOR_ATTACKRATE = 1/3f; //attack rate
    int AERIAL_WARRIOR_LEVELAVAILABLE = 11; //level available
    double AERIAL_WARRIOR_UPGRADERATE = 0.5; //upgrade rate
    int AERIAL_WARRIOR_TROOPS_CONSUMED = 40; //troops consumed
    int AERIAL_WARRIOR_RANGE = 200;

    String PERSON_DEAD_ANIMATION_RIGHT = "Ghosts/Death.gif";
    String PERSON_DEAD_ANIMATION_LEFT = "Ghosts/Death L.gif";




}
