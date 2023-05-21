
package testcomputer;
class Computador{
    public String tipoProcesador;
    public UnidadDVD unidadDVD;

    public Computador() {
    }
      
    public Computador(String tipoProcesador, UnidadDVD unidadDVD) {
        this.tipoProcesador = tipoProcesador;
        this.unidadDVD = unidadDVD;
    }

    public String getTipoProcesador() {
        return tipoProcesador;
    }

    public void setTipoProcesador(String tipoProcesador) {
        this.tipoProcesador = tipoProcesador;
    }

    public UnidadDVD getUnidadDVD() {
        return unidadDVD;
    }

    public void setUnidadDVD(UnidadDVD unidadDVD) {
        this.unidadDVD = unidadDVD;
    }
    public String toString(){
        return String.format("Computador" +
                "\nTipo de proesador: %s"+
                "\nUnidad DVD: %s",
                this.tipoProcesador, this.unidadDVD);
    }    
     
} 


class UnidadDVD{
    public String marca;
    public UnidadDVD() {
    }

    public UnidadDVD(String marca) {
        this.marca = marca;
    }

    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String toString(){
         return String.format("Marca de unidad DVD: %n\n", this.marca);
     } 
}
public class TestComputer {
    public static void main(String[] args){
        System.out.println("Hello World");
        UnidadDVD unidadDVD1 = new UnidadDVD("Toshiba");
        Computador computador1 = new Computador("Intel", unidadDVD1);
        System.out.println(computador1);
    }
    
}
