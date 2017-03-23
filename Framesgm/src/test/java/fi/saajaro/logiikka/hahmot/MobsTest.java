
package fi.saajaro.logiikka.hahmot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MobsTest {
    
    public MobsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //Mobs mob = new Mobs("powercreep", 10, 1, 0,1,1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void toStringAntaaOikeatArvot(){
        Mobs mob = new Mobs("powercreep", 10, 1, 2,3,4);
        assertEquals("Max hp " + "10" +" current health " + "10" + " damage " + "1" +
        " critical " + "2" + " dodge " + "3" + " xp " + "4",mob.toString());
    }
    
    @Test
    public void attackVaurioittaaOikein(){
        Mobs mob = new Mobs("powercreep", 10, 1, 0,2,3);
        assertEquals(1,mob.attack());
    }
    
    @Test
    public void takeDamageMuuttaCurrentHealthOikein(){
        Mobs mob = new Mobs("powercreep", 10, 1, 2,3,4);
        mob.takeDamage(1);
        assertEquals("Max hp " + "10" +" current health " + "9" + " damage " + "1" +
        " critical " + "2" + " dodge " + "3" + " xp " + "4",mob.toString());
    }
    
    @Test
    public void kriittinenIskuTekeeKaksinkertaisenVaurion(){
        Mobs mob = new Mobs("powercreep", 10, 2, 260,2,3);
        assertEquals(4, mob.attack());
    }
   
}
