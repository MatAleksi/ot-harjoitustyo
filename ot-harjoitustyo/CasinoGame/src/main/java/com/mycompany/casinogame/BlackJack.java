
package com.mycompany.casinogame;

import java.util.Random;


public class BlackJack {
    
    private Player player;
    private int bet;
    private int playerHand;
    private int dealerHand;
    private boolean playerHasAce;
    private boolean dealerHasAce;
    
    public BlackJack(Player player){
        this.player = player;
        this.bet = 0;
        this.playerHand = 0;
        this.dealerHand = 0;
        this.playerHasAce = false;
        this.dealerHasAce = false;
    }
    
    public void bet(int betAmount){
        bet = player.bet(betAmount);
    }
    
    public void deal(){
        Random random = new Random();
        int playerCard1 = random.nextInt(13)+1;
        int playerCard2 = random.nextInt(13)+1;
        int dealerCard1 = random.nextInt(13)+1;
        int dealerCard2 = random.nextInt(13)+1;
        if(playerCard1 > 10){
            playerCard1 = 10;
        }
        if(playerCard2 > 10){
            playerCard2 = 10;
        }
        if(dealerCard1 > 10){
            dealerCard1 = 10;
        }
        if(dealerCard2 > 10){
            dealerCard2 = 10;
        }
        if(playerCard1 == 1 || playerCard2 == 1){
            playerHasAce = true;
        }
        if(dealerCard1 == 1 || dealerCard2 == 1){
            dealerHasAce = true;
        }
        playerHand = playerCard1 + playerCard2;
        dealerHand = dealerCard1 + dealerCard2;
        
        if(playerHand == 11 && playerHasAce && !dealerHasAce){
            player.win(bet * 3);
            bet = 0;
        }
    }
    
    public int playerHand(){
        return playerHand;
    }
    public int dealerHand(){
        return dealerHand;
    }
    public void playerDraws(){
        Random random = new Random();
        int card = random.nextInt(13)+1;
        if(card == 1){
            playerHasAce = true;
        }
        if(card >10){
            card = 10;
        }
        playerHand += card;
    }
    public void dealerDraws(){
        Random random = new Random();
        int card = random.nextInt(13)+1;
        if(card == 1){
            dealerHasAce = true;
        }
        if(card > 10){
            card = 10;
        }
        dealerHand += card;
    }
    
}
