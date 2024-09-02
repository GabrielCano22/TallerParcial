import java.util.Scanner;
class Vendedor {
    String nombre;
    double[] ventas;

    // Constructor
    public Vendedor(String nombre, double[] ventas) {
        this.nombre = nombre;
        this.ventas = ventas;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public double[] getVentas() {
        return ventas;
    }

    // Método para calcular la suma de ventas
    public double calcularTotalVentas() {
        double total = 0;
        for (double venta : ventas) {
            total += venta;
        }
        return total;
    }
}
public class GestorVentas {
    Scanner sc = new Scanner(System.in);

    public void ejecutar() {
        // Crear la matriz de ventas
        double[][] ventas = new double[5][12];
        Vendedor[] vendedores = new Vendedor[5];

        // Ingresar los nombres y ventas de los vendedores
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el nombre del vendedor " + (i + 1) + ": ");
            String nombre = sc.next();
            double[] ventasVendedor = new double[12];
            System.out.println("Ingrese las ventas del vendedor " + nombre + ":");
            for (int j = 0; j < 12; j++) {
                System.out.print("Venta mes " + (j + 1) + ": ");
                ventasVendedor[j] = sc.nextDouble();
            }
            vendedores[i] = new Vendedor(nombre, ventasVendedor);
        }

        // Calcular el vendedor con mayor venta total
        double maxVentas = 0;
        Vendedor mejorVendedor = null;

        for (Vendedor vendedor : vendedores) {
            double totalVentas = vendedor.calcularTotalVentas();
            if (totalVentas > maxVentas) {
                maxVentas = totalVentas;
                mejorVendedor = vendedor;
            }
        }

        // Mostrar el resultado
        if (mejorVendedor != null) {
            System.out.println("El vendedor con más ventas es " + mejorVendedor.getNombre() +
                               " con un total de ventas de: " + maxVentas);
        }
    }
}
