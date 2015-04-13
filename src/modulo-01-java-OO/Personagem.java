import java.util.*;
/**
 * Case base para todos os personagens
 * 
 * @author Gabriela de Souza
 */
public class Personagem{
    
    protected Status status = Status.VIVO;
    protected int vida;
    protected String nome;
    protected int experiencia;
    protected ArrayList<ItemDoInventario> itens = new ArrayList<ItemDoInventario>();
    
   protected Personagem (String nome, int vida){
       this.vida = vida;
       this.nome = nome;
   }
   
   protected Status getStatus(){
     return status;
   }
    
   protected int getVida(){
    return vida;
   }
   
   protected int getExperiencia(){
       return experiencia;
   }
    
   protected String getNome(){
        return this.nome;
   }
    
   protected ArrayList<ItemDoInventario> getItens() {
        return this.itens;
   }
    
   protected void adicionarItem(ItemDoInventario item) {
        this.itens.add(item);
   }
    
   protected void perderItem(ItemDoInventario item) {
        this.itens.remove(item);
   }
    
   protected String getDescricoesItens() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
     int numeroDeItens = this.itens.size();
     do {
         if (numeroDeItens > 0) {
             ItemDoInventario itemAtual = this.itens.get(i);
              boolean éÚltimoÍndice = i == numeroDeItens - 1;
               
              builder.append(
                    éÚltimoÍndice ?
                    itemAtual.getDescricao() :
                    itemAtual.getDescricao() + ","
              );
         }
         i++;
     } while(i < numeroDeItens);
     
       return builder.toString();
   }
    
    protected ItemDoInventario getItemComMaiorQuantidade() {
        
        ItemDoInventario itemMaiorQuantidade = null;
        
        boolean temItens = !this.itens.isEmpty();       
        if (temItens) {
            itemMaiorQuantidade = this.itens.get(0);
            
            for (int i = 1; i < this.itens.size(); i++) {
                ItemDoInventario itemAtual = this.itens.get(i);
                boolean encontreiAMaiorQuantidade =
                    itemAtual.getQuantidade() > itemMaiorQuantidade.getQuantidade();
                
                if (encontreiAMaiorQuantidade) {
                    // atualizar a minha referência para o maior parcial
                    itemMaiorQuantidade = itemAtual;
                }
            }
        }
        
        return itemMaiorQuantidade;
    }
   
    protected void ordernarItens(){
     for(int i = 0; i < itens.size() - 1; i++){
        for(int j = 0; j < itens.size() -1; j++){
         ItemDoInventario itemAtual = this.itens.get(j);
         ItemDoInventario proximo = this.itens.get(j+1);
         
         boolean precisaTrocar = itemAtual.getQuantidade() > proximo.getQuantidade();
         if(precisaTrocar){
           this.itens.set(j, proximo);
           this.itens.set(j + 1, itemAtual); 
         } 
        }
     }
    }
   }