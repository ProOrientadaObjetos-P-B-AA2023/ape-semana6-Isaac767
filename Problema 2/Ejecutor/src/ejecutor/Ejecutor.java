package ejecutor;

import java.util.Scanner;

class Materia {
    private String nombre;
    private double acd;
    private double ape;
    private double aa;
    private double recuperacion;
    private double total;
    private String estado;

    public Materia(String nombre, double acd, double ape, double aa) {
        this.nombre = nombre;
        this.acd = acd;
        this.ape = ape;
        this.aa = aa;
        this.total = acd + ape + aa;
        calcularEstado();
    }

    public void calcularEstado() {
        if (this.total >= 7.0) {
            this.estado = "APROBADO";
        } else {
            this.estado = "REPROBADO";
        }
    }

    public void setRecuperacion(double calificacionRecuperacion) {
        this.recuperacion = calificacionRecuperacion;
        this.total = acd + ape + aa + recuperacion;
        calcularEstado();
    }

    public String getNombre() {
        return nombre;
    }

    public double getAcd() {
        return acd;
    }

    public double getApe() {
        return ape;
    }

    public double getAa() {
        return aa;
    }

    public double getRecuperacion() {
        return recuperacion;
    }

    public double getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }
}

class Estudiante {
    private String nombreEst;
    private int edadEst;
    private Materia[] materias;

    public Estudiante(String nombreEst, int edadEst, int numMaterias) {
        this.nombreEst = nombreEst;
        this.edadEst = edadEst;
        this.materias = new Materia[numMaterias];
    }

    public void ingresarDatosMateria(int numMateria, String nombre, double acd, double ape, double aa) {
        Materia materia = new Materia(nombre, acd, ape, aa);
        materias[numMateria - 1] = materia;
    }

    public void ingresarCalificacionRecuperacion() {
        Scanner scanner = new Scanner(System.in);
        for (Materia materia : materias) {
            if (materia.getEstado().equals("REPROBADO")) {
                System.out.print("Ingrese la calificación del examen de recuperación para " + materia.getNombre() + ": ");
                double calificacionRecuperacion = scanner.nextDouble();
                materia.setRecuperacion(calificacionRecuperacion);
            }
        }
    }

    public void mostrarResultados() {
        System.out.println("Estudiante{nombreEst='" + nombreEst + "', edadEst=" + edadEst + "}");

        System.out.println("+--------------+--------+--------+--------+--------+-----------+--------------+");
        System.out.println("|   MATERIA    |  ACD   |  APE   |  AA    | RECUP. |   TOTAL   |   ESTADO     |");
        System.out.println("+--------------+--------+--------+--------+--------+-----------+--------------+");

        for (Materia materia : materias) {
            System.out.printf("| %-12s | %6.2f | %6.2f | %6.2f | %6.2f | %9.2f | %-12s |%n", materia.getNombre(),
                    materia.getAcd(), materia.getApe(), materia.getAa(), materia.getRecuperacion(),
                    materia.getTotal(), materia.getEstado());
        }

        System.out.println("+--------------+--------+--------+--------+--------+-----------+--------------+");
    }
}

public class Ejecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de estudiantes: ");
        int numEstudiantes = scanner.nextInt();

        for (int i = 1; i <= numEstudiantes; i++) {
            System.out.println("\nDATOS DEL ESTUDIANTE " + i);

            System.out.print("Nombre: ");
            String nombreEstudiante = scanner.next();

            System.out.print("Edad: ");
            int edadEstudiante = scanner.nextInt();

            System.out.println("\nINGRESE DATOS DE SUS MATERIAS");

            System.out.print("Número de Materias: ");
            int numMaterias = scanner.nextInt();

            Estudiante estudiante = new Estudiante(nombreEstudiante, edadEstudiante, numMaterias);

            for (int j = 1; j <= numMaterias; j++) {
                System.out.println("\nNombre de la Materia " + j + ":");
                String nombreMateria = scanner.next();

                System.out.print("Calificación de ACD (0.0/3.5) " + j + ": ");
                double acd = scanner.nextDouble();

                System.out.print("Calificación de APE (0.0/3.5) " + j + ": ");
                double ape = scanner.nextDouble();

                System.out.print("Calificación de AA (0.0/3) " + j + ": ");
                double aa = scanner.nextDouble();

                estudiante.ingresarDatosMateria(j, nombreMateria, acd, ape, aa);
            }

            estudiante.mostrarResultados();
            estudiante.ingresarCalificacionRecuperacion();
            System.out.println("\nRESULTADOS ACTUALIZADOS:");
            estudiante.mostrarResultados();
        }
    }
}