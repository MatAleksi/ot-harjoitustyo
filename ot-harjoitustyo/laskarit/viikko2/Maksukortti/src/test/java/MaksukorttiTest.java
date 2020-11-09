

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }

    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {
        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }   

    @Test
    public void kortinSaldoEiYlitaMaksimiarvoa() {
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }    
    @Test
    public void syoMaukkaastiEiVieSaldoaNegatiiviseksi(){
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
        
    }
    @Test
    public void negatiivistEiVoiLadata(){
        kortti.lataaRahaa(-2);
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    @Test
    public void voiSyodaMaukkaanKunSenVerranRahaa(){
        Maksukortti m = new Maksukortti(4);
        m.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 0.0 euroa", m.toString());
    }
    @Test
    public void voiSyodaEdullisenKunSenVerranRahaa(){
        Maksukortti e = new Maksukortti(2.5);
        e.syoEdullisesti();
        assertEquals("Kortilla on rahaa 0.0 euroa", e.toString());
    }
}
