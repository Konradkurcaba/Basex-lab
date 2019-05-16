package com.app.baza.rest;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Zad2_Create {

    public static final String DATABASE_NAME = "database";
    private static final String XML_FILE = "C:\\Users\\Konrad\\basex\\basex\\baza\\mondial.xml";

    public void createDatabase() throws IOException{
        System.out.println("Creating database....");

        URL dbURL = new URL("http://localhost:8984/rest/" + DATABASE_NAME);
        System.out.println("URL: " + dbURL);

        HttpURLConnection conn = (HttpURLConnection) dbURL.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");

        try(OutputStream out = new BufferedOutputStream(conn.getOutputStream());
            InputStream in = new BufferedInputStream(
                    new FileInputStream(XML_FILE))) {
            System.out.println("Sending XML to server");

            for(int i; (i = in.read()) != -1;)
            {
                out.write(i);
            }
        }

        System.out.println("Response: " + conn.getResponseCode() +
                " (" + conn.getResponseMessage() + ')');
        conn.disconnect();
    }
}
