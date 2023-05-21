package principal;
import java.util.Scanner;  

class EntidadHospitalaria {
    private String nombre;
    private Ciudad ciudad;
    private int numEspecialidades;
    private Medico[] medicos;
    private Enfermero[] enfermeros;
    
    public EntidadHospitalaria(String nombre, Ciudad ciudad, int numEspecialidades, Medico[] medicos, Enfermero[] enfermeros) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.numEspecialidades = numEspecialidades;
        this.medicos = medicos;
        this.enfermeros = enfermeros;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public Ciudad getCiudad() {
        return ciudad;
    }
    
    public int getNumEspecialidades() {
        return numEspecialidades;
    }
    
    public Medico[] getMedicos() {
        return medicos;
    }
    
    public Enfermero[] getEnfermeros() {
        return enfermeros;
    }
    
    public double calcularSueldosTotales() {
        double totalSueldos = 0;
        for (Medico medico : medicos) {
            totalSueldos += medico.getSueldoMensual();
        }
        for (Enfermero enfermero : enfermeros) {
            totalSueldos += enfermero.getSueldoMensual();
        }
        return totalSueldos;
    }
     public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n");
        sb.append("Dirección: ").append(ciudad.getNombre()).append("\n");
        sb.append(ciudad.toString()).append("\n");
        sb.append("Número de especialidades: ").append(numEspecialidades).append("\n");
        
        sb.append("Listado de médicos\n");
        for (Medico medico : medicos) {
            sb.append(medico.toString()).append("\n");
        }
        
        sb.append("\nListado de enfermeros(as)\n");
        for (Enfermero enfermero : enfermeros) {
            sb.append(enfermero.toString()).append("\n");
        }
        
        sb.append("\nTotal de sueldos a pagar por mes: ").append(calcularSueldosTotales());
        
        return sb.toString();
    }
}

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre del hospital: ");
        String nombreHospital = scanner.nextLine();
        
        System.out.println("Ingrese la ciudad del hospital: ");
        String nombreCiudad = scanner.nextLine();
        
        System.out.println("Ingrese la provincia de la ciudad: ");
        String provinciaCiudad = scanner.nextLine();
        
        System.out.println("Ingrese el número de especialidades del hospital: ");
        int numEspecialidades = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        
        System.out.println("Ingrese la cantidad de médicos: ");
        int numMedicos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        
        Medico[] medicos = new Medico[numMedicos];
        for (int i = 0; i < numMedicos; i++) {
            System.out.println("Ingrese el nombre del médico " + (i + 1) + ": ");
            String nombreMedico = scanner.nextLine();
            
            System.out.println("Ingrese la especialidad del médico " + (i + 1) + ": ");
            String especialidadMedico = scanner.nextLine();
            
            System.out.println("Ingrese el sueldo mensual del médico " + (i + 1) + ": ");
            double sueldoMedico = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer de entrada
            
            medicos[i] = new Medico(nombreMedico, especialidadMedico, sueldoMedico);
        }
        
        System.out.println("Ingrese la cantidad de enfermeros(as): ");
        int numEnfermeros = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        
        Enfermero[] enfermeros = new Enfermero[numEnfermeros];
        for (int i = 0; i < numEnfermeros; i++) {
            System.out.println("Ingrese el nombre del enfermero(a) " + (i + 1) + ": ");
            String nombreEnfermero = scanner.nextLine();
            
            System.out.println("Ingrese el tipo de contrato del enfermero(a) " + (i + 1) + ": ");
            String tipoEnfermero = scanner.nextLine();
            
            System.out.println("Ingrese el sueldo mensual del enfermero(a) " + (i + 1) + ": ");
            double sueldoEnfermero = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer de entrada
                    enfermeros[i] = new Enfermero(nombreEnfermero, tipoEnfermero, sueldoEnfermero);
        }
        
        Ciudad ciudad = new Ciudad(nombreCiudad, provinciaCiudad);
        
        EntidadHospitalaria hospital = new EntidadHospitalaria(nombreHospital, ciudad, numEspecialidades, medicos, enfermeros);
        
        System.out.println(hospital.toString());
    }
}
