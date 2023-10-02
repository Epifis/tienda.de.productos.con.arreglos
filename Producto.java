package tienda.de.productos.con.arreglos;

import java.util.Scanner;
import static tienda.de.productos.con.arreglos.Tienda.ProductoEnTienda;


/**
 *
 * @author Alexandra Tinjaca
 */
public class Producto {
    public int tipo, cantBodega,cantMinima, cantVendida, precioBase;
    private static final Scanner sc = new Scanner(System.in);

    public Producto(){
    }
    public void UsarArregloDeFabrica(String [][] productoEnTienda){
        System.out.println("Por favor ingrese el número del producto");
        int x = sc.nextInt();
        switch(x){
            case 0 -> x=0;
            case 1 -> x=1;
            case 2 -> x=2;
            case 4 -> x=4;
            default -> x=0;
        }
        this.tipo = Integer.parseInt(productoEnTienda[1][x]);
        this.cantBodega = Integer.parseInt(productoEnTienda[2][x]);
        this.cantMinima = Integer.parseInt(productoEnTienda[3][x]);
        this.precioBase = Integer.parseInt(productoEnTienda[4][x]);
        
        System.out.println("Precio: " + precioBase);
        System.out.println("Tipo: " + tipo);
        System.out.println("Cantidad en Bodega: " + cantBodega);
        System.out.println("Tope mínimo: " + cantMinima);
    }

    public String[][] getProducto() {
        return ProductoEnTienda;
    }
    
    

}
