package com.app.baza.rest;

import org.basex.util.Base64;

public class Authenticate {

    public String authenticate(){
        String user = "admin";
        String password = "admin";
        String encoded = Base64.encode(user + ":" + password);
        return encoded;
    }
}
