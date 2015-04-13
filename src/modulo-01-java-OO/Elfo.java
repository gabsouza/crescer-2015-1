/**
 * Define objetos Elfo
 * 
 * @author Gabriela de Souza
 */
public class Elfo extends Personagem{

    protected int flechas;

    // type initializer
    {
        flechas = 42;
    }
    
   public Elfo(String umNome, int flechas){
        this(umNome);
        this.flechas = flechas;
   }

   public Elfo(String nome) {
        super(nome, 0);
   }
   
   public void atirarFlecha(Orc umOrc){
        flechas--;
        experiencia++;
        umOrc.recebeAtaque();
   }
    
   protected int getFlechas(){
        return this.flechas;
   }

   public String toString() { 
        return String.format("%s possui %d %s e %d %s de experiência.",
        this.nome,
        this.flechas,
        this.flechas == 1 ? "flecha" : "flechas",
        this.experiencia,
        this.experiencia == 1 ? "nível" : "níveis"
     );
   }
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
}