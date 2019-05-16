package com.app.baza.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Zad4_QueryPOST {

    public Runnable postPostQuery(String query, int queryNumber){

        return() -> {
            try {
                Timer timer = new Timer();
                timer.start();
                URL url = new URL("http://localhost:8984/rest/" + Zad2_Create.DATABASE_NAME);

                HttpURLConnection dbConnection = (HttpURLConnection) url.openConnection();
                dbConnection.setDoOutput(true);
                dbConnection.setRequestMethod("POST");
                dbConnection.setRequestProperty("Content-Type", "application/query+xml");

                try(OutputStream out = dbConnection.getOutputStream()) {
                    out.write(query.getBytes("UTF-8"));
                }
                int responeCode = dbConnection.getResponseCode();
                System.out.println("\n* Query " + queryNumber + " result:");
                System.out.println("\n* HTTP response: " + responeCode +
                        " (" + dbConnection.getResponseMessage() + ')');

                if(responeCode == HttpURLConnection.HTTP_OK) {
                    try(BufferedReader br = new BufferedReader(
                            new InputStreamReader(dbConnection.getInputStream(), "UTF-8"))) {
                        for(String line; (line = br.readLine()) != null;) {
                            System.out.println(line);
                        }
                        timer.stop();
                    }
                }
                dbConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        };
    }
}
