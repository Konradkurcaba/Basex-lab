package com.app.baza.server;

public enum Queries {
    ZAD1("for $x in (1, 2, 3), $y in (\'a\', \'b\', \'c\') return data(<join><x>{ $x }</x><y>{ $y }</y></join>)"), ZAD2(
        "let $x:=(1 to 25)return<liczby>{$x}</liczby>"), ZAD3(
        "for $x in/mondial/continent return data($x / name)"), ZAD4(
        "for $x in //country where $x/encompassed/@continent =\'europe\' return data($x / name)"), ZAD5(
        "for $x in //country where $x/encompassed/ @continent = 'europe' and $x/population>20000000 order by $x/name return data($x / name)"), ZAD6(
        "for $x in //country where $x/encompassed/ @continent = 'europe' and $x/population>20000000 return(for $y in $x/province/city where $y/located_at/ @watertype = 'sea' order by $y/name return data($y / name))"), ZAD8(
        "for $x in //city where $x/ @is_country_cap = 'yes' and $x/located_at/ @watertype = 'river' order by $x/name return data($x / name)"), ZAD9(
        "for $x in //country where $x/border/ @country = 'PL' and $x/population>40000000 order by $x/name return data($x / name)"), ZAD11(
        "for $x in //country where $x/@area =max(//country/@area) order by $x/name return(data($x /name), data($x /population))");

    private final String text;

    private Queries(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
