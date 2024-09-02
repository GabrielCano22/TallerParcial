import java.util.Scanner;
class Estudiante {
    String nombre;
    char calificacion;

    // Constructor
    public Estudiante(String nombre, char calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(char calificacion) {
        this.calificacion = calificacion;
    }

    public String toString() {
        return nombre + " (Calificación: " + calificacion + ")";
    }
}

public class Escuela {
    Scanner sc = new Scanner(System.in);

    public void ejecutar() {
        System.out.print("Ingrese el número de filas de la matriz de estudiantes: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese el número de columnas de la matriz de estudiantes: ");
        int columnas = sc.nextInt();

        Estudiante[][] estudiantes = llenarMatrizEstudiantes(filas, columnas);

        // Crear matrices para cada calificación
        Estudiante[][][] matricesCalificaciones = crearMatricesCalificaciones();

        // Agrupar estudiantes en matrices de calificaciones
        agruparEstudiantes(estudiantes, matricesCalificaciones);

        // Mostrar las matrices de calificaciones
        mostrarMatricesCalificaciones(matricesCalificaciones);
    }

    public Estudiante[][] llenarMatrizEstudiantes(int filas, int columnas) {
        Estudiante[][] estudiantes = new Estudiante[filas][columnas];
        System.out.println("Ingrese los estudiantes:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el nombre del estudiante (" + i + "," + j + "): ");
                String nombre = sc.next();
                System.out.print("Ingrese la calificación del estudiante (" + i + "," + j + ") [A-Z]: ");
                char calificacion = sc.next().toUpperCase().charAt(0);
                estudiantes[i][j] = new Estudiante(nombre, calificacion);
            }
        }
        return estudiantes;
    }

    public Estudiante[][][] crearMatricesCalificaciones() {
        Estudiante[][][] matricesCalificaciones = new Estudiante[26][][];
        for (int i = 0; i < 26; i++) {
            matricesCalificaciones[i] = new Estudiante[100][100]; // Tamaño arbitrario, ajusta si es necesario
        }
        return matricesCalificaciones;
    }

    public void agruparEstudiantes(Estudiante[][] estudiantes, Estudiante[][][] matricesCalificaciones) {
        for (int i = 0; i < estudiantes.length; i++) {
            for (int j = 0; j < estudiantes[i].length; j++) {
                Estudiante estudiante = estudiantes[i][j];
                char calificacion = estudiante.getCalificacion();
                int index = calificacion - 'A';
                int filaLibre = buscarFilaLibre(matricesCalificaciones[index]);
                matricesCalificaciones[index][filaLibre][0] = estudiante; // Asigna el estudiante a la primera columna libre
            }
        }
    }

    public int buscarFilaLibre(Estudiante[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null) {
                return i;
            }
        }
        return -1; // Si no hay filas libres, devuelve -1
    }

    public void mostrarMatricesCalificaciones(Estudiante[][][] matricesCalificaciones) {
        for (int i = 0; i < matricesCalificaciones.length; i++) {
            char calificacion = (char) ('A' + i);
            System.out.println("Estudiantes con calificación " + calificacion + ":");
            for (int j = 0; j < matricesCalificaciones[i].length; j++) {
                if (matricesCalificaciones[i][j][0] != null) {
                    for (int k = 0; k < matricesCalificaciones[i][j].length; k++) {
                        if (matricesCalificaciones[i][j][k] != null) {
                            System.out.println(matricesCalificaciones[i][j][k]);
                        }
                    }
                }
            }
        }
    }
}
