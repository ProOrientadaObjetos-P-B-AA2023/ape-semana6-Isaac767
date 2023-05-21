package principal;
public class Ciudad {
     private String nombre;
    private String provincia;
    
    public Ciudad(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getProvincia() {
        return provincia;
    }
    
    public String toString() {
        return "Ciudad: " + nombre + "\nProvincia: " + provincia;
    }
}

