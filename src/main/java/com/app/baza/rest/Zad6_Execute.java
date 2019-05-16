package com.app.baza.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Zad6_Execute {

     public static void runGetQueries(int numberOfThreads) throws IOException {
         System.out.println("GET:");
       Zad3_QueryGET get = new Zad3_QueryGET();
       ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
       List<Runnable> queries = new ArrayList<>();
       queries.add(get.getRunnableQuery(Queries.zad6,6));
       queries.add(get.getRunnableQuery(Queries.zad7,7));
       queries.add(get.getRunnableQuery(Queries.zad8,8));
       queries.add(get.getRunnableQuery(Queries.zad9,9));
       queries.add(get.getRunnableQuery(Queries.zad10,10));
       queries.stream().forEach(executor::execute);
       try {
           executor.shutdown();
           executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
    public static void runPostQueries(int numberOfThreads){
        System.out.println("POST:");
        Zad4_QueryPOST post = new Zad4_QueryPOST();
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Runnable> queries = new ArrayList<>();
        queries.add(post.postPostQuery(Queries.zad6POST,6));
        queries.add(post.postPostQuery(Queries.zad7POST,7));
        queries.add(post.postPostQuery(Queries.zad8POST,8));
        queries.add(post.postPostQuery(Queries.zad9POST,9));
        queries.add(post.postPostQuery(Queries.zad10POST,10));
        queries.stream().forEach(executor::execute);
        try {
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Zad1_Server server = new Zad1_Server();
        Zad2_Create create = new Zad2_Create();
        Zad5_Delete delete = new Zad5_Delete();

        try {

            server.startServer();
            create.createDatabase();
            runGetQueries(5);
            runPostQueries(5);
            delete.deleteDB();
            server.stopServer();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
