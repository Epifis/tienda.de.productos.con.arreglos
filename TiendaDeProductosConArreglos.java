package tiendadeproductos;

import java.util.Scanner;

/**
 *
 * @author Alexandra Tinjaca
 */
public class TiendaDeProductos {

    public static Tienda CrearTienda(){
        Tienda tienda1;
        tienda1 = new Tienda();
        return tienda1;
    }
    public static Producto[] CrearArregloAMano(){
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese el tamaño de la matriz
        System.out.print("Ingrese el número de productos: ");
        int numProductos = Integer.parseInt(scanner.nextLine());

        // Crear la matriz para almacenar la información de los productos
        Producto[] productos = new Producto[numProductos];

        // Bucle para ingresar la información de cada producto
        for (int i = 0; i < numProductos; i++) {
            System.out.println("Ingrese los detalles del producto " + (i + 1) + ":");

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();

            System.out.print("Cantidad vendida: ");
            int cantidadVendida = Integer.parseInt(scanner.nextLine());

            System.out.print("Cantidad actual: ");
            int cantidadActual = Integer.parseInt(scanner.nextLine());

            System.out.print("Cantidad mínima: ");
            int cantidadMinima = Integer.parseInt(scanner.nextLine());

            System.out.print("Precio por unidad: ");
            double precioPorUnidad = Double.parseDouble(scanner.nextLine());

            // Crear un objeto Producto y almacenar la información en la matriz
            productos[i] = new Producto(nombre, tipo, cantidadVendida, cantidadActual, cantidadMinima, precioPorUnidad);
        }

        return productos;
    }
     /**
     * @param args
     */
    public static void main(String[] args) {
        int opcion;
        Scanner sc = new Scanner(System.in);
        
        Producto[] productos;
        productos = new Producto[1];
        
        Tienda tienda1;
        tienda1 = new Tienda();
        
        CrearTienda();
        do {
            System.out.println("---- Menú de Opciones ----");
            System.out.println("0. Crear la lista de productos");
            System.out.println("1. Producto menos vendido");
            System.out.println("2. Producto más vendido");
            System.out.println("3. Verificar tipo de producto");
            System.out.println("4. Mostrar los productos almacenados en tienda");
            System.out.println("5. Verificar cantidad mínima");
            System.out.println("6. Realizar una venta");
            System.out.println("7. Calcular valor del inventario");
            System.out.println("9. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 0 ->{
                    CrearArregloAMano();
                }
                case 1 -> {
                    Producto menosVendido = tienda1.ProductoMenosVendido(productos);
                    System.out.println("El producto menos vendido es: " + menosVendido.getNombre());
                }
                case 2 -> {
                    Producto masVendido = tienda1.ProductoMasVendido(productos);
                    System.out.println("El producto más vendido es: " + masVendido.getNombre());
                }
                case 3 -> {
                    System.out.print("Ingrese el índice del producto para verificar su tipo: ");
                    int indiceVerificarTipo = Integer.parseInt(sc.nextLine());
                        Producto productoVerificar = productos[indiceVerificarTipo];
                        String tipoProductoVerificado = tienda1.verificarTipoProducto(productoVerificar);
                        System.out.println("El producto en el índice " + indiceVerificarTipo + " es de tipo: " + tipoProductoVerificado);
                    break;
                }
                case 4 -> {
                    tienda1.mostrarProductos(productos);
                }
                case 5 -> {
                    System.out.print("Ingrese el índice del producto: ");
                    int indiceVerificarCantidad = Integer.parseInt(sc.nextLine());
                    tienda1.verificarCantidadMinima(productos, indiceVerificarCantidad);
                }
                case 6 -> {
                    System.out.print("Ingrese el índice del producto para realizar la venta: ");
                    int indiceRealizarVenta = Integer.parseInt(sc.nextLine());
                    System.out.print("Ingrese la cantidad de unidades que desea comprar: ");
                    int cantidadAComprar = Integer.parseInt(sc.nextLine());
                    tienda1.realizarVenta(productos, indiceRealizarVenta, cantidadAComprar);
                }
                case 7 -> {
                    tienda1.CalcularValorDelInventario(productos);
                }
                case 9 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
        System.out.println("Sesión terminada.");
        
    }
    
}
