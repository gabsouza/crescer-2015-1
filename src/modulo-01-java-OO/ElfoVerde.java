import java.util.*;

/**
 * Escreva a descrição da classe ElfoVerde aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ElfoVerde extends Elfo{
    
   public ElfoVerde(String umNome, int flechas){
        this(umNome);
        super.flechas = flechas;
   }
    
   public ElfoVerde(String nome){
        super(nome);
   }
   
   public void atirarFlecha(Orc umOrc){
        flechas--;
        experiencia+=2;
        umOrc.recebeAtaque();
   }
   
   protected void adicionarItem(ItemDoInventario item) {
       boolean itensDoElfoVerde = item.getDescricao().equals("Espada de aço valiriano") || item.getDescricao().equals("Arco e Flecha de vidro"); 
     if (itensDoElfoVerde){
        super.adicionarItem(item);
     }else{
         return;
     }
   }
}
