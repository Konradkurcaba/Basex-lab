package com.app.baza.rest;

import org.basex.BaseXHTTP;


public class Zad1_Server {

    private BaseXHTTP http;

    public void stopServer(){
        try {
            http.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        try {
           http = new BaseXHTTP("-U", "admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
