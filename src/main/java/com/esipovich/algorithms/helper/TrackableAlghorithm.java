package com.esipovich.algorithms.helper;

/**
 * @author Artem Esipovich 4/30/2018
 */

public abstract class TrackableAlghorithm {

    public abstract void run();

    public void trackTime(){
        long startTime = System.currentTimeMillis();
        run();
        long endTime = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (endTime - startTime) + " ms");
    }
}
