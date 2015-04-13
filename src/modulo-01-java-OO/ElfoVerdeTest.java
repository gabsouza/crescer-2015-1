import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class ElfoVerdeTest.
 *
 * @author  Gabriela de Souza
 */
public class ElfoVerdeTest{
    
    @Test
    public void ElfoNasceComNomeInformado(){
       // Arrange
       String esperado = "Legolas";
       // Act
       ElfoVerde elfoVerde = new ElfoVerde(esperado);
       // Assert
       assertEquals(esperado, elfoVerde.getNome());
        
    }
    
    @Test
    public void ElfoNasceComNomeVazio(){
        String nomeEsperado = "";
        ElfoVerde elfoVerde = new ElfoVerde (nomeEsperado);
        assertEquals(nomeEsperado, elfoVerde.getNome());
    }
    
    @Test
    public void ElfoNasceComNomeNulo(){
        String nomeEsperado = null;
        ElfoVerde elfoVerde = new ElfoVerde (nomeEsperado);
        assertEquals(nomeEsperado, elfoVerde.getNome());
    }
    
    @Test
    public void ElfoNasceComNumeroDeFlechasPadrao(){
        int esperado = 42;
        ElfoVerde elfoVerde = new ElfoVerde ("um nome");
        assertEquals(esperado, elfoVerde.getFlechas());
    }
    
    @Test 
    public void ElfoNasceComNomeENumeroDeFlechasInformados(){
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        ElfoVerde elfoVerde = new ElfoVerde (nomeEsperado, flechasEsperadas);
        
        assertEquals (nomeEsperado, elfoVerde.getNome());
        assertEquals (flechasEsperadas, elfoVerde.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEFlechasNegativasInformados(){
        String nomeEsperado = "Robin";
        int flechasEsperadas = - 5896;
        ElfoVerde elfoVerde = new ElfoVerde (nomeEsperado, flechasEsperadas);
        
        assertEquals (nomeEsperado, elfoVerde.getNome());
        assertEquals (flechasEsperadas, elfoVerde.getFlechas());
    }
    
     @Test
    public void elfoAtiraFlechaEmUmOrc(){
        ElfoVerde elfoVerde = new ElfoVerde ("Legolas");
        Orc orc = new Orc ();
        
        elfoVerde.atirarFlecha(orc);
        
        int experienciaEsperada = 2;
        int flechasEsperadas = 41;
        
        assertEquals (experienciaEsperada, elfoVerde.getExperiencia());
        assertEquals (flechasEsperadas, elfoVerde.getFlechas());
    }
    
    @Test 
    public void elfoAtiraFlechaDuasVezesNoMesmoOrc(){
        ElfoVerde elfoVerde = new ElfoVerde ("Legolas");
        Orc orc = new Orc ();
        
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        
        int experienciaEsperada = 4 ;
        int flechasEsperadas = 40;
        
        assertEquals (experienciaEsperada, elfoVerde.getExperiencia());
        assertEquals (flechasEsperadas, elfoVerde.getFlechas());
    }
    
    @Test 
    public void elfoAtirarFlechasSeteVezesNoMesmoOrc(){
        ElfoVerde elfoVerde = new ElfoVerde ("Legolas", 5);
        Orc orc = new Orc();
        
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        elfoVerde.atirarFlecha(orc);
        
        int expecienciaEsperada = 14;
        int flechasEsperadas = -2;
        
        assertEquals(expecienciaEsperada, elfoVerde.getExperiencia());
        assertEquals(flechasEsperadas, elfoVerde.getFlechas());
    }
    
    @Test 
    public void elfoToStringPadrao(){ // dar uma olhada aqui!
        ElfoVerde elfoVerde = new ElfoVerde ("Legolas");
        String esperado = "Legolas possui 42 flechas e 0 níveis de experiência.";
        String obtido = elfoVerde.toString();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void adicionandoEspadaNoInventario() {
        ElfoVerde elfoVerde = new ElfoVerde("Legolas");
        ItemDoInventario espada = new ItemDoInventario(34, "Espada de aço valiriano");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(espada);
        
        elfoVerde.adicionarItem(espada);
        ArrayList<ItemDoInventario> inventarioObtido = elfoVerde.getItens();
       
        assertEquals(inventarioEsperado, inventarioObtido);
        assertEquals(inventarioEsperado.get(0), inventarioObtido.get(0));
    }
    
    @Test
    public void adicionandoArcoVidroInventario() {
        ElfoVerde elfoVerde = new ElfoVerde("Legolas");
        ItemDoInventario arcoVidro = new ItemDoInventario(4, "Arco e Flecha de vidro");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(arcoVidro);
        
        elfoVerde.adicionarItem(arcoVidro);
        ArrayList<ItemDoInventario> inventarioObtido = elfoVerde.getItens();
       
        assertEquals(inventarioEsperado, inventarioObtido);
        assertEquals(inventarioEsperado.get(0), inventarioObtido.get(0));
    }
   
    @Test
    public void adicionandoEspadaEAgadaInventario() {
        ElfoVerde elfoVerde = new ElfoVerde("Legolas");
        ItemDoInventario adaga  = new ItemDoInventario(3, "Adaga");
        ItemDoInventario espada  = new ItemDoInventario(6, "Espada de aço valiriano");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ArrayList<ItemDoInventario> inventarioObtido = elfoVerde.getItens();
        elfoVerde.adicionarItem(adaga);
        elfoVerde.adicionarItem(espada);
        
        inventarioEsperado.add(espada);
        
       
        assertEquals(inventarioEsperado, inventarioObtido);
        assertEquals(inventarioEsperado.get(0), inventarioObtido.get(0));
    }
    
    @Test
    public void adicionandoArcoVidroEAgadaInventario() {
        ElfoVerde elfoVerde = new ElfoVerde("Legolas");
        ItemDoInventario adaga  = new ItemDoInventario(61, "Adaga");
        ItemDoInventario arcoVidro  = new ItemDoInventario(65, "Arco e Flecha de vidro");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        ArrayList<ItemDoInventario> inventarioObtido = elfoVerde.getItens();
        elfoVerde.adicionarItem(adaga);
        elfoVerde.adicionarItem(arcoVidro);
        
        inventarioEsperado.add(arcoVidro);
        
       
        assertEquals(inventarioEsperado, inventarioObtido);
        assertEquals(inventarioEsperado.get(0), inventarioObtido.get(0));
    }
}