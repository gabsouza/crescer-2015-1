import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * A classe de teste OrcTest.
 *
 * @author  Gabriela de Souza
 */
public class OrcTest
{
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceVivo() {
        Orc umOrc;
        umOrc = new Orc();
       
        Status esperado = Status.VIVO;
        Status obtido = umOrc.getStatus();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void orcRecebeAtaqueUmaVez() {
        Orc umOrc = new Orc("Urukhai");
        
        umOrc.recebeAtaque();
        
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        Orc umOrc = new Orc("Comur");
       
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
       
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        Orc umOrc = new Orc("Comur");
        
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcFicaFeridoAoReceberAtaque() {
        Orc umOrc = new Orc("Comur");

        umOrc.recebeAtaque();
        
        Status esperado = Status.FERIDO;
        Status resultadoObtido = umOrc.getStatus();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        Orc umOrc = new Orc("Urukhai");

        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        
        int esperado = 0;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        Orc orc = new Orc();
        
        String resultadoObtido = orc.toString();
        
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberAtaque() {

        Orc orc = new Orc("Comur");

        orc.recebeAtaque();
        String resultadoObtido = orc.toString();

        String esperado = "Vida atual: 100";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        Orc umOrc = new Orc("Comur");
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        
        String esperado = "Vida atual: 0";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeInformado() {
        Orc umOrc;
        String esperado = "Comur";
        umOrc = new Orc(esperado);
    
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeVazioInformado() {
        
        Orc umOrc;
        String esperado = "";   
        
        umOrc = new Orc(esperado);
    
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeNuloInformado() {
        Orc umOrc;
        String esperado = null; 

        umOrc = new Orc(esperado);
        
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcMorreAposDozeFlechadas() {
        Orc umOrc = new Orc("Comur");
        Status esperado = Status.MORTO;
        
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        Status resultadoObtido = umOrc.getStatus();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoMenorQueZero() {
        Orc orc = new Orc("Comur");
        orc.recebeAtaque();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoEntre0e100() {
        Orc orc = new Orc("Comur"); // para somar 65 ao número gerado
        orc.setExperiencia(1); // ímpar e menor que 2 para poder manter entre 0 e 100
        orc.recebeAtaque();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 1;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueNormal() {
        Orc orc = new Orc("Comur"); // para somar 65 ao número gerado e elevar ao cubo
        orc.recebeAtaque();
        
        int vidaEsperada = 100;
        Status statusEsperado = Status.FERIDO;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(statusEsperado, orc.getStatus());
    }
    
    @Test
    public void quandoAdicionoAdagaAoInventario() {
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);

        urukhai.adicionarItem(adaga);
        ArrayList<ItemDoInventario> inventarioObtido = urukhai.getItens();

        assertEquals(inventarioEsperado, inventarioObtido);
        assertEquals(inventarioEsperado.get(0), inventarioObtido.get(0));
    }

    @Test
    public void quandoAdicionoAdagaEEscudoAoInventario() {
        Orc orc = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ItemDoInventario escudo = new ItemDoInventario(12, "Escudo");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);
        inventarioEsperado.add(escudo);
        
        orc.adicionarItem(adaga);
        orc.adicionarItem(escudo);
        ArrayList<ItemDoInventario> inventarioObtido = orc.getItens();
       
        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void quandoAdicionoAdagaAoInventarioEPercoAdaga() {
        Orc orc = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        orc.adicionarItem(adaga);

        orc.perderItem(adaga);
        ArrayList<ItemDoInventario> inventarioObtido = orc.getItens();

        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void quandoAdicionoAdagaEEscudoAoInventarioEPercoEscudo() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ItemDoInventario escudo = new ItemDoInventario(12, "Escudo");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);
        urukhai.adicionarItem(adaga);
        urukhai.adicionarItem(escudo);
        // Act
        urukhai.perderItem(escudo);
        ArrayList<ItemDoInventario> inventarioObtido = urukhai.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void getDescricoesComNenhumItem() {
        // Arrange
        Orc urukhai = new Orc();
        String descricoesEsperada = "";
        // Act
        String resultadoDescricoes = urukhai.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }
    
    @Test
    public void getDescricoesComUmItem() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        urukhai.adicionarItem(adaga);
        String descricoesEsperada = "Adaga";
        // Act
        String resultadoDescricoes = urukhai.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }
    
    @Test
    public void getDescricoesComDoisItens() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ItemDoInventario escudo = new ItemDoInventario(12, "Escudo de carvalho");
        urukhai.adicionarItem(adaga);
        urukhai.adicionarItem(escudo);
        String descricoesEsperada = "Adaga,Escudo de carvalho";
        // Act
        String resultadoDescricoes = urukhai.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }
    
    @Test
    public void orcTentarSorteAumenta1000UnidadesDosItens() {
        // Arrange
        Orc urukhai = new Orc();
        urukhai.setStatus(Status.DORMINDO);
        urukhai.setExperiencia(3);
        urukhai.adicionarItem(new ItemDoInventario(3, "Poção de mana"));
        urukhai.adicionarItem(new ItemDoInventario(1, "Poção Lança"));
        // Act
        urukhai.tentarSorte();
        // Assert
        ItemDoInventario pocao = urukhai.getItens().get(0);
        ItemDoInventario lanca = urukhai.getItens().get(1);
        assertEquals(1003, pocao.getQuantidade());
        assertEquals(1001, lanca.getQuantidade());
    }
    
    @Test
    public void orcTentarSorteNaoFazNada() {
        // Arrange
        Orc urukhai = new Orc();
        urukhai.adicionarItem(new ItemDoInventario(3, "Poção de mana"));
        urukhai.adicionarItem(new ItemDoInventario(1, "Poção Lança"));
        // Act
        urukhai.tentarSorte();
        // Assert
        ItemDoInventario pocao = urukhai.getItens().get(0);
        ItemDoInventario lanca = urukhai.getItens().get(1);
        assertEquals(3, pocao.getQuantidade());
        assertEquals(1, lanca.getQuantidade());
    }
    
    @Test
    public void getMaiorQuantidadeComNenhumItem() {
        // Arrange
        Orc orc = new Orc();
        ItemDoInventario esperado = null;
        // Act
        ItemDoInventario resultado = orc.getItemComMaiorQuantidade();
        // Assert
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void getMaiorQuantidadeComUmItem() {
        // Arrange
        Orc orc = new Orc();
        ItemDoInventario esperado = new ItemDoInventario(1, "Light Saber");
        orc.adicionarItem(esperado);
        // Act
        ItemDoInventario resultado = orc.getItemComMaiorQuantidade();
        // Assert
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void getMaiorQuantidadeComDoisOuMaisItensComAMesmaQuantidade() {
        // Arrange
        Orc orc = new Orc();
        ItemDoInventario esperado = new ItemDoInventario(0, "Gatorade da Vovó");
        ItemDoInventario duplicado = new ItemDoInventario(0, "Gatorade da Vovó");
        orc.adicionarItem(esperado);
        orc.adicionarItem(duplicado);
        // Act
        ItemDoInventario resultado = orc.getItemComMaiorQuantidade();
        // Assert
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void getMaiorQuantidadeComVariosItensComDiferentesQuantidades() {
        // Arrange
        Orc orc = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(15, "Adaga");
        ItemDoInventario pocao = new ItemDoInventario(2, "Poções");
        ItemDoInventario flecha = new ItemDoInventario(17, "Poções");
        ItemDoInventario pedraPreciosa = new ItemDoInventario(9, "Pedras preciosas");
        ItemDoInventario beyBlade = new ItemDoInventario(18, "BeyBlade");
        orc.adicionarItem(adaga);
        orc.adicionarItem(pocao);
        orc.adicionarItem(flecha);
        orc.adicionarItem(pedraPreciosa);
        orc.adicionarItem(beyBlade);
        // Act
        ItemDoInventario resultado = orc.getItemComMaiorQuantidade();
        // Assert
        assertEquals(beyBlade, resultado);
    }
}









