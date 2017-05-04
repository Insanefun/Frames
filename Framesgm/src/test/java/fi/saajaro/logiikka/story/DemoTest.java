/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.saajaro.logiikka.story;

import fi.saajaro.gui.story.Demo;
import fi.saajaro.logiikka.hahmot.Pelaaja;
import javax.swing.JButton;
import javax.swing.JTextArea;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DemoTest {
    Pelaaja hero= new Pelaaja();
    JButton a = new JButton();
    JButton s = new JButton();
    JButton d = new JButton();
    JTextArea teksti = new JTextArea();
    Demo testi = new Demo(hero,a,s,d,teksti);
    
    public DemoTest() {
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
    public void arvotAsettuvatOikein() {
        assertEquals(10, testi.getHero().getMaxHp());
        
    }
    
     
}
