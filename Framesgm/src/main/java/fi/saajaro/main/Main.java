package fi.saajaro.main;

//import fi.saajaro.gui.Kayttoliittyma;
import fi.saajaro.gui.Kayttoliittyma;
import fi.saajaro.gui.Taistelu;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;
import javax.swing.SwingUtilities;

public class Main {

    /**
     * Main metodi joka kutsuu ohjelman metodeja.
     *
     * @param args saadut arvot.
     */
    public static void main(String[] args) {
        //Pelaaja hero = Gauntlet.luoHero();
        //System.out.println(hero.toString());
        //Gauntlet.battle(hero); 
        Kayttoliittyma t = new Kayttoliittyma();
        SwingUtilities.invokeLater(t);

    }

}
