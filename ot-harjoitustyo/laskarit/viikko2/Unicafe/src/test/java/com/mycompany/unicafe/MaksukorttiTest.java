package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void kortinSaldoAlussaOikein(){
        assertEquals("saldo: 0.10", kortti.toString());
    }
    @Test
    public void lataaminenKasvataaSaldoaOikein(){
        kortti.lataaRahaa(100);
        assertEquals("saldo: 1.10", kortti.toString());
    }
    @Test
    public void saldoVaheneeOikein(){
        kortti.lataaRahaa(1000);
        kortti.otaRahaa(510);
        assertEquals("saldo: 5.0", kortti.toString());
    }
    @Test
    public void saldoEiVaheneJosEiRahaa(){
        kortti.otaRahaa(100);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    @Test
    public void palauttaaTruejosRahatRiittavat(){
        boolean bol = kortti.otaRahaa(5);
        assertTrue(bol);
    }
    @Test
    public void palauttaaFalsejosRahatEivatRiita(){
        boolean bol = kortti.otaRahaa(20);
        assertTrue(!bol);
    }
    
}
