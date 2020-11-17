
package com.mycompany.casinogame;


public class Player {
    
    private int bank;
    
    public Player(){
        bank = 10000;
    }
    
    public int bet(int bet){
        if(bank<bet){
            return 0;
        }
        bank -= bet;
        return bet;
    }
    public void win(int winnings){
        bank += winnings;
    }
    
    public int getBank(){
        return this.bank;
    }
}
