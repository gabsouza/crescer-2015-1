
/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orc
{
    private int vida = 110;
    private String nome;
    
    public Orc (String nome) {
        this.nome = nome; 
    }
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmmente 10 de dano será decrementado.
     */
    public void recebeAtaque (){
     vida = vida -10;
    }
    
}
