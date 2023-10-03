package tienda.de.productos.con.arreglos;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alexandra Tinjaca
 */

public class Tienda {
    public static final int tamaño = 4;
    private int numeroProducto;
    private double IVA, valorFinal, valorTotal;
    private String nombreTienda, Nombre, atributos, productoMenosVendido, productoMasVendido, tipo;
    private final Scanner sc = new Scanner(System.in);
    public final static String ProductoEnTienda[][] = new String[6][4];

    public Tienda(){
    }
    //[filas --] [columnas |]
    public void crearTienda(){
        
    }
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
        //Tipo 1 == SUPERMERCADO
        //Tipo 2 == Droguería
        //Tipo 3 == Papelería
        
        ProductoEnTienda[0][0] = "Libreta";
        ProductoEnTienda[1][0] = "23";//actual
        ProductoEnTienda[2][0] = "15";//minima
        ProductoEnTienda[3][0] = "87";//vendida
        ProductoEnTienda[4][0] = "5500";//base
        ProductoEnTienda[5][0] = "3";//tipo
        ProductoEnTienda[0][1] = "Leche";
        ProductoEnTienda[1][1] = "150";
        ProductoEnTienda[2][1] = "30";
        ProductoEnTienda[3][1] = "30";
        ProductoEnTienda[4][1] = "2100";
        ProductoEnTienda[5][1] = "1";
        ProductoEnTienda[0][2] = "Jabon";
        ProductoEnTienda[1][2] = "15";
        ProductoEnTienda[2][2] = "50";
        ProductoEnTienda[3][2] = "80";
        ProductoEnTienda[4][2] = "4200";
        ProductoEnTienda[5][2] = "2";
        ProductoEnTienda[0][3] = "Aspirina";
        ProductoEnTienda[1][3] = "60";
        ProductoEnTienda[2][3] = "100";
        ProductoEnTienda[3][3] = "200";
        ProductoEnTienda[4][3] = "2400";
        ProductoEnTienda[5][3] = "2";
        System.out.println("Matriz: \n" + ProductoEnTienda[0][0] + ", " + ProductoEnTienda[1][0] + ", " + ProductoEnTienda[2][0] + ", " + ProductoEnTienda[3][0] + ", " + ProductoEnTienda[4][0] + ", " + ProductoEnTienda[5][0]);
        System.out.println(ProductoEnTienda[0][1] + ", " + ProductoEnTienda[1][1] + ", " + ProductoEnTienda[2][1] + ", " + ProductoEnTienda[3][1] + ", " + ProductoEnTienda[4][1]+ ", " + ProductoEnTienda[5][1]);
        System.out.println(ProductoEnTienda[0][2] + ", " + ProductoEnTienda[1][2] + ", " + ProductoEnTienda[2][2] + ", " + ProductoEnTienda[3][2] + ", " + ProductoEnTienda[4][2]+ ", " + ProductoEnTienda[5][2]);
        System.out.println(ProductoEnTienda[0][3] + ", " + ProductoEnTienda[1][3] + ", " + ProductoEnTienda[2][3] + ", " + ProductoEnTienda[3][3] + ", " + ProductoEnTienda[4][3]+ ", " + ProductoEnTienda[5][3]);
    }

    public String[][] getProducto() {
        System.out.println("Los productos en tienda son: " + Arrays.deepToString(ProductoEnTienda));
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
    public void HacerPedido(){
        ProductoEnTienda [1][numeroProducto] = ProductoEnTienda [2][numeroProducto];
    }
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
        
        valorFinal = cantidadComprar * precioProducto;
        //Aqui se aumenta el precio del producto dependiendo de la cantidad
        
        System.out.println("\n \n Veamos si se aplica a algún descuento: ");
        
        if(cantidadComprar > 10 && cantidadComprar < 50){
            valorFinal = valorFinal - (valorFinal * 0.10);
            System.out.println("Si se aplica. Descuento de 10%");
        }
        else if (cantidadComprar >= 51 && cantidadComprar < 100){
            valorFinal = valorFinal - (valorFinal * 0.20);
            System.out.println("Si se aplica. Descuento de 20%");
        }
        else if (cantidadComprar >= 100){
            valorFinal = (valorFinal* 0.10) + valorFinal;
            System.out.println("No se aplica, en cambio se le hace un aumento del 10% al monto final");
        }
        else
            System.out.println("No se aplica al descuento por cantidad de compra");
        
        //Aqui se mira si se aplica al descuento por valor de compra
        
        Tienda.this.ValorDeIVA();
        if(valorFinal>=200000){
            valorFinal = valorFinal - (valorFinal * 0.10);
            System.out.println("Haz aplicado para el descuento por valor de compra, tu compra es ahora igual a $" + valorFinal);
        }
        else
            System.out.println("Lo sentimos pero no aplica para descuento por valor de compra");
        
        ProductoEnTienda[3][numeroProducto] = Integer.toString(cantBodega + cantidadComprar);
        valorFinal = Integer.parseInt(ProductoEnTienda[4][numeroProducto]) * cantidadComprar;
        ProductoEnTienda[1][numeroProducto] = Integer.toString(Integer.parseInt(ProductoEnTienda[1][numeroProducto]) - cantidadComprar);
        System.out.println("Ahora hay " + ProductoEnTienda[1][numeroProducto] + " cantidad en bodega de " + ProductoEnTienda[0][numeroProducto]);
        System.out.println("y " + ProductoEnTienda[3][numeroProducto] + " cantidad en bogega.");
    }
    public void MostrarValorTotalDeVenta(){
        for(int i=0; i<4; i++){
            int valorTemporal = Integer.parseInt(ProductoEnTienda[3][i]);
            this.valorTotal = valorTotal + valorTemporal;
        }
        System.out.println("El total de ventas en la Tienda es de: " + valorTotal);
    }

    public void ValorDeIVA(){
        System.out.println("Para Supermercado el IVA es del 4%, para droguería 12% y para papelería 16%");
        System.out.print("Seleccione el numero del producto al que quiere visualizar con IVA: ");
        int numeroProducto = sc.nextInt();
        
        switch(ProductoEnTienda[5][numeroProducto]){
            case "1"->this.IVA = 0.04;// Supermercado
            case "2"->this.IVA = 0.12;// Droguería
            case "3"->this.IVA = 0.16;// Papelería
        }
        switch(ProductoEnTienda[5][numeroProducto]){
            case "1"->this.tipo = "Supermercado";// Supermercado
            case "2"->this.tipo = "Droguería";// Droguería
            case "3"->this.tipo = "Papelería";// Papelería
        }
        System.out.println("El producto "+ ProductoEnTienda[0][numeroProducto]+ " es de tipo " + tipo);
        valorFinal = Integer.parseInt(ProductoEnTienda[4][numeroProducto]) * IVA + Integer.parseInt(ProductoEnTienda[4][numeroProducto]);
        System.out.println("Con IVA el valor queda de $" + valorFinal);
    }
    public void SuficienciaDeCantidad(){
        boolean condicion;
        do{
            for(int i=0; i>6; i++){
                if(Integer.parseInt(ProductoEnTienda[1][i])>=Integer.parseInt(ProductoEnTienda[2][i]))
                    condicion = true;
                else{
                    Tienda.this.HacerPedido();
                    condicion = false;
                }
            }
        }while(true);
    }
    public void ModificarSegunPoliticaDeTipo(){
        System.out.print("Seleccione el numero del producto con el que quiere ver si cumple la política de tipo: ");
        this.numeroProducto = sc.nextInt();
        double descuento = 0;
        switch(ProductoEnTienda[5][numeroProducto]){
            case "1"-> descuento = 0.05;// Supermercado
            case "2"-> descuento = 0.10;// Droguería
            case "3"-> descuento = 0.10;// Papelería
        }
        valorFinal = Double.parseDouble(ProductoEnTienda[4][numeroProducto]) - (Double.parseDouble(ProductoEnTienda[4][numeroProducto]) * descuento);
        
        System.out.println("Así, el precio base sería de " + valorFinal);
        System.out.println("Desea cambiar el valor actual de " + ProductoEnTienda[4][numeroProducto] + " por " + valorFinal + "?");
        System.out.println("1. Si \n2.No");
        int decision = sc.nextInt();
        if (decision == 1){
            ProductoEnTienda[4][numeroProducto] = String.valueOf(valorFinal);
        }
    }
}
