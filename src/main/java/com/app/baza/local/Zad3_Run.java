package com.app.baza.local;

import org.basex.core.BaseXException;

public class Zad3_Run {
    public static void main(String[] args) throws BaseXException {


        Zad1_Create zad1 = new Zad1_Create("nowa", "C:\\mondial.xml");
        zad1.createDb();
        Zad2_Execute exec = new Zad2_Execute(zad1.getContext());

        System.out.println("============= Zadanie 1 =============");
        exec.printResults(Queries.zad1);
        System.out.println();
        System.out.println("============= Zadanie 2 =============");
        exec.printResults(Queries.zad2);
        System.out.println();
        System.out.println("============= Zadanie 3 =============");
        exec.printResults(Queries.zad3);
        System.out.println();
        System.out.println("============= Zadanie 4 =============");
        exec.printResults(Queries.zad4);
        System.out.println();
        System.out.println("============= Zadanie 5 =============");
        exec.printResults(Queries.zad5);
        System.out.println();
        System.out.println("============= Zadanie 6 =============");
        exec.printResults(Queries.zad6);
        System.out.println();
        System.out.println("============= Zadanie 7 =============");
        exec.printResults(Queries.zad7);
        System.out.println();
        System.out.println("============= Zadanie 8 =============");
        exec.printResults(Queries.zad8);
        System.out.println();
        System.out.println("============= Zadanie 9 =============");
        exec.printResults(Queries.zad9);
        System.out.println();
        System.out.println("============= Zadanie 10 =============");
        exec.printResults(Queries.zad10);
        System.out.println();

        zad1.removeDb();
    }

}
