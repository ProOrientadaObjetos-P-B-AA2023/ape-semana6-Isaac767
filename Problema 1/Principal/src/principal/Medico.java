package principal;
public class Medico {
    private String nombre;
    private String especialidad;
    private double sueldoMensual;
    
    public Medico(String nombre, String especialidad, double sueldoMensual) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.sueldoMensual = sueldoMensual;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public double getSueldoMensual() {
        return sueldoMensual;
    }
    
    public String toString() {
        return "- " + nombre + " - sueldo: " + sueldoMensual + " - " + especialidad;
    }
}
