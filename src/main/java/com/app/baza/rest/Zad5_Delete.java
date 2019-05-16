package com.app.baza.rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Zad5_Delete {
    private Authenticate authenticate = new Authenticate();

    public void deleteDB() throws IOException{
        System.out.println("Deleting database....");

        URL url = new URL("http://admin:admin@localhost:8984/rest/" + Zad2_Create.DATABASE_NAME
                + "/mondial.xml");

        System.out.println("\n* URL: " + url);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");
        conn.setRequestProperty("Authorization", "Basic " + authenticate.authenticate());

        System.out.println("\n* HTTP response: " + conn.getResponseCode() +
                " (" + conn.getResponseMessage() + ')');
        url = new URL("http://admin:admin@localhost:8984/rest/" + Zad2_Create.DATABASE_NAME);

        System.out.println("\n* URL: " + url);

        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");
        conn.setRequestProperty("Authorization", "Basic " + authenticate.authenticate());

        System.out.println("\n* HTTP response: " + conn.getResponseCode() +
                " (" + conn.getResponseMessage() + ')');

        conn.disconnect();
    }
}
