package com.app.baza.wiki;

import com.app.baza.local.Zad1_Create;
import com.app.baza.local.Zad2_Execute;
import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.Set;

public class Zad4_Add {

    public static void main(String[] args) throws BaseXException {


        Context context = new Context();
        new Set("intparse", true).execute(context);


        final String doc = "https://en.wikipedia.org/wiki/Albert_Einstein";


        Zad1_Create create = new Zad1_Create("wikiExample", doc);
        create.setContext(context);
        create.createDb();


        Zad2_Execute execute = new Zad2_Execute(context);

        for (int i = 3; i < 6; i++) {
            execute.printResults("declare namespace xhtml='http://www.w3.org/1999/xhtml';" +
                    "for $x in //*[@id='mw-content-text']/div/table[1]/tbody/tr[" + i + "]/td/text()" +
                    "return <p>{ $x }</p>");
        }
        create.removeDb();
    }
}
