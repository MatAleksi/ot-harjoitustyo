
package com.mycompany.casinogame;

public class Main {
    
    public static void main(String args[]){
        Player p = new Player();
        Roulette r = new Roulette(p);
        r.betEven(6000);
        System.out.println(p.getBank());
        r.spin();
        System.out.println(p.getBank());
        r.betNumber(0, 3000);
        r.spin();
        System.out.println(p.getBank());
    }
    
}
