import java.util.Scanner;

public class Libreria {
    String titulo ="";
    String autor = "";
    Double precio =0.0;
    Scanner sc = new Scanner(System.in);
    public Libreria() {
        this.titulo="";
        this.autor="";
        this.precio=0.0;
        
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public double PrecioMayor(Libreria[][]matriz){
        double mayorValor = 0.0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j].getPrecio()>mayorValor) {
                    mayorValor = matriz[i][j].getPrecio();
                }
            }
        }
        return mayorValor;
    }
    public void EjecutarPunto3(){
        int cantidad= 0;
        System.out.println("Ingrese la cantidad de registros");
        cantidad = sc.nextInt();
        Libreria[][] matriz = new Libreria[cantidad][cantidad];
        Libreria li = new Libreria();
        double PrecioMayor=0;
        matriz =li.LlenarMatriz(cantidad);
        PrecioMayor=li.PrecioMayor(matriz);
        System.out.println("El libro mas costoso es: "+PrecioMayor);

    }

    public Libreria[][] LlenarMatriz(int cantidad){
        Libreria[][] matriz = new Libreria[cantidad][cantidad];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                Libreria li = new Libreria();
                System.out.println("Ingrese el titulo del libro");
                li.setTitulo(sc.next());
                System.out.println("Ingrese el autor");
                li.setAutor(sc.next());
                System.out.println("Ingrese el precio del libro");
                li.setPrecio(sc.nextDouble());
                matriz[i][j]=li;

            }
        }
        return matriz;
    }
}
