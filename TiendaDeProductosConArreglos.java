package tienda.de.productos.con.arreglos;

import java.util.Scanner;

/**
 *
 * @author Alexandra Tinjaca
 */
public class TiendaDeProductosConArreglos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcion;
        Scanner sc = new Scanner(System.in);
        
        
        Tienda tienda1;
        tienda1 = new Tienda();
        
        Producto producto;
        producto = new Producto(); 
        
        /*
        tienda1.UsarArregloDeFabrica();
        
        tienda1.AumentarValorUnitario();
        tienda1.ProductoMenosVendido();
        tienda1.ProductoMasVendido();
        tienda1.RealizarVenta();
        */
        
        do{
            System.out.println("********** Tienda1 **********");
            System.out.println("1. Crear una tienda ");
            System.out.println("2. Agregar productos a la tienda ");
            System.out.println("3. Usar los productos de fabrica ");
            System.out.println("4. Mostrar productos de la tienda ");
            System.out.println("5. Producto más vendido en la tienda");
            System.out.println("6. Producto menos vendido en la tienda");
            System.out.println("7. Valor total de ventas de la tienda");
            System.out.println("8. Valor de IVA a consignar por la tienda");
            System.out.println("9. Calcular descuento (incluye valor del iva)");
            System.out.println("");
            System.out.println("0. Terminar");
            System.out.println("Por favor ingrese el número de la opción deseada: ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1 -> tienda1.crearTienda();
                case 2 -> tienda1.AgregarAtributosAMano();
                case 3 -> tienda1.UsarArregloDeFabrica();
                case 4 -> tienda1.getProducto();
                case 5 -> tienda1.ProductoMasVendido();
                case 6 -> tienda1.ProductoMenosVendido();
                case 7 -> tienda1.MostrarValorTotalDeVenta();
                case 8 -> tienda1.ValorDeIVA();
                default -> opcion = 0;
            }
            
        }while(opcion != 0);
        
        System.out.println("Sesión terminada.");
        
    }
    
}
