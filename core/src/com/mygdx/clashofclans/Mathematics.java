package com.mygdx.clashofclans;

public class Mathematics {
    public static float distanceBetweenPoints(float pX1, float pY1, float pX2, float pY2){
        double factorOne = pY1-pY2;
        double factorTwo = pX1-pX2;
        double expFactorOne = Math.pow(factorOne, 2);
        double expFactorTwo = Math.pow(factorTwo, 2);
        double distance = Math.sqrt(expFactorOne+expFactorTwo);
        return (float)distance;
    }
}
