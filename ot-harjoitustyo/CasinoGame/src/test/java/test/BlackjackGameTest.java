
package test;

import player.Player;
import blackjack.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BlackjackGameTest {
    
    private Player player;
    private BlackjackGame blackjackgame;
    
    @Before
    public void setUp(){
        player = new Player();
        blackjackgame = new BlackjackGame(player);
    }
    @Test
    public void playerLossReturnsTrueAtOver21(){
        for(int i = 0; i < 20; i++){
            blackjackgame.playerHit();
        }
        assertTrue(blackjackgame.hasPlayerLost());
    }
    @Test
    public void playerNoLossBelow21(){
        blackjackgame.playerHit();
        blackjackgame.playerHit();
        assertTrue(!blackjackgame.hasPlayerLost());
    }
    @Test
    public void playerStandsWithAceHigherGetsPickedIfUnder21(){
        int ifAceIs1 = 0;
        for(int i = 0; i < 1000; i++){
            blackjackgame.playerHit();
            blackjackgame.playerHit();
            if(blackjackgame.playerHand().length == 2){
                ifAceIs1 = blackjackgame.playerHand()[0];
                break;
            }
            //clears table
            blackjackgame.winner();
        }
        blackjackgame.playerStand();
        assertEquals(blackjackgame.playerHand()[0], ifAceIs1 + 10);
    }
    @Test
    public void playerStandsWithAceLoweGetsPickedIfOver21(){
        int ifAceIs11 = 0;
        for(int i = 0; i < 1000; i++){
            blackjackgame.playerHit();
            blackjackgame.playerHit();
            blackjackgame.playerHit();
            if(blackjackgame.playerHand().length == 2){
                if(blackjackgame.playerHand()[1] > 21){
                    ifAceIs11 = blackjackgame.playerHand()[1];
                    break;
                }
            }
            blackjackgame.winner();
        }
        blackjackgame.playerStand();
        assertEquals(blackjackgame.playerHand()[0], ifAceIs11 - 10);
    }
}
