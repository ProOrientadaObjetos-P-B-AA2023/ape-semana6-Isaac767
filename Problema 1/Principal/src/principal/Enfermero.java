package principal;
public class Enfermero {
    private String nombre;
    private String tipo;
    private double sueldoMensual;
    
    public Enfermero(String nombre, String tipo, double sueldoMensual) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.sueldoMensual = sueldoMensual;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public double getSueldoMensual() {
        return sueldoMensual;
    }
    
    public String toString() {
        return "- " + nombre + " - sueldo: " + sueldoMensual + " - " + tipo;
    }
}
