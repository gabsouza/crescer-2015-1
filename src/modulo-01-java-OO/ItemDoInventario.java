/**
 * Representa um item e sua quantidade em inventário.
 * 
 * @author CWI Software
 */

public class ItemDoInventario{
    
    private String descricao;
    private int quantidade;
    
    public ItemDoInventario (int quantidade, String descricao){
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
}
