import java.util.Scanner;

class Producto {
    String nombre = "";
    double precio = 0.0;
    int cantidad = 0;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

public class Almacen {
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de filas de la matriz de productos:");
        int filas = sc.nextInt();
        System.out.println("Ingrese el número de columnas de la matriz de productos:");
        int columnas = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        Producto[][] almacen = new Producto[filas][columnas];

        for (int i = 0; i < almacen.length; i++) {
            for (int j = 0; j < almacen[i].length; j++) {
                System.out.println("Ingrese el nombre del producto en la posición " + i + " " + j);
                String nombre = sc.nextLine();
                System.out.println("Ingrese el precio del producto en la posición " + i + " " + j);
                double precio = sc.nextDouble();
                System.out.println("Ingrese la cantidad del producto en la posición " + i + " " + j);
                int cantidad = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

                almacen[i][j] = new Producto(nombre, precio, cantidad);
            }
        }

        System.out.println("Ingrese el nombre del producto que desea buscar:");
        String nombreBuscado = sc.nextLine();

        int[] ubicacion = buscarProducto(almacen, nombreBuscado);

        if (ubicacion != null) {
            System.out.println("El producto se encuentra en la posición (" + ubicacion[0] + ", " + ubicacion[1] + ")");
        } else {
            System.out.println("El producto no fue encontrado");
        }
    }

    public static int[] buscarProducto(Producto[][] almacen, String nombreBuscado) {
        for (int i = 0; i < almacen.length; i++) {
            for (int j = 0; j < almacen[i].length; j++) {
                if (almacen[i][j] != null && almacen[i][j].getNombre().equals(nombreBuscado)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
