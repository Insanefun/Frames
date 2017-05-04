
package fi.saajaro.logiikka.hahmot;


public class Ase {
    /**
     * String esitys joka näytetään käyttäjälle kun olio tekee jotain.
     */
    private String nimi;
    /**
     * Olioon liitetty arvo joka nostaa siihen yhteydessä olevan olion damage arvoa.
     */
    private int damage;
    /**
     * Pelaaja olio johon olio on yhteydessä.
     */
    private Pelaaja user;
    /**
     * Olion mahdollinen erityis ominaisuus
     */
    private int effect;
    /**
     * Oletus konstruktori.
     * @param nimi olioon liittyvä String jolla sitä kutsutaan.
     * @param damage int arvo jolla olio lisää siihen liitetyn olion damage arvoa
     * @param user Pelaaja olio johon olio liitetään.
     * @param effect int muotoinen tieto onko oliolla erityis vaikutuksia.
     */
    public Ase(String nimi, int damage, Pelaaja user, int effect) {
        this.nimi = nimi;
        this.damage = damage;
        this.user = user;
        this.effect = effect;
    }
    /**
     * Metodi aktivoi olion erityis ominaisuuden jos sillä sellainen on.
     */
    public void trigger() {
        if (this.effect == 1) {   //Jos luodaan lisää luo oma luokka.
            user.heal(damage);
        }
    }
    public String getNim() {
        return this.nimi;
    }
    public int getDamage() {
        return this.damage;
    }
    public Pelaaja getUser() {
        return this.user;
    }
    public int getEffect() {
        return this.effect;
    }
}

