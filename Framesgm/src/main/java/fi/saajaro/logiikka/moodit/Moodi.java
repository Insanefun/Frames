package fi.saajaro.logiikka.moodit;

import fi.saajaro.logiikka.Taistelu;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import javax.swing.JButton;
import javax.swing.JTextArea;

public interface Moodi {

    public Pelaaja getHero();

    public void seuraava();

    public JButton getA();

    public JButton getS();

    public JButton getD();

    public JTextArea getTeksti();

    public int getOsoitin();

    public String getKomento();

    public void setKomento(String uusiKomento);

    public void taisto();

}
