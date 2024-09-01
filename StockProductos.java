import java.util.Scanner;

class Articulo{
    String nombre = "";
    double precio = 0.0;
    int stock = 0;
    Scanner sc = new Scanner(System.in);

    public Articulo(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public void sumarStock(int cantidad) {
        this.stock += cantidad;
    }
    public boolean esIgual(Articulo otro) {
        return this.nombre.equals(otro.nombre);
    }
    public String toString() {
    return nombre + " (Precio: " + precio + ", Stock: " + stock + ")";
    }
}
    public class StockProductos {
        Scanner sc = new Scanner(System.in);
        int filas =0, columnas=0;

        public void ejecutar() {
            System.out.print("Ingrese el número de filas de las matrices: ");
            filas = sc.nextInt();
            System.out.print("Ingrese el número de columnas de las matrices: ");
            columnas = sc.nextInt();
            sc.nextLine();

            Articulo[][] matrizTienda1 = llenarMatriz(filas, columnas, "primera");
            Articulo[][] matrizTienda2 = llenarMatriz(filas, columnas, "segunda");

            Articulo[][] matrizFusionada = fusionarMatrices(matrizTienda1, matrizTienda2, filas, columnas);

            System.out.println("Matriz fusionada:");
            mostrarMatriz(matrizFusionada, filas, columnas);
        }

        public Articulo[][] llenarMatriz(int filas, int columnas, String tienda) {
            String nombre =  "";
            double precio = 0.0;
            int stock = 0;
            Articulo[][] matriz = new Articulo[filas][columnas];
            System.out.println("Ingrese los productos para la " + tienda + " tienda:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print("Ingrese el nombre del producto (" + i + "," + j + "): ");
                    nombre = sc.next();
                    System.out.print("Ingrese el precio del producto (" + i + "," + j + "): ");
                    precio = sc.nextDouble();
                    System.out.print("Ingrese el stock del producto (" + i + "," + j + "): ");
                    stock = sc.nextInt();
                    matriz[i][j] = new Articulo(nombre, precio, stock);
                }
            }
            return matriz;
        }

        public Articulo[][] fusionarMatrices(Articulo[][] matriz1, Articulo[][] matriz2, int filas, int columnas) {
            Articulo[][] matrizFusionada = new Articulo[filas * columnas][1];
            int indiceFusionada = 0;
            boolean encontrado = true;
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[i].length; j++) {
                    Articulo articulo = matriz1[i][j];
                    if (articulo != null) {
                        encontrado = false;
                        for (int k = 0; k < indiceFusionada; k++) {
                            if (matrizFusionada[k][0] != null && matrizFusionada[k][0].esIgual(articulo)) {
                                matrizFusionada[k][0].sumarStock(articulo.getStock());
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            matrizFusionada[indiceFusionada][0] = articulo;
                            indiceFusionada++;
                        }
                    }
                }
            }

            for (int i = 0; i < matriz2.length; i++) {
                for (int j = 0; j < matriz2[i].length; j++) {
                    Articulo articulo = matriz2[i][j];
                    if (articulo != null) {
                        encontrado = false;
                        for (int k = 0; k < indiceFusionada; k++) {
                            if (matrizFusionada[k][0] != null && matrizFusionada[k][0].esIgual(articulo)) {
                                matrizFusionada[k][0].sumarStock(articulo.getStock());
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            matrizFusionada[indiceFusionada][0] = articulo;
                            indiceFusionada++;
                        }
                    }
                }
            }

            Articulo[][] resultadoFinal = new Articulo[indiceFusionada][1];
            for (int i = 0; i < indiceFusionada; i++) {
                resultadoFinal[i][0] = matrizFusionada[i][0];
            }

            return resultadoFinal;
        }

        public void mostrarMatriz(Articulo[][] matriz, int filas, int columnas) {
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[i][0] != null) {
                    System.out.println(matriz[i][0]);
                }
            }
        }
    }