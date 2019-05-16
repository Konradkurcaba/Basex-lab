package com.app.baza.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Zad3_QueryGET {

    private static final String BASE_URL = "http://localhost:8984/rest/";

    private Authenticate authenticate = new Authenticate();

    public Runnable getRunnableQuery(String aQuery, int queryNumber) throws IOException {

        URL url = new URL(BASE_URL + Zad2_Create.DATABASE_NAME + "?query=" + aQuery);
        HttpURLConnection dbConn = (HttpURLConnection) url.openConnection();

        return() -> {
            try
            {
                Timer timer = new Timer();
                timer.start();
                dbConn.setRequestProperty("Authorization", "Basic " + authenticate.authenticate());
                int responseCode = dbConn.getResponseCode();

                System.out.println("\n* Query " + queryNumber + " result:");
                System.out.println("\n* HTTP response code: " + responseCode +
                        " (" + dbConn.getResponseMessage() + ')');

                if(responseCode == HttpURLConnection.HTTP_OK)
                {
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(dbConn.getInputStream(), "UTF-8"));
                    for(String line; (line = br.readLine()) != null;)
                    {
                        System.out.println(line);
                    }
                    timer.stop();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                dbConn.disconnect();
            }

        };


    }

}
