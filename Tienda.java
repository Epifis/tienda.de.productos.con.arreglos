package tienda.de.productos.con.arreglos;

import java.util.Scanner;

/**
 *
 * @author Alexandra Tinjaca
 */

public class Tienda {
    public static final int tamaño = 4;
    private String Nombre, atributos, productoMenosVendido, productoMasVendido;
    private final Scanner sc = new Scanner(System.in);
    public final static String ProductoEnTienda[][] = new String[5][5];

    public Tienda(){
    }
    
    //[filas --] [columnas |]
    
    public void AgregarAtributosAMano(){
        for(int i=0;i<tamaño;i++){
            //columna
            System.out.println("Ingrese el nombre del producto " + (i));
            ProductoEnTienda[0][i] = sc.nextLine();
            System.out.println("Tipo: ");
            ProductoEnTienda[1][i] = sc.nextLine();
            System.out.println("Cantidad en Bodega: ");
            ProductoEnTienda[2][i] = sc.nextLine();
            System.out.println("Cantidad Vendida: ");
            ProductoEnTienda[3][i] = sc.nextLine();
            System.out.println("Precio Base");
            ProductoEnTienda[4][i] = sc.nextLine();
        }
    }
    public void UsarArregloDeFabrica(){
        //Nombres
        ProductoEnTienda[0][0] = "Libreta";
        ProductoEnTienda[1][0] = "23";//actual
        ProductoEnTienda[2][0] = "15";//minima
        ProductoEnTienda[3][0] = "87";//vendida
        ProductoEnTienda[4][0] = "5500";//base
        ProductoEnTienda[0][1] = "Leche";
        ProductoEnTienda[1][1] = "150";
        ProductoEnTienda[2][1] = "30";
        ProductoEnTienda[3][1] = "30";
        ProductoEnTienda[4][1] = "2100";
        ProductoEnTienda[0][2] = "Jabon";
        ProductoEnTienda[1][2] = "15";
        ProductoEnTienda[2][2] = "50";
        ProductoEnTienda[3][2] = "80";
        ProductoEnTienda[4][2] = "4200";
        ProductoEnTienda[0][3] = "Aspirina";
        ProductoEnTienda[1][3] = "60";
        ProductoEnTienda[2][3] = "100";
        ProductoEnTienda[3][3] = "200";
        ProductoEnTienda[4][3] = "2400";
        System.out.println("Matriz: \n" + ProductoEnTienda[0][0] + ", " + ProductoEnTienda[1][0] + ", " + ProductoEnTienda[2][0] + ", " + ProductoEnTienda[3][0] + ", " + ProductoEnTienda[4][0]);
        System.out.println(ProductoEnTienda[0][1] + ", " + ProductoEnTienda[1][1] + ", " + ProductoEnTienda[2][1] + ", " + ProductoEnTienda[3][1] + ", " + ProductoEnTienda[4][1]);
        System.out.println(ProductoEnTienda[0][2] + ", " + ProductoEnTienda[1][2] + ", " + ProductoEnTienda[2][2] + ", " + ProductoEnTienda[3][2] + ", " + ProductoEnTienda[4][2]);
        System.out.println(ProductoEnTienda[0][3] + ", " + ProductoEnTienda[1][3] + ", " + ProductoEnTienda[2][3] + ", " + ProductoEnTienda[3][3] + ", " + ProductoEnTienda[4][3]);
    }

    public String[][] getProducto() {
        return ProductoEnTienda;
    }
    
    public void ProductoMenosVendido(){
        if(Integer.parseInt(ProductoEnTienda[1][0])<Integer.parseInt(ProductoEnTienda[1][1]) && Integer.parseInt(ProductoEnTienda[1][0])<Integer.parseInt(ProductoEnTienda[1][2]) && Integer.parseInt(ProductoEnTienda[1][0])<Integer.parseInt(ProductoEnTienda[1][3]))
            productoMenosVendido = ProductoEnTienda[0][0];
        else if(Integer.parseInt(ProductoEnTienda[1][1])<Integer.parseInt(ProductoEnTienda[1][2]) && Integer.parseInt(ProductoEnTienda[1][1])<Integer.parseInt(ProductoEnTienda[1][3]))
            productoMenosVendido = ProductoEnTienda[0][1];
        else if(Integer.parseInt(ProductoEnTienda[1][2])<Integer.parseInt(ProductoEnTienda[1][3]))
            productoMenosVendido = ProductoEnTienda[0][2];
        else
            productoMenosVendido = ProductoEnTienda[0][3];
        System.out.println("El producto menos vendido es: " + productoMenosVendido);
    }    
    
