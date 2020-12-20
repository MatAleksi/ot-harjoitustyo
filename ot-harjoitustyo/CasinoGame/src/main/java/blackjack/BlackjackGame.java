
package blackjack;
import player.Player;

public class BlackjackGame {
    
    private BlackJack blackjack;
    
    public BlackjackGame(Player player){
        this.blackjack = new BlackJack(player);
    }
    public void bet(int bet){
        blackjack.bet(bet);
    }
    public int getBet(){
        return blackjack.getBet();
    }
    public void start(){
        blackjack.dealPlayer();
        blackjack.dealDealer();
        blackjack.dealPlayer();
        if(blackjack.playerHand() == 11 && blackjack.doesPlayerHaveAce()){
            blackjack.setBlackJack();
            blackjack.ace11Player();
        }
    }
    public int[] playerHand(){
        if(blackjack.doesPlayerHaveAce()){
            int[] hand = new int[2];
            hand[0] = blackjack.playerHand();
            hand[1] = blackjack.playerHand()+10;
            return hand;
        }
        int[] hand = new int[1];
        hand[0] = blackjack.playerHand();
        return hand;
    }
    public int dealerHand(){
        return blackjack.dealerHand();
    }
    public boolean hasPlayerLost(){
        if(blackjack.playerHand()>21){
            return true;
        }
        return false;
    }
    public void playerHit(){
        blackjack.dealPlayer();
    }
    public void playerDouble(){
        blackjack.doubleBet();
        blackjack.dealPlayer();
    }
    public void playerStand(){
        if(blackjack.doesPlayerHaveAce()){
            if(blackjack.playerHand()+10 < 22){
                blackjack.ace11Player();
            }
        }
        blackjack.dealDealer();
        if(blackjack.dealerHand() == 11 && blackjack.doesDealerHaveAce()){
            blackjack.ace11Dealer();
            blackjack.doesDealererHaveBlackJack();
        }
        while(true){
            if(!blackjack.doesDealerHaveAce()){
                if(blackjack.dealerHand()>16){
                    break;
                }
                if(blackjack.dealerHand() == 16 && blackjack.dealerHand()> blackjack.playerHand()){
                    break;
                }
            }else{
                if(blackjack.dealerHand() > 16){
                    break;
                }
                if(blackjack.dealerHand()+10 < 22 && blackjack.dealerHand()+10 > 15 && blackjack.dealerHand()+10 > blackjack.playerHand()){
                    blackjack.ace11Dealer();
                    break;
                }
                if(blackjack.dealerHand() == 21 || blackjack.dealerHand()+10 == 21){
                    if(blackjack.dealerHand()+10 ==21){
                        blackjack.ace11Dealer();
                    }
                    break;
                }
            }
            blackjack.dealDealer();
        }
    }
    public int winner(){
        //return 0 for tie
        //return 1 for player win
        //return 2 for dealer win
        //return 3 for player blackjack win
        if(blackjack.playerHand()>21 && blackjack.dealerHand()>21){
            blackjack.tie();
            return 0;
        }
        if(blackjack.doesPlayerHaveBlackJack() && blackjack.doesDealererHaveBlackJack()){
            blackjack.tie();
            return 0;
        }
        if(blackjack.doesDealererHaveBlackJack() && !blackjack.doesPlayerHaveBlackJack()){
            blackjack.playerLose();
            return 2;
        }
        if(blackjack.doesPlayerHaveBlackJack() && !blackjack.doesDealererHaveBlackJack()){
            blackjack.playerWinBlackJack();
            return 3;
        }
        if(blackjack.playerHand() == blackjack.dealerHand()){
            blackjack.tie();
            return 0;
        }
        if(blackjack.playerHand() > 21 && blackjack.dealerHand() < 22){
            blackjack.playerLose();
            return 2;
        }
        if(blackjack.playerHand() < 22 && blackjack.dealerHand() > 21){
            blackjack.playerWin();
            return 1;
        }
        if(blackjack.playerHand() > blackjack.dealerHand()){
            blackjack.playerWin();
            return 1;
        }else{
            blackjack.playerLose();
            return 2;
        }
    }
    
}
