package fi.saajaro.logiikka.randomnumbergod;

import java.util.Random;

public class Rng {

    private int arvo;
    private int suurin;

    public Rng(int arvo, int suurin) {
        this.arvo = arvo;
        this.suurin = suurin;

    }

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
