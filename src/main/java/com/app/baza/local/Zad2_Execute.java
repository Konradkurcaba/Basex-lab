package com.app.baza.local;

import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.XQuery;

public class Zad2_Execute {
    private Context context;

    public Zad2_Execute(Context context) {
        super();
        this.context = context;
    }

    public void printResults(final String query) throws BaseXException {

        System.out.println(new XQuery(query).execute(context));
    }
}
