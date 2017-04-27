package fi.saajaro.logiikka.moodit;

import fi.saajaro.logiikka.Taistelu;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import javax.swing.JButton;
import javax.swing.JTextArea;
/**
 * Rajapinta jonka täyttäviä luokkia voi helposti käyttää yhdistämään logiikkaa käyttöliittymään erilaisin tavoin
helpottaen erilaisia laajennuksia.
*/
public interface Moodi {
    
    public Pelaaja getHero();
    /**
     * Rajapinnan täyttävien luokkien tulee sisältää metodi seuraava jonka avulla voi siirtyä eteenpäin suorituksessa.
     */
    public void seuraava();

    public JButton getA();

    public JButton getS();

    public JButton getD();

    public JTextArea getTeksti();

    public int getOsoitin();

    public String getKomento();

    public void setKomento(String uusiKomento);
    /**
    Rajapinnan täyttävien luokkien tulee sisältää jokin tapa yhdistää taisteluihin kuuluva logiikka niihin kuuluviin käyttöliittymiin.
    */
    public void taisto();

}
