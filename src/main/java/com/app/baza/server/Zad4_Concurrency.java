package com.app.baza.server;

import com.app.baza.local.Queries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Zad4_Concurrency {

    public static void execThread(int numberThreads) throws IOException{
        Zad2_ExecuteQueryThread query = new Zad2_ExecuteQueryThread();

        ExecutorService executor = Executors.newFixedThreadPool(numberThreads);
        List<Runnable> queries = new ArrayList<>();
        queries.add(query.execQuery(Queries.zad6));
        queries.add(query.execQuery(Queries.zad7));
        queries.add(query.execQuery(Queries.zad8));
        queries.add(query.execQuery(Queries.zad9));
        queries.add(query.execQuery(Queries.zad10));

        Zad3_Timer timer = new Zad3_Timer();

        timer.start();
        queries.stream()
                .forEach(executor::execute);
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (Exception aEx) {
            aEx.printStackTrace();
        }
        timer.stop();
    }

    public static void main(String[] args) {
        Zad1_Conn connection = new Zad1_Conn();
        try {
            connection.connect();
            System.out.println("EXECUTE ONE ");
            System.out.println("#####################################");
            execThread(1);
            System.out.println("EXECUTE ALL ");
            System.out.println("#####################################");
            execThread(5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
