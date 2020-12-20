
package blackjack;

import player.Player;
import java.util.Random;


public class BlackJack {
    
    private Player player;
    private int bet;
    private int playerHand;
    private int dealerHand;
    private boolean playerHasAce;
    private boolean dealerHasAce;
    private boolean playerBlackJack;
    private boolean dealerBlackJack;
    
    public BlackJack(Player player){
        this.player = player;
        this.bet = 0;
        this.playerHand = 0;
        this.dealerHand = 0;
        this.playerHasAce = false;
        this.dealerHasAce = false;
        this.playerBlackJack = false;
        this.dealerBlackJack = false;
    }
    
    public void bet(int betAmount){
        bet =+ player.bet(betAmount);
    }
    public int getBet(){
        return bet;
    }
    
    public void dealPlayer(){
        Random random = new Random();
        int card = random.nextInt(13)+1;
        if(card > 10){
            card = 10;
        }
        playerHand = playerHand + card;
        if(card == 1){
            playerHasAce = true;
        }
    }
    public void dealDealer(){
        Random random = new Random();
        int card = random.nextInt(13)+1;
        if(card > 10){
            card = 10;
        }
        dealerHand = dealerHand + card;
        if(card == 1){
            dealerHasAce = true;
        }
    }
    public int playerHand(){
        return playerHand;
    }
    public int dealerHand(){
        return dealerHand;
    }
    public void setBlackJack(){
        playerBlackJack = true;
    }
    public boolean doesPlayerHaveBlackJack(){
        return playerBlackJack;
    }
    public void setDealerBlackJack(){
        dealerBlackJack = true;
    }
    public boolean doesDealererHaveBlackJack(){
        return dealerBlackJack;
    }
    public boolean doesPlayerHaveAce(){
        return playerHasAce;
    }
    public boolean doesDealerHaveAce(){
        return dealerHasAce;
    }
    public void doubleBet(){
        bet(this.bet);
    }
    public void playerWin(){
        player.win(bet*2);
        this.bet = 0;
        this.playerHand = 0;
        this.dealerHand = 0;
        this.playerHasAce = false;
        this.dealerHasAce = false;
        this.playerBlackJack = false;
        this.dealerBlackJack = false;
    }
    public void playerWinBlackJack(){
        //Should be 2.5 according to rules but it's 3 for now
        player.win(bet*3);
        this.bet = 0;
        this.playerHand = 0;
        this.dealerHand = 0;
        this.playerHasAce = false;
        this.dealerHasAce = false;
        this.playerBlackJack = false;
        this.dealerBlackJack = false;
    }
    public void playerLose(){
        bet = 0;
        this.bet = 0;
        this.playerHand = 0;
        this.dealerHand = 0;
        this.playerHasAce = false;
        this.dealerHasAce = false;
        this.playerBlackJack = false;
        this.dealerBlackJack = false;
    }
    public void tie(){
        player.win(bet);
        this.bet = 0;
        this.playerHand = 0;
        this.dealerHand = 0;
        this.playerHasAce = false;
        this.dealerHasAce = false;
        this.playerBlackJack = false;
        this.dealerBlackJack = false;
    }
    public void ace11Player(){
        playerHand = playerHand+10;
        playerHasAce = false;
    }
    public void ace11Dealer(){
        dealerHand = dealerHand+10;
        dealerHasAce = false;
    }
}
