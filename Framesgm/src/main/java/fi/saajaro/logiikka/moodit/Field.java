package fi.saajaro.logiikka.moodit;

import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;

public class Field {

    public static void main(String[] args) {
        Pelaaja hero = Gauntlet.luoHero();
        System.out.println(hero.toString());
        Gauntlet.battle(hero);

    }

}
