
package test;

import player.Player;
import blackjack.BlackJack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BlackJackTest {
    
    private Player player;
    private BlackJack blackjack;
    
    @Before
    public void setUp(){
        player = new Player();
        blackjack = new BlackJack(player);
    }
    @Test
    public void betWorks(){
        blackjack.bet(100);
        assertEquals(blackjack.getBet(), 100);
    }
    @Test
    public void betWontWorkIfNoBank(){
        blackjack.bet(10001);
        assertEquals(blackjack.getBet(), 0);
    }
    @Test
    public void playerAceIsRemembered(){
        for(int i = 0; i < 1000; i++){
            blackjack.dealPlayer();
            if(blackjack.playerHand() == 1){
                break;
            }
            blackjack.clearTable();
        }
        assertTrue(blackjack.doesPlayerHaveAce());
    }
    @Test
    public void dealerAceIsRemembered(){
        for(int i = 0; i < 1000; i++){
            blackjack.dealDealer();
            if(blackjack.dealerHand() == 1){
                break;
            }
            blackjack.clearTable();
        }
        assertTrue(blackjack.doesDealerHaveAce());
    }
    @Test
    public void playerAceTurnedTo11Works(){
        for(int i = 0; i < 1000; i++){
            blackjack.dealPlayer();
            if(blackjack.playerHand() == 1){
                break;
            }
            blackjack.clearTable();
        }
        blackjack.ace11Player();
        assertEquals(11, blackjack.playerHand());
    }
    @Test
    public void dealerAceTurnedTo11Works(){
        for(int i = 0; i < 1000; i++){
            blackjack.dealDealer();
            if(blackjack.dealerHand() == 1){
                break;
            }
            blackjack.clearTable();
        }
        blackjack.ace11Dealer();
        assertEquals(11, blackjack.dealerHand());
    }
    
}
