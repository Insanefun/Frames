**Aihe:** Toteutetaan yksinkertainen roolipeli jossa pääpaino on satunaisesti generoiduilla tapahtumilla ja taisteluilla. Luodaan käyttöjärjestelmä jossa
käyttäjälle annetaan etukäteen päätettyjä vaihtoehtoja reagoida tilanteisiin. Tapahtumien kulku selitetään käyttäjälle teksti muodossa.
Pyritään luomaan tapa pelattavan hahmon kehittämiseen ja tapahtumien satunnaisuuden lisääämiseen uudelleen peluun tekemiseksi mielekkääksi.

**Käyttäjät:** Pelaaja
**Pelaajan toiminnot:** 

-Pelin aloitus  <br />
-Valintojen tekeminen  <br />
-Hahmon kehitys <br />


![lopetus kaavio](kaaviot/Peliohi.png) <br />
![aloitus kaavio](kaaviot/pelinaloitus.png) <br />

**Rakennekuvaus** </br>
Luokka Pelaaja luo olion joka pitää sisällään kaikki käyttäjälle pidempään tärkeyät tiedot, kuten sen kuinka paljon vauriota on kärsitty ja <br />
kuinka paljon eri ominaisuuksia on kehitetty omaa hahmoa kehitettäessä. Tärkeitä oliion säilöttäviä muuttujia ovat muunmuassa hp joka kuvaa suurinta mahdollista hp määrää, <br />
currentHp jonka laskiessa nollaan peli päättyy. streight ja agility joita käytetään vihollisia kohdatessa laskemaan tehty vaurio.<br />
Myös pelaaja tilla kuvaavia muuttujia kuten toiminta joka kertoo viimeisen tapahtuman ja alive joka kertoo jos hp laskee allen yhden <br />
sekä level joka kertoo saatuje tasojen määrän sekä bonusDefence ja attackBonus jotka muuttavat otettua ja tehtyä vauriota. <br />
Oliolla on myös useita metodeja vihollisten kohtaamista varten jotka laskevat mitä tulee tapahtumaan. <br />
<br />
Taistelu luokka yhdistää Pelaaja olion ja Mobs olion jolloin ne pystyvät vaikuttamaan toisiinsa. Sen metodit varmistavat, että oikeita komentoja kutsutaan oikeissa tapahtumia. <br />
Mobs oliot pitävät sisällään vihollisten tärkeät ominaisuudet kuten paljonko vauriota se voi ottaa kuinka vahvoja sen hyökkäykset ovat <br />
ja kuinka usein se väistää pelaajn tekemän vaurion tai tekee kaksin kertaisen vaurion pelaajaan <br />
Kohtaamisten sujuvuuden kannalta tärkeä Gauntlet luokka saa tiedot Taistelu luokalta ja varmistaa, että logiikka taustalla toimii. <br />