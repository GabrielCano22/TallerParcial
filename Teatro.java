import java.util.Scanner;

class Asiento {
    String identificador;
    int fila;
    double precio;
    Scanner sc = new Scanner(System.in);

    public Asiento() {
        this.identificador = "";
        this.fila = 0;
        this.precio = 0.0;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString() {
        return "Asiento{" +
                "identificador='" + identificador + '\'' +
                ", fila=" + fila +
                ", precio=" + precio +
                '}';
    }
}

public class Teatro {
    Asiento[][] teatro;
    Scanner sc = new Scanner(System.in);

    public Teatro() {
        this.teatro = new Asiento[0][0];
    }

    public void ejecutar() {
        int cantidad = 0;
        System.out.println("Ingrese la cantidad de filas y columnas");
        cantidad = sc.nextInt();
        teatro = llenarMatriz(cantidad);
        ordenarAsientosPorPrecio(teatro);
        imprimirMatriz(teatro);
    }

    public Asiento[][] llenarMatriz(int cantidad) {
        Asiento[][] matriz = new Asiento[cantidad][cantidad];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Asiento asiento = new Asiento();
                System.out.println("Ingrese el identificador del asiento");
                asiento.setIdentificador(sc.next());
                System.out.println("Ingrese la fila del asiento");
                asiento.setFila(sc.nextInt());
                System.out.println("Ingrese el precio del asiento");
                asiento.setPrecio(sc.nextDouble());
                matriz[i][j] = asiento;
            }
        }
        return matriz;
    }

    public void ordenarAsientosPorPrecio(Asiento[][] teatro) {
        for (Asiento[] fila : teatro) {
            ordenarFilaPorPrecio(fila);
        }
    }

    public void ordenarFilaPorPrecio(Asiento[] fila) {
        for (int i = 0; i < fila.length - 1; i++) {
            for (int j = 0; j < fila.length - 1 - i; j++) {
                if (fila[j].getPrecio() < fila[j + 1].getPrecio()) { // Orden descendente
                    Asiento temp = fila[j];
                    fila[j] = fila[j + 1];
                    fila[j + 1] = temp;
                }
            }
        }
    }

    public void imprimirMatriz(Asiento[][] matriz) {
        for (Asiento[] fila : matriz) {
            for (Asiento asiento : fila) {
                System.out.print(asiento + " ");
            }
            System.out.println();
        }
    }
}