    public void ProductoMasVendido(){
        if(Integer.parseInt(ProductoEnTienda[1][0])>Integer.parseInt(ProductoEnTienda[1][1]) && Integer.parseInt(ProductoEnTienda[1][0])>Integer.parseInt(ProductoEnTienda[1][2]) && Integer.parseInt(ProductoEnTienda[1][0])>Integer.parseInt(ProductoEnTienda[1][3]))
            productoMasVendido = ProductoEnTienda[0][0];
        else if(Integer.parseInt(ProductoEnTienda[1][1])>Integer.parseInt(ProductoEnTienda[1][2]) && Integer.parseInt(ProductoEnTienda[1][1])>Integer.parseInt(ProductoEnTienda[1][3]))
            productoMasVendido = ProductoEnTienda[0][1];
        else if(Integer.parseInt(ProductoEnTienda[1][2])>Integer.parseInt(ProductoEnTienda[1][3]))
            productoMasVendido = ProductoEnTienda[0][2];
        else
            productoMasVendido = ProductoEnTienda[0][3];
        System.out.println("El producto mas vendido es: " + productoMasVendido);
    }
    /*public void HacerPedido(){
        this.cantidadBodega = cantidadMinima;
    }
    */
    public void AumentarValorUnitario(){
        for(int i=0; i<=3; i++){
            System.out.println("El precio base era de: " + ProductoEnTienda[4][i]);//[4][i]
            int productotemporal = Integer.parseInt(ProductoEnTienda[4][i]);
            if(productotemporal < 1000){
                ProductoEnTienda[4][i] = Integer.toString((int) (productotemporal + (productotemporal * 0.01)));
                System.out.println("El precio aumentado quedo en: " + ProductoEnTienda[4][i]);
            }
            else if (productotemporal >= 1000 && productotemporal <= 5000){
                ProductoEnTienda[4][i] = Integer.toString((int) (productotemporal + (productotemporal * 0.02)));
                System.out.println("El precio aumentado quedo en: " + ProductoEnTienda[4][i]);
            }
            else if (productotemporal < 5000){
                ProductoEnTienda[4][i] = Integer.toString((int) (productotemporal + (productotemporal * 0.03)));
                System.out.println("El precio aumentado quedo en: " + ProductoEnTienda[4][i]);
            }
            else
                System.out.println("No se hizo ningun aumento");
            
        }
    }
    public void RealizarVenta(){
        System.out.println("Ingrese el numero del producto");
        int numeroProducto = sc.nextInt();
        System.out.println("Ingrese la cantidad de unidades a comprar: ");
        int cantidadComprar = sc.nextInt();
        int precioProducto = Integer.parseInt(ProductoEnTienda[4][numeroProducto]);
        int cantBodega = Integer.parseInt(ProductoEnTienda[3][numeroProducto]);
        
        if(cantidadComprar > 10 && cantidadComprar < 50)
            ProductoEnTienda[1][numeroProducto] = Integer.toString((int) (cantidadComprar * precioProducto - (precioProducto * 0.10)));
        else if (cantidadComprar >= 51 && cantidadComprar < 100)
            ProductoEnTienda[1][numeroProducto] = Integer.toString((int) (cantidadComprar * precioProducto - (precioProducto * 0.20)));
        else if (cantidadComprar >= 100)
            ProductoEnTienda[1][numeroProducto] = Integer.toString((int) ((precioProducto * 0.10) + cantidadComprar * precioProducto));
        
        ProductoEnTienda[3][numeroProducto] = Integer.toString(cantBodega + cantidadComprar);
        ProductoEnTienda[1][numeroProducto] = Integer.toString(Integer.parseInt(ProductoEnTienda[1][numeroProducto]) - cantidadComprar);
        System.out.println("Ahora hay " + ProductoEnTienda[1][numeroProducto] + " cantidad en bodega de " + ProductoEnTienda[0][numeroProducto]);
        System.out.println("y " + ProductoEnTienda[3][numeroProducto] + " cantidad en bogega.");
    }
}
