import java.util.Scanner;
class Mercancia {
    String nombre;
    double precio;
    boolean disponibilidad;

    // Constructor
    public Mercancia(String nombre, double precio, boolean disponibilidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String toString() {
        return nombre + " (Precio: " + precio + ", Disponible: " + disponibilidad + ")";
    }
}
public class Estanteria {
    
    Scanner sc = new Scanner(System.in);

    public void ejecutar() {
        System.out.print("Ingrese el número de filas de la estantería: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese el número de columnas de la estantería: ");
        int columnas = sc.nextInt();

        Mercancia[][] estanteria = llenarEstanteria(filas, columnas);

        Mercancia[][] mercanciasDisponibles = filtrarDisponibles(estanteria, filas, columnas);

        System.out.println("Mercancías disponibles:");
        mostrarMatriz(mercanciasDisponibles, filas, columnas);
    }

    public Mercancia[][] llenarEstanteria(int filas, int columnas) {
        Mercancia[][] estanteria = new Mercancia[filas][columnas];
        System.out.println("Ingrese las mercancías para la estantería:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el nombre de la mercancía (" + i + "," + j + "): ");
                String nombre = sc.next();
                System.out.print("Ingrese el precio de la mercancía (" + i + "," + j + "): ");
                double precio = sc.nextDouble();

                boolean disponibilidad = false;
                while (true) {
                    System.out.print("¿La mercancía está disponible? (0=NO/1=SI) (" + i + "," + j + "): ");
                    int disponibilidadInt = sc.nextInt();
                    if (disponibilidadInt == 0) {
                        disponibilidad = false;
                        break;
                    } else if (disponibilidadInt == 1) {
                        disponibilidad = true;
                        break;
                    } else {
                        System.out.println("Entrada no válida. Por favor, ingrese 0 para NO o 1 para SI.");
                    }
                }

                estanteria[i][j] = new Mercancia(nombre, precio, disponibilidad);
            }
        }
        return estanteria;
    }

    public Mercancia[][] filtrarDisponibles(Mercancia[][] estanteria, int filas, int columnas) {
        Mercancia[][] disponibles = new Mercancia[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (estanteria[i][j].isDisponible()) {
                    disponibles[i][j] = estanteria[i][j];
                } else {
                    disponibles[i][j] = null; // Dejar null si no está disponible
                }
            }
        }
        return disponibles;
    }

    public void mostrarMatriz(Mercancia[][] matriz, int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != null) {
                    System.out.println(matriz[i][j]);
                }
            }
        }
    }
}
