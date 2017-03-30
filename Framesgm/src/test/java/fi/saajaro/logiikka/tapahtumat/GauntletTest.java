package fi.saajaro.logiikka.tapahtumat;

import fi.saajaro.logiikka.hahmot.Mobs;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GauntletTest {

    public GauntletTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void deepOikein() {
        assertEquals("... A dancer with no legs...", Gauntlet.deep());
    }

    @Test
    public void generateEnemyLuoElossaOleviaVIhollisia() {
        Mobs enemy = Gauntlet.generateEnemy();
        assertEquals(Boolean.TRUE, enemy.tellAlive());
    }
}
