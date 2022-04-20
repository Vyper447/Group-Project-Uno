package wargame;

import org.junit.Test;
import static org.junit.Assert.*;

public class WarTest {

    public WarTest() {
    }

    @Test
    public void testPlayerScoreGood() {
        System.out.println("checkPlayerScoreGood");
        int pass = 20;
        boolean expResult = true;
        boolean result = Player.setScore(int);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPlayerScoreBad() {
        System.out.println("checkPlayerScoreBad");
        int pass = 0;
        boolean expResult = false;
        boolean result = Player.setScore(int);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPlayerScoreBoundary() {
        System.out.println("checkPlayerScoreBoundary");
        int pass = 15;
        boolean expResult = true;
        boolean result = Player.setScore(pass);
        assertEquals(expResult, result);
    }
    

}
