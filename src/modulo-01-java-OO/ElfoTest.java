import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class ElfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoTest
{
    @Test
    public void ElfoNasceComNomeInformado(){
       // Arrange
       String esperado = "Legolas";
       // Act
       Elfo elfo = new Elfo(esperado); //Por que tem um "esperado" aqui?
       // Assert
       assertEquals(esperado, elfo.getNome());
        
    }
    
    @Test
    public void ElfoNasceComNomeVazio(){
        String nomeEsperado = "";
        Elfo elfo = new Elfo (nomeEsperado);
        assertEquals(nomeEsperado, elfo.getNome());
    }
    
    @Test
    public void ElfoNasceComNomeNulo(){
        String nomeEsperado = null;
        Elfo elfo = new Elfo (nomeEsperado);
        assertEquals(nomeEsperado, elfo.getNome());
    }
    
    @Test
    public void ElfoNasceComNumeroDeFlechasPadrao(){
        int esperado = 42;
        Elfo elfo = new Elfo ("um nome");
        assertEquals(esperado, elfo.getFlechas());
    }
    
    @Test 
    public void ElfoNasceComNomeENumeroDeFlechasInformados(){
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        Elfo elfo = new Elfo (nomeEsperado, flechasEsperadas);
        
        assertEquals (nomeEsperado, elfo.getNome());
        assertEquals (flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEFlechasNegativasInformados(){
        String nomeEsperado = "Robin";
        int flechasEsperadas = - 5896;
        Elfo elfo = new Elfo (nomeEsperado, flechasEsperadas);
        
        assertEquals (nomeEsperado, elfo.getNome());
        assertEquals (flechasEsperadas, elfo.getFlechas());
    }
    
     @Test
    public void elfoAtiraFlechaEmUmOrc(){
        Elfo elfo = new Elfo ("Legolas");
        Orc orc = new Orc ();
        
        elfo.atirarFlecha(orc);
        
        int experienciaEsperada = 1;
        int flechasEsperadas = 41;
        
        assertEquals (experienciaEsperada, elfo.getExperiencia());
        assertEquals (flechasEsperadas, elfo.getFlechas());
    }
    
    @Test 
    public void elfoAtiraFlechaDuasVezesNoMesmoOrc(){
        Elfo elfo = new Elfo ("Legolas");
        Orc orc = new Orc ();
        
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        
        int experienciaEsperada = 2 ;
        int flechasEsperadas = 40;
        
        assertEquals (experienciaEsperada, elfo.getExperiencia());
        assertEquals (flechasEsperadas, elfo.getFlechas());
    }
    
    @Test 
    public void elfoAtirarFlechasSeteVezesNoMesmoOrc(){
        Elfo elfo = new Elfo ("Legolas", 5);
        Orc orc = new Orc();
        
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        
        int expecienciaEsperada = 7;
        int flechasEsperadas = -2;
        
        assertEquals(expecienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test 
    public void elfoToStringPadrao(){ // dar uma olhada aqui!
        Elfo elfo = new Elfo ("Legolas");
        String esperado = "Legolas possui 42 flechas e 0 níveis de experiência.";
        String obtido = elfo.toString();
        assertEquals(esperado, obtido);
    }
}