package com.mygdx.clashofclans;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.Random;

public class Calculations {
    private static final int animationWidth = 32;
    private static final int animationHeight = 32;

    public static float distanceBetweenPoints(float pX1, float pY1, float pX2, float pY2){
        double factorOne = pY1-pY2;
        double factorTwo = pX1-pX2;
        double expFactorOne = Math.pow(factorOne, 2);
        double expFactorTwo = Math.pow(factorTwo, 2);
        double distance = Math.sqrt(expFactorOne+expFactorTwo);
        return (float)distance;
    }

    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static boolean isCellBlocked(float x, float y, TiledMapTileLayer collisionLayer){
        TiledMapTileLayer.Cell cell = collisionLayer.getCell((int) (x/collisionLayer.getTileWidth()), (int) (y/collisionLayer.getTileHeight()));
        return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey("Attackable");
    }

    public static boolean collidesRight(int initialX, int initialY, TiledMapTileLayer collisionLayer){
        boolean collides = false;

        for (float step = 0; step < animationWidth; step+=(collisionLayer.getTileHeight())/2){
            collides = isCellBlocked(initialX + animationWidth, initialY + step, collisionLayer);
            if (collides){
                break;
            } else if (isCellBlocked(initialX+4 + animationWidth, initialY + step, collisionLayer)){
                collides=true;
                break;
            }
        }
        return collides;
    }

    public static boolean collidesLeft(int initialX, int initialY, TiledMapTileLayer collisionLayer){
        boolean collides = false;

        for (float step = 0; step < animationWidth; step+=collisionLayer.getTileHeight()/2){
            collides = isCellBlocked(initialX, initialY + step, collisionLayer);
            if (collides){
                break;
            } else if (isCellBlocked(initialX-4, initialY + step, collisionLayer)){
                collides=true;
                break;
            }
        }
        return collides;
    }

    public static boolean collidesTop(int initialX, int initialY, TiledMapTileLayer collisionLayer){
        boolean collides = false;

        for (float step = 0; step < animationWidth; step+=collisionLayer.getTileWidth()/2){
            collides = isCellBlocked(initialX + step, initialY + (animationHeight), collisionLayer);
            if (collides){
                break;
            } else if (isCellBlocked(initialX + step, initialY+4 + (animationHeight), collisionLayer)){
                collides=true;
                break;
            }
        }
        return collides;
    }

    public static boolean collidesBottom(int initialX, int initialY, TiledMapTileLayer collisionLayer){
        boolean collides = false;

        for (float step = 0; step < animationWidth; step+=collisionLayer.getTileWidth()/2){
            collides = isCellBlocked(initialX + step, initialY, collisionLayer);
            if (collides){
                break;
            } else if (isCellBlocked(initialX + step, initialY-4, collisionLayer)){
                collides=true;
                break;
            }
        }
        return collides;
    }

    public static int getBaseCenter(int min, int max){
        return (((max-min)/2)+min);
    }
}
