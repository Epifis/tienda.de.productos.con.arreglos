package tienda.de.productos.con.arreglos;

/**
 *
 * @author Alexandra Tinjaca
 */

import java.util.Scanner;

public class TiendaDeProductos {
    private Tienda tienda;
    private Scanner scanner;

    public TiendaDeProductos() {
        scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion = -1;

        while (opcion != 11) {
            System.out.println("---- Menú de Opciones ----");
            System.out.println("0. Crear la lista de productos");
            System.out.println("1. Producto menos vendido");
            System.out.println("2. Producto más vendido");
            System.out.println("3. Verificar tipo de producto");
            System.out.println("4. Mostrar los productos almacenados en tienda");
            System.out.println("5. Verificar cantidad mínima");
            System.out.println("6. Realizar una venta");
            System.out.println("7. Calcular valor del inventario");
            System.out.println("8. Visualizar el precio promedio de los productos");
            System.out.println("9. Calcular el dinero en caja para cada tipo de producto");
            System.out.println("10. Agregar productos");
            System.out.println("11. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    crearListaProductos();
                    break;

                case 1:
                    Producto menosVendido = tienda.ProductoMenosVendido();
                    System.out.println("El producto menos vendido es: " + menosVendido.getNombre());
                    break;

                case 2:
                    Producto masVendido = tienda.ProductoMasVendido();
                    System.out.println("El producto más vendido es: " + masVendido.getNombre());
                    break;

                case 3:
                    System.out.print("Ingrese el índice del producto para verificar su tipo: ");
                    int indiceVerificarTipo = scanner.nextInt();
                    String tipoProductoVerificado = tienda.verificarTipoProducto(indiceVerificarTipo);
                    System.out.println("El producto en el índice " + indiceVerificarTipo + " es de tipo: " + tipoProductoVerificado);
                    break;

                case 4:
                    tienda.mostrarProductos();
                    break;

                case 5:
                    System.out.print("Ingrese el índice del producto: ");
                    int indiceVerificarCantidad = scanner.nextInt();
                    tienda.verificarCantidadMinima(indiceVerificarCantidad);
                    break;

                case 6:
                    System.out.print("Ingrese el índice del producto para realizar la venta: ");
                    int indiceRealizarVenta = scanner.nextInt();
                    System.out.print("Ingrese la cantidad de unidades que desea comprar: ");
                    int cantidadAComprar = scanner.nextInt();
                    tienda.realizarVenta(indiceRealizarVenta, cantidadAComprar);
                    break;

                case 7:
                    tienda.CalcularValorDelInventario();
                    break;

                case 8:
                    tienda.PrecioPromedioProductos();
                    break;

                case 9:
                    tienda.DineroEnCajaPorTipo();
                    break;

                case 10:
                    agregarProducto();
                    break;

                case 11:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    private void crearListaProductos() {
        System.out.print("Ingrese la capacidad máxima del arreglo: ");
        int capacidadMaxima = scanner.nextInt();
        tienda = new Tienda(capacidadMaxima);
        System.out.println("Lista de productos creada.");
    }

    private void agregarProducto() {
        if (tienda == null) {
            System.out.println("Primero cree la lista de productos.");
        } else {
            System.out.println("Ingrese los detalles del producto:");
            System.out.print("Nombre: ");
            scanner.nextLine();  // Consume the newline character
            String nombre = scanner.nextLine();
            System.out.print("Tipo: ");
            String tipo = scanner.next();
            System.out.print("Cantidad vendida: ");
            int cantidadVendida = scanner.nextInt();
            System.out.print("Cantidad actual: ");
            int cantidadActual = scanner.nextInt();
            System.out.print("Cantidad mínima: ");
            int cantidadMinima = scanner.nextInt();
            System.out.print("Precio por unidad: ");
            double precioPorUnidad = scanner.nextDouble();

            Producto producto = new Producto(nombre, tipo, cantidadVendida, cantidadActual, cantidadMinima, precioPorUnidad);
            tienda.agregarProducto(producto);
        }
    }

    public static void main(String[] args) {
        TiendaDeProductos tiendaDeProductos = new TiendaDeProductos();
        tiendaDeProductos.ejecutar();
    }
}
