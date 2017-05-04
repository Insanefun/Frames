package fi.saajaro.logiikka.moodit;

import fi.saajaro.gui.Taistelu;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * Rajapinta jonka täyttäviä luokkia voi helposti käyttää yhdistämään logiikkaa
 * käyttöliittymään erilaisin tavoin helpottaen erilaisia laajennuksia.
 */
public interface Moodi {

    /**
     * Metodi jolla saadaan olio ja sen metodit käyttöön.
     *
     * @return Olio jonka metodeja käytetään muihin olioihin.
     */
    public Pelaaja getHero();

    /**
     * Rajapinnan täyttävien luokkien tulee sisältää metodi seuraava jonka
     * avulla voi siirtyä eteenpäin suorituksessa.
     */
    public void seuraava();

    /**
     * Metodi jolla saadaan JButton olio käyttöön.
     *
     * @return Haluttu JButton olio.
     */
    public JButton getA();

    /**
     * Metodi jolla saadaan JButton olio käyttöön.
     *
     * @return Haluttu JButton olio.
     */
    public JButton getS();

    /**
     * Metodi jolla saadaan JButton olio käyttöön.
     *
     * @return Haluttu JButton olio.
     */
    public JButton getD();

    /**
     * Metodi jolla saadaan JTextArea olio käyttöön.
     *
     * @return Haluttu JTextArea.
     */
    public JTextArea getTeksti();

    /**
     * Saadaan int arvo käyttöön.
     *
     * @return haluttu int arvo.
     */
    public int getOsoitin();

    /**
     * Saadaan haluttu String arvo tietoon ja muunnettavaksi.
     *
     * @return haluttu String arvo
     */
    public String getKomento();

    /**
     * Metodi jolla voidaan muutta komento Stringin arvoa.
     *
     * @param uusiKomento arvo joka halutaan asettaa
     */
    public void setKomento(String uusiKomento);

    /**
     * Rajapinnan täyttävien luokkien tulee sisältää jokin tapa yhdistää
     * taisteluihin kuuluva logiikka niihin kuuluviin käyttöliittymiin.
     */
    public void taisto();

}
