/*Dada una matriz de objetos Producto en una tienda, donde cada Producto tiene un atributo cantidad, escribe un algoritmo que sume todas las cantidades para determinar el inventario total de la tienda.

Solución: Itera a través de cada celda de la matriz sumando el valor del atributo cantidad de cada objeto. */
import java.util.Scanner;

class Item {
    String nombre = "";
    int cantidad = 0;

    public Item(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

public class Contenedor {
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de filas de la matriz de items:");
        int filas = sc.nextInt();
        System.out.println("Ingrese el número de columnas de la matriz de items:");
        int columnas = sc.nextInt();
        sc.nextLine();

        Item[][] contenedor = new Item[filas][columnas];

        for (int i = 0; i < contenedor.length; i++) {
            for (int j = 0; j < contenedor[i].length; j++) {
                System.out.println("Ingrese el nombre del item en la posición " + i + " " + j);
                String nombre = sc.nextLine();
                System.out.println("Ingrese la cantidad del item en la posición " + i + " " + j);
                int cantidad = sc.nextInt();
                sc.nextLine();

                contenedor[i][j] = new Item(nombre, cantidad);
            }
        }

        int inventarioTotal = calcularInventarioTotal(contenedor);
        System.out.println("El inventario total de la tienda es: " + inventarioTotal);
    }

    public static int calcularInventarioTotal(Item[][] contenedor) {
        int total = 0;
        for (int i = 0; i < contenedor.length; i++) {
            for (int j = 0; j < contenedor[i].length; j++) {
                if (contenedor[i][j] != null) {
                    total += contenedor[i][j].getCantidad();
                }
            }
        }
        return total;
    }
}
