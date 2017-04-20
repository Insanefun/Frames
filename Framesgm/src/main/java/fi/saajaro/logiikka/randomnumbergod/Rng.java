package fi.saajaro.logiikka.randomnumbergod;

import java.util.Random;

public class Rng {

    /**
     * Arvo jota suurenpi satunnaisluvun on oltava jotta palautettaisi false.
     */
    private int arvo;
    /**
     * suurin mahdollinen arvo jonka satunnaisluku voi saada.
     */
    private int suurin;

    /**
     * Asettaa olion arvon arvo ja arvon suurin parametreinä saatuihin arvoihin.
     *
     * @param arvo asettaa olion arvon arvoksi saadun arvon
     * @param suurin asettaa olion arvon suurin arvoksi saadun arvon
     */
    public Rng(int arvo, int suurin) {
        this.arvo = arvo;
        this.suurin = suurin;

    }

    /**
     * Metodi joka arpoo satunnaisluvun joka on enintään olioon tallennettu
     * suurin arvo ja tarkistaa onko se suurenpi kuin olioon tallennettu arvo
     * arvo.
     *
     * @return palauttaa true jos arvo oli suurenpi kuin arvottu luku
     */
    public boolean randomNumber() {
        Random rn = new Random();
        int vertailu = rn.nextInt(this.suurin);
        if (this.arvo > vertailu) {
            return true;
        } else {
            return false;
        }
    }
}
