
package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassaPaateTest {
    Maksukortti kortti;
    Maksukortti koyha;
    Kassapaate kassa;
    @Before
    public void setUp(){
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
        koyha = new Maksukortti(100);
    }
    @Test
    public void oikeaMaaraRahaaAlussa(){
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void oikeaMaaraEdullisiaAluksi(){
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void oikeaMaaraMaukkaitaAluksi(){
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiKasvattaaKassaa(){
        kassa.syoEdullisesti(240);
        System.out.println(kassa.kassassaRahaa());
        assertEquals(100240, kassa.kassassaRahaa());
    }
    @Test
    public void syoMaukkaastiKasvattaaKassaa(){
        kassa.syoMaukkaasti(400);
        System.out.println(kassa.kassassaRahaa());
        assertEquals(100400, kassa.kassassaRahaa());
    }
    @Test
    public void syoEdullisestiPalauttaOikein(){
        int a = kassa.syoEdullisesti(340);
        assertEquals(100, a);
    }
    @Test
    public void syoMaukkaastiPalauttaaOikein(){
        int a = kassa.syoMaukkaasti(500);
        assertEquals(100, a);
    }
    @Test
    public void syoMaukkaastiMaaraKasvaa(){
        kassa.syoMaukkaasti(400);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiMaaraKasvaa(){
        kassa.syoEdullisesti(2400);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiPalauttaaJosEiRahaa(){
        assertEquals(200, kassa.syoEdullisesti(200));
    }
    @Test
    public void syoMaukkaastiPalauttaaJosEiRahaa(){
        assertEquals(200, kassa.syoMaukkaasti(200));
    }
    @Test
    public void syoEdullisestiEiKasvataSaldoa(){
        kassa.syoEdullisesti(200);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void syoMaukkastiEiKasvataSaldoa(){
        kassa.syoMaukkaasti(200);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void syoMaukkaastiVeloittaaKorttia(){
        kassa.syoMaukkaasti(kortti);
        assertEquals("saldo: 6.0", kortti.toString());
    }
    @Test
    public void syoEdullisestiVeloittaaKorttia(){
        kassa.syoEdullisesti(kortti);
        assertEquals("saldo: 7.60", kortti.toString());
    }
    @Test
    public void syoEdullisestiPalauttaaTrue(){
        assertTrue(kassa.syoEdullisesti(kortti));
    }
    @Test
    public void syoMaukkastiPalauttaTrue(){
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    @Test
    public void syoMaukkaastiKasvaaKortilla(){
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiKasvaaKortila(){
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiPalauttaaFalse(){
        assertTrue(!kassa.syoEdullisesti(koyha));
    }
    @Test
    public void syoMaukkastiPalauttaFalse(){
        assertTrue(!kassa.syoMaukkaasti(koyha));
    }
    @Test
    public void syoMaukkaastiEiKasvaKortilla(){
        kassa.syoMaukkaasti(koyha);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiEiKasvaKortilla(){
        kassa.syoEdullisesti(koyha);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiEiMuutaKorttia(){
        kassa.syoEdullisesti(koyha);
        assertEquals("saldo: 1.0", koyha.toString());
    }
    @Test
    public void syoMaukkaastiEiMuutaKorttia(){
        kassa.syoMaukkaasti(koyha);
        assertEquals("saldo: 1.0", koyha.toString());
    }
    @Test
    public void korttiEiKasvataMaukkaidenMaaraa(){
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void korttiEiKasvataEdullistenMaaraa(){
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void kortinSaldoKasvaa(){
        kassa.lataaRahaaKortille(koyha, 200);
        assertEquals("saldo: 3.0", koyha.toString());
    }
    @Test
    public void kassaKasvaa(){
        kassa.lataaRahaaKortille(koyha, 200);
        assertEquals(100200, kassa.kassassaRahaa());
    }
    @Test
    public void kortinSaldoEiKasvaNegatiivisella(){
        kassa.lataaRahaaKortille(koyha, -100);
        assertEquals("saldo: 1.0", koyha.toString());
    }
    @Test
    public void kassaEikasvaNegatiivisella(){
        kassa.lataaRahaaKortille(koyha, -100);
        assertEquals(100000, kassa.kassassaRahaa());
    }
}
