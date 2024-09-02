import java.util.Scanner;
class Elemento {
    String nombre;
    double precio;
    double precioAnterior; // Precio anterior para comparar si ha habido descuento
    boolean enOferta;

    // Constructor
    public Elemento(String nombre, double precio, boolean enOferta) {
        this.nombre = nombre;
        this.precio = precio;
        this.precioAnterior = precio; // Inicialmente el precio anterior es igual al precio actual
        this.enOferta = enOferta;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEnOferta() {
        return enOferta;
    }

    // Método para actualizar el precio y verificar descuento
    public void actualizarPrecio(double nuevoPrecio) {
        this.precioAnterior = this.precio; // Guardar el precio anterior
        this.precio = nuevoPrecio; // Actualizar el precio
        this.enOferta = nuevoPrecio < this.precioAnterior; // Determinar si está en descuento
    }
}

public class GestorElementos {
    Scanner sc = new Scanner(System.in);

    public void ejecutar() {
        System.out.print("Ingrese el número de filas de la matriz de elementos: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese el número de columnas de la matriz de elementos: ");
        int columnas = sc.nextInt();

        // Crear y llenar la matriz de elementos
        Elemento[][] matriz = llenarMatriz(filas, columnas);

        // Contar los elementos en oferta
        int elementosEnOferta = contarElementosEnOferta(matriz, filas, columnas);

        // Mostrar el resultado
        System.out.println("Número de elementos en oferta: " + elementosEnOferta);
    }

    public Elemento[][] llenarMatriz(int filas, int columnas) {
        Elemento[][] matriz = new Elemento[filas][columnas];
        System.out.println("Ingrese los elementos para la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el nombre del elemento (" + i + "," + j + "): ");
                String nombre = sc.next();
                System.out.print("Ingrese el precio del elemento (" + i + "," + j + "): ");
                double precio = sc.nextDouble();
                System.out.print("¿El elemento está en oferta? (0=NO/1=SI) (" + i + "," + j + "): ");
                int ofertaInt = sc.nextInt();
                boolean enOferta = (ofertaInt == 1);
                matriz[i][j] = new Elemento(nombre, precio, enOferta);
            }
        }
        return matriz;
    }

    public int contarElementosEnOferta(Elemento[][] matriz, int filas, int columnas) {
        int conteo = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j].isEnOferta()) {
                    conteo++;
                }
            }
        }
        return conteo;
    }
}
