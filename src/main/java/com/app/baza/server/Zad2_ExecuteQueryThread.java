package com.app.baza.server;

import org.basex.api.client.ClientQuery;
import org.basex.api.client.ClientSession;

import java.io.IOException;

public class Zad2_ExecuteQueryThread {

    static void send(final String cmd, final ClientSession cs) throws IOException {
        cs.execute(cmd);
    }

    public Runnable execQuery(String querySt) throws IOException {
        final ClientSession session = new ClientSession("localhost", 1984, "admin", "admin");
        send("OPEN db", session);
        return () -> {
            try {
                ClientQuery query = session.query(querySt);
                System.out.println(query.execute());
                System.out.println("#####################################################");
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    session.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
    }

}
