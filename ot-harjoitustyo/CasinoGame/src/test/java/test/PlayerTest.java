
package test;

import player.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {
    
    Player player;
    @Before
    public void setUp(){
        player = new Player();
    }
    
    @Test
    public void playerStartsWithCorrectBank(){
        assertEquals(10000, player.getBank());
    }
    
    @Test
    public void winWorks(){
        player.win(1000);
        assertEquals(11000, player.getBank());
    }
    
    @Test
    public void betDoesntTakeFromBankWhenBetBiggerThanBank(){
        player.bet(10001);
        assertEquals(10000, player.getBank());
    }
    
    @Test
    public void betReturnsZeroWhenBetBiggerThanBank(){
        int i = player.bet(10001);
        assertEquals(i, 0);
    }
    
    @Test
    public void betReturnsCorrect(){
        int i = player.bet(2000);
        assertEquals(i, 2000);
    } 
    
    @Test
    public void betDecreasesBankCorrectly(){
        player.bet(2000);
        assertEquals(8000, player.getBank());
    }
}
