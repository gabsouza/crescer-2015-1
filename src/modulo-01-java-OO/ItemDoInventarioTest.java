import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ItemDoInventarioTest.
 *
 * @ Gabriela de Souza
 */
public class ItemDoInventarioTest{
    
    @Test
    public void criarItemComQuantidadeEDescricaoInformadas(){
        int quantidadeEsperada = 14;
        String descricaoEsperada = "Martelo de Thor - Mjollnir";
        ItemDoInventario item = new ItemDoInventario(quantidadeEsperada, descricaoEsperada);
        
        assertEquals (quantidadeEsperada, item.getQuantidade());
        assertEquals (descricaoEsperada, item.getDescricao());
    }
    
    @Test
    public void criarITemComQuantidadeNegativaEDescricaoNula(){
        int quantidadeEsperada = -36;
        String descricaoEsperada = null;
        ItemDoInventario item = new ItemDoInventario (quantidadeEsperada, descricaoEsperada);
        assertEquals(quantidadeEsperada, item.getQuantidade());
        assertEquals(descricaoEsperada, item.getDescricao());
    }
}
