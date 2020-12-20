
package com.mycompany.casinogame;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import player.Player;
import roulette.Roulette;


public class RouletteTest {
    
    private Player player;
    private Roulette roulette;
    
    @Before
    public void setUp(){
        player = new Player();
        roulette = new Roulette(player);
    }
    
    @Test
    public void betEvenWorks(){
        roulette.betEven(100);
        assertEquals(roulette.getEvenBets(), 100);
    }
    @Test
    public void betEvenWontBetIfNoBank(){
        roulette.betEven(10001);
        assertEquals(roulette.getEvenBets(), 0);
    }
    @Test
    public void betOddWorks(){
        roulette.betOdd(100);
        assertEquals(roulette.getOddBets(), 100);
    }
    @Test
    public void betOddWontBetIfNoBank(){
        roulette.betOdd(10001);
        assertEquals(roulette.getOddBets(), 0);
    }
    @Test
    public void betBlackWorks(){
        roulette.betBlack(100);
        assertEquals(roulette.getBlackBets(), 100);
    }
    @Test
    public void betRedWontBetIfNoBank(){
        roulette.betRed(10001);
        assertEquals(roulette.getRedBets(), 0);
    }
    @Test
    public void bet1to18Works(){
        roulette.bet1to18(100);
        assertEquals(roulette.get1to18Bets(), 100);
    }
    @Test
    public void bet1to18WontBetIfNoBank(){
        roulette.bet1to18(10001);
        assertEquals(roulette.get1to18Bets(), 0);
    }
    @Test
    public void bet19to36Works(){
        roulette.bet19to36(100);
        assertEquals(roulette.get19to36Bets(), 100);
    }
    @Test
    public void bet19to36WontBetIfNoBank(){
        roulette.bet19to36(10001);
        assertEquals(roulette.get19to36Bets(), 0);
    }
    @Test
    public void betNumbersWorks(){
        for(int i = 0; i<37; i++){
            roulette.betNumber(i, 100);
        }
        int totalbets = 0;
        for(int i = 0; i<37; i++){
            if(roulette.getNumberBet(i) != 0){
                totalbets += roulette.getNumberBet(i);
            }
        }
        assertEquals(3700, totalbets);
    }
    @Test
    public void betNumbersWontBetIfNoBank(){
        for(int i = 0; i<37; i++){
            roulette.betNumber(i, 10001);
        }
        int totalbets = 0;
        for(int i = 0; i<37; i++){
            if(roulette.getNumberBet(i) != 0){
                totalbets += roulette.getNumberBet(i);
            }
        }
        assertEquals(0, totalbets);
    }
}
