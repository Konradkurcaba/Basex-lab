package com.app.baza.local;

public class Queries {
    public static final String zad1 = "for $a in (1 to 3) for $b in ('a','b','c') return <parameters><a>{$a}</a> <b>{$b}</b></parameters>";
    public static final String zad2 = "let $x := <liczby>{(1 to 25)}</liczby> return $x";
    public static final String zad3 = "for $x in mondial/continent return $x/name/text()";
    public static final String zad4 = "for $x in mondial/country where $x/encompassed[@continent='europe'] return $x/name/text()";
    public static final String zad5 = "for $x in mondial/country where $x/encompassed[@continent='europe'] and $x/population > 20000000 order by $x/name return $x/name/text()";
    public static final String zad6 = "for $x in mondial/country where $x/population > 20000000 and $x/encompassed/@continent=\"europe\" for $y in $x/province/city where $y/located_at/@watertype = \"sea\" order by $y/name return $y/name/text()";
    public static final String zad7 = "for $x in /mondial/country where $x/encompassed[@continent='europe'] and $x/border[@country=/mondial/mountain[height>4000]/@country] order by $x/name return $x/name/text()";
    public static final String zad8 = "for $x in /mondial/country//city where $x[@is_country_cap='yes'] and $x/located_at[@watertype='river'] return $x/name/text()";
    public static final String zad9 = "for $x in /mondial/country where $x[border[@country='PL']] and $x/population > 40000000 return $x/name/text()";
    public static final String zad10 = "for $x in /mondial/lake where $x[not (@id =/mondial/country//city/located_at[@watertype='lake'])] return $x/name/text()";
}
