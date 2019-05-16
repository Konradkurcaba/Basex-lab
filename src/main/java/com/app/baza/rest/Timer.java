package com.app.baza.rest;

import java.time.Duration;
import java.time.Instant;

public class Timer {

    private Instant start;
    private Instant stop;

    public void start(){

        start = Instant.now();
    }
    public void stop() {
        stop = Instant.now();
        System.out.println("Time: "+ Duration.between(start,stop).toMillis() + " ms");
    }
}
