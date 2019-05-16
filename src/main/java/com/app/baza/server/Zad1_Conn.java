package com.app.baza.server;

import org.basex.BaseXServer;
import org.basex.api.client.ClientSession;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.DropDB;

import java.io.IOException;

public class Zad1_Conn {
    BaseXServer server = null;
    ClientSession session;

    public void connect() {
        try {
            server = new BaseXServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            session = new ClientSession("localhost", 1984, "admin", "admin");
            session.execute(new CreateDB("nowa", "C:\\mondial.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            send("DROP DB db", session);
            server.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void send(final String cmd, final ClientSession cs) throws IOException {
        cs.execute(cmd);
    }
}
