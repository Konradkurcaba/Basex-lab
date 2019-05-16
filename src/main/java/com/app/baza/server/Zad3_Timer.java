package com.app.baza.server;

public class Zad3_Timer {

    private long start;
    private long stop;

    public void start(){
        start = System.currentTimeMillis();
    }
    public void stop() {
        stop = System.currentTimeMillis() - start;
        System.out.println("Time: "+ stop + " [ms]");
    }
}
