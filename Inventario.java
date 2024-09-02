import java.util.Scanner;
class Unidad {
    String nombre;
    double peso;
    String categoria;

    // Constructor
    public Unidad(String nombre, double peso, String categoria) {
        this.nombre = nombre;
        this.peso = peso;
        this.categoria = categoria;
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String toString() {
        return nombre + " (Peso: " + peso +"g"+ ", Categoría: " + categoria + ")";
    }
}
public class Inventario {
    Scanner sc = new Scanner(System.in);

    public void ejecutar() {
        System.out.print("Ingrese el número de filas de la matriz de estanterías: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese el número de columnas de la matriz de estanterías: ");
        int columnas = sc.nextInt();

        // Llenar la lista de unidades
        Unidad[] unidades = llenarUnidades();

        // Agrupar las unidades por categoría
        Unidad[][] estanteria = llenarMatrizPorCategoria(filas, columnas, unidades);

        // Mostrar la matriz de estanterías
        mostrarMatriz(estanteria, filas, columnas);
    }

    public Unidad[] llenarUnidades() {
        System.out.print("Ingrese el número de unidades: ");
        int cantidad = sc.nextInt();
        Unidad[] unidades = new Unidad[cantidad];

        System.out.println("Ingrese los detalles de las unidades:");
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre de la unidad (" + i + "): ");
            String nombre = sc.next();
            System.out.print("Ingrese el peso de la unidad (" + i + "): ");
            double peso = sc.nextDouble();
            System.out.print("Ingrese la categoría de la unidad (" + i + "): ");
            String categoria = sc.next();

            unidades[i] = new Unidad(nombre, peso, categoria);
        }
        return unidades;
    }

    public Unidad[][] llenarMatrizPorCategoria(int filas, int columnas, Unidad[] unidades) {
        // Definir el máximo número de categorías posibles (puedes ajustarlo si es necesario)
        String[] categorias = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int maxUnidadesPorCategoria = 100; // Ajusta según tus necesidades
        Unidad[][] categoriasUnidades = new Unidad[categorias.length][maxUnidadesPorCategoria];

        // Agrupar las unidades por categoría
        for (Unidad unidad : unidades) {
            for (int i = 0; i < categorias.length; i++) {
                if (unidad.getCategoria().equals(categorias[i])) {
                    int j = 0;
                    while (categoriasUnidades[i][j] != null) {
                        j++;
                    }
                    if (j < maxUnidadesPorCategoria) {
                        categoriasUnidades[i][j] = unidad;
                    }
                    break;
                }
            }
        }

        // Llenar la matriz con las unidades organizadas por categoría
        Unidad[][] estanteria = new Unidad[filas][columnas];
        int fila = 0;
        int columna = 0;

        for (Unidad[] categoriaUnidades : categoriasUnidades) {
            for (Unidad unidad : categoriaUnidades) {
                if (unidad != null) {
                    if (columna >= columnas) {
                        columna = 0;
                        fila++;
                        if (fila >= filas) {
                            return estanteria; // La matriz está llena
                        }
                    }
                    estanteria[fila][columna] = unidad;
                    columna++;
                }
            }
        }
        return estanteria;
    }

    public void mostrarMatriz(Unidad[][] matriz, int filas, int columnas) {
        System.out.println("Matriz de estanterías:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != null) {
                    System.out.println("[" + i + "][" + j + "]: " + matriz[i][j]);
                }
            }
        }
    }
}
