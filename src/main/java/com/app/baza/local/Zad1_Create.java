package com.app.baza.local;

import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.DropDB;
import org.basex.core.cmd.List;

public class Zad1_Create {
    private Context context = new Context();
    private String dbName;
    private String dbFile;

    public Zad1_Create(String dbName, String dbFile) {
        super();
        this.dbName = dbName;
        this.dbFile = dbFile;
    }

    public void createDb() throws BaseXException {
        System.out.println("============= Show existing databases: =============");
        System.out.print(new List().execute(context));
        System.out.println("============= Create a database =============");
        new CreateDB(dbName, dbFile).execute(context);
        System.out.println("============= Show existing databases: =============");
        System.out.print(new List().execute(context));
    }

    public void removeDb() throws BaseXException {
        System.out.println("============= Drop the database =============");
        new DropDB(dbName).execute(context);
        System.out.println("============= Show existing databases: =============");
        System.out.print(new List().execute(context));
        context.close();
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbFile() {
        return dbFile;
    }

    public void setDbFile(String dbFile) {
        this.dbFile = dbFile;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
