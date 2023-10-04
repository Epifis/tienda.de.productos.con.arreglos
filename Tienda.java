package tiendadeproductos;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Kotaro
 */
public class Tienda {
    private int maximo=0, actual=0;
    
    public Tienda(){
    }
    public void AgregarProductos(Producto[] productos){
        Scanner scanner = new Scanner (System.in);
        if (actual < this.maximo){
            System.out.println("Ingrese los detalles del producto:");

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
            Producto productoNuevo = new Producto(nombre, tipo, cantidadVendida, cantidadActual, cantidadMinima, precioPorUnidad);
            productos[actual] = productoNuevo;
            this.actual++;
        }
        else
            System.out.println("No se pueden agregar más productos, haz alcanzado el máximo.");
    }
    public Producto ProductoMenosVendido(Producto[] productos) {
        Producto menosVendido = productos[0];  // Suponemos que el primer producto es el menos vendido inicialmente

        for (int i = 1; i < productos.length; i++) {
            if (productos[i].getCantidadVendida() < menosVendido.getCantidadVendida()) {
                menosVendido = productos[i];
            }
        }

        return menosVendido;
    }
    public Producto ProductoMasVendido(Producto[] productos) {
    Producto masVendido = productos[0];  // Suponemos que el primer producto es el más vendido inicialmente

    for (int i = 1; i < productos.length; i++) {
        if (productos[i].getCantidadVendida() > masVendido.getCantidadVendida()) {
            masVendido = productos[i];
        }
    }

    return masVendido;
    }
    public String verificarTipoProducto(Producto producto) {
            String tipo = producto.getTipo();
            tipo= switch (tipo) {
                case "1" -> "Supermercado";
                case "2" -> "Droguería";
                case "3" -> "Papelería";
                default -> "Desconocido";
            };
        return tipo;
        }
    public void mostrarProductos(Producto[] productos) {
            System.out.println("Los productos almacenados en la tienda son: " + Arrays.deepToString(productos));
    }
    public void verificarCantidadMinima(Producto[] productos, int indice) {
        if (indice >= 0 && indice < productos.length) {
            Producto producto = productos[indice];
            if (producto.getCantidadActual() >= producto.getCantidadMinima()) {
                System.out.println("La cantidad actual es mayor o igual a la cantidad mínima.");
            } else {
                System.out.println("La cantidad actual es menor que la cantidad mínima. Se debe hacer un pedido.");
                HacerPedido(productos, indice);
            }
        } else {
            System.out.println("Índice de producto no válido.");
        }
    }
    public static double calcularValorIVA(Producto producto) {
            double iva;
            iva = switch (producto.getTipo()) {
                case "1" -> 0.03;
                case "2" -> 0.02;
                case "3" -> 0.13;
                default -> 0.0;
            }; // Supermercado
            // Droguería
            // Papelería
            // Valor por defecto si el tipo no es válido
            return iva;
        }
    public void realizarVenta(Producto[] productos, int indice, int cantidadAComprar) {
        if (indice >= 0 && indice < productos.length) {
            Producto producto = productos[indice];
            if (producto.getCantidadActual() >= producto.getCantidadMinima()) {
                double precioConIVA = producto.getPrecioPorUnidad() * cantidadAComprar * calcularValorIVA(producto);
                double totalVenta = producto.getPrecioPorUnidad()* cantidadAComprar + precioConIVA;
                producto.setCantidadVendida(producto.getCantidadVendida() + cantidadAComprar);
                producto.setCantidadActual(producto.getCantidadActual() - cantidadAComprar);
                System.out.println("Venta realizada correctamente.");
                System.out.println("Total de la venta (con IVA): $" + totalVenta);
            } else {
                System.out.println("La cantidad solicitada supera la cantidad actual en inventario, se reabastecera el inventario,"
                        + " se le hará la venta del producto y se hará el pedido en bodega.");
                HacerPedido(productos, indice);
                producto.setCantidadVendida(producto.getCantidadVendida() + cantidadAComprar);
            }
        } else {
            System.out.println("Índice de producto no válido.");
        }
    }
    public void HacerPedido(Producto[] productos, int indice){
        Producto producto = productos[indice];
        producto.setCantidadActual(producto.getCantidadMinima());
        System.out.println("Ahora la cantidad actual del inventario es de: " + producto.getCantidadActual());
    }
    public void CalcularValorDelInventario(Producto[] productos){
        int cantTotalInventario = 0, valorTemporalCant;
        double valorTemporalPrecio, valorTotalInventario = 0;
        
         for (int i = 1; i < productos.length; i++) {
            cantTotalInventario += productos[i].getCantidadActual();
            valorTemporalCant = productos[i].getCantidadActual();
            valorTemporalPrecio = productos[i].getPrecioPorUnidad();
            valorTotalInventario += (valorTemporalCant * valorTemporalPrecio);
        }
        System.out.println("En inventario hay " + cantTotalInventario + "productos en total" + 
                "\n su valor Total es de $" + valorTotalInventario);
    }
    public void PrecioPromedioProductos(Producto[] productos){
        double valorTemporalPrecio = 0, precioPromedio;
        
        for (Producto producto : productos) { //Aqui se hizo la prueba con for-loop
            valorTemporalPrecio += producto.getPrecioPorUnidad();
        }
        precioPromedio = valorTemporalPrecio / productos.length;
        System.out.println("El precio promedio en la tienda es de " + precioPromedio);
    }
    //Calcular el dinero en caja para cada tipo de producto
    public void DineroEnCajaPorTipo(Producto[] productos){
        double dineroCaja1 = 0, dineroCaja2 = 0, dineroCaja3 = 0;
        int cantTipo1 = 0, cantTipo2 = 0, cantTipo3 = 0;
        
        for (Producto producto : productos) {
            switch (producto.getTipo()) {
                case "1" -> {
                    cantTipo1 += producto.getCantidadVendida();
                    dineroCaja1 += (producto.getPrecioPorUnidad() * producto.getCantidadVendida());
                }
                case "2" -> {
                    cantTipo2 += producto.getCantidadVendida();
                    dineroCaja2 += (producto.getPrecioPorUnidad() * producto.getCantidadVendida());
                }
                case "3" -> {
                    cantTipo3 += producto.getCantidadVendida();
                    dineroCaja3 += (producto.getPrecioPorUnidad() * producto.getCantidadVendida());
                }
            }
        }
        
        System.out.println("En tipo 1 hay " + cantTipo1 + " productos, y la cantidad de dinero en caja por tipo es de: " + dineroCaja1);
        System.out.println("En tipo 2 hay " + cantTipo2 + " productos, y la cantidad de dinero en caja por tipo es de: " + dineroCaja2);
        System.out.println("En tipo 2 hay " + cantTipo3 + " productos, y la cantidad de dinero en caja por tipo es de: " + dineroCaja3);
        
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }
    
}
