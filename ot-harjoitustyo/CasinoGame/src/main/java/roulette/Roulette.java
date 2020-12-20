package roulette;

import player.Player;
import java.util.ArrayList;
import java.util.Random;


public class Roulette {
    
    private Player player;
    
    private int betsEven;
    private int betsOdd;
    private int betsRed;
    private int betsBlack;
    private int bets1to18;
    private int bets19to36;
    private int[] betsNumbers;
    
    private ArrayList<Integer> redNumbers;
    
    public Roulette(Player player){
        this.player = player;
        this.redNumbers = new ArrayList<>();
        redNumbers.add(1);redNumbers.add(3);redNumbers.add(5);redNumbers.add(7);redNumbers.add(9);redNumbers.add(12);
        redNumbers.add(14);redNumbers.add(16);redNumbers.add(18);redNumbers.add(19);redNumbers.add(21);redNumbers.add(23);
        redNumbers.add(25);redNumbers.add(27);redNumbers.add(30);redNumbers.add(32);redNumbers.add(34);redNumbers.add(36);
        betsNumbers = new int[37];
        for(int i = 0;i<37;i++){
            betsNumbers[i] = 0;
        }
    }
    public void clearBets(){
        this.betsEven = 0;
        this.betsOdd = 0;
        this.betsRed = 0;
        this.betsBlack = 0;
        this.bets1to18= 0;
        this.bets19to36 = 0;
        for(int i = 0;i<37;i++){
            betsNumbers[i]=0;
        }
    }
    
    public void betEven(int bet){
        betsEven += player.bet(bet);
    }
    public void betOdd(int bet){
        betsOdd += player.bet(bet);
    }
    public void betRed(int bet){
        betsRed += player.bet(bet);
    }
    public void betBlack(int bet){
        betsBlack += player.bet(bet);
    }
    public void bet1to18(int bet){
        bets1to18 += player.bet(bet);
    }
    public void bet19to36(int bet){
        bets19to36 += player.bet(bet);
    }
    public void betNumber(int number, int bet){
        betsNumbers[number] += player.bet(bet);
    }
    public int spin(){
        Random random = new Random();
        int result = random.nextInt(37);
        player.win(betsNumbers[result] * 35);
        if(result != 0){
            if(result < 19){
                player.win(bets1to18 * 2);
            }else{
                player.win(bets19to36 * 2);
            }
            if((result % 2) == 0){
                player.win(betsEven * 2);
            }else{
                player.win(betsOdd * 2);
            }
            if(redNumbers.contains(result)){
                player.win(betsRed * 2);
            }else{
                player.win(betsBlack * 2);
            }
        }
        clearBets();
        return result;
        
        
    }
    public int getBlackBets(){
        return this.betsBlack;
    }
    public int getRedBets(){
        return this.betsRed;
    }
    public int getEvenBets(){
        return this.betsEven;
    }
    public int getOddBets(){
        return this.betsOdd;
    }
    public int get19to36Bets(){
        return this.bets19to36;
    }
    public int get1to18Bets(){
        return this.bets1to18;
    }
    public int getNumberBet(int number){
        return this.betsNumbers[number];
    }
}
