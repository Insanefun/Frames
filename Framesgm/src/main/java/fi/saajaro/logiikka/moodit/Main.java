package fi.saajaro.logiikka.moodit;

//import fi.saajaro.gui.Kayttoliittyma;
import fi.saajaro.gui.Kayttoliittyma;
import fi.saajaro.logiikka.Taistelu;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import fi.saajaro.logiikka.tapahtumat.Gauntlet;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        //Pelaaja hero = Gauntlet.luoHero();
        //System.out.println(hero.toString());
        //Gauntlet.battle(hero); 
        Kayttoliittyma t = new Kayttoliittyma();
        SwingUtilities.invokeLater(t);

    }

}
