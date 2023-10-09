package tienda.de.productos.con.arreglos;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Kotaro
 */
public class Tienda {
    private Producto[] productos;
    private int cantidadProductos;

    public Tienda(int capacidad) {
        productos = new Producto[capacidad];
        cantidadProductos = 0;
    }

    public Tienda() {
    }

    public void agregarProducto(Producto producto) {
        if (cantidadProductos < productos.length) {
            productos[cantidadProductos] = producto;
            cantidadProductos++;
        } else {
            System.out.println("No se puede agregar más productos. La capacidad máxima ha sido alcanzada.");
        }
    }

    public Producto ProductoMenosVendido() {
        Producto menosVendido = productos[0];

        for (int i = 1; i < cantidadProductos; i++) {
            if (productos[i].getCantidadVendida() < menosVendido.getCantidadVendida()) {
                menosVendido = productos[i];
            }
        }

        return menosVendido;
    }

    public Producto ProductoMasVendido() {
        Producto masVendido = productos[0];

        for (int i = 1; i < cantidadProductos; i++) {
            if (productos[i].getCantidadVendida() > masVendido.getCantidadVendida()) {
                masVendido = productos[i];
            }
        }

        return masVendido;
    }

    public String verificarTipoProducto(int indice) {
        if (indice >= 0 && indice < cantidadProductos) {
            String tipo = productos[indice].getTipo();
            return switch (tipo) {
                case "1" -> "Supermercado";
                case "2" -> "Droguería";
                case "3" -> "Papelería";
                default -> "Desconocido";
            };
        } else {
            return "Índice de producto no válido.";
        }
    }

    public void mostrarProductos() {
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("Producto " + (i + 1) + ": " + productos[i]);
        }
    }

    public void verificarCantidadMinima(int indice) {
        if (indice >= 0 && indice < cantidadProductos) {
            Producto producto = productos[indice];
            if (producto.getCantidadActual() >= producto.getCantidadMinima()) {
                System.out.println("La cantidad actual es mayor o igual a la cantidad mínima.");
            } else {
                System.out.println("La cantidad actual es menor que la cantidad mínima. Se debe hacer un pedido.");
                HacerPedido(indice);
            }
        } else {
            System.out.println("Índice de producto no válido.");
        }
    }

    public static double calcularValorIVA(Producto producto) {
        return switch (producto.getTipo()) {
            case "1" -> 0.03;
            case "2" -> 0.02;
            case "3" -> 0.13;
            default -> 0.0;
        };
    }

    public void realizarVenta(int indice, int cantidadAComprar) {
        if (indice >= 0 && indice < cantidadProductos) {
            Producto producto = productos[indice];
            if (producto.getCantidadActual() >= producto.getCantidadMinima()) {
                double precioConIVA = producto.getPrecioPorUnidad() * cantidadAComprar * calcularValorIVA(producto);
                double totalVenta = producto.getPrecioPorUnidad() * cantidadAComprar + precioConIVA;
                producto.setCantidadVendida(producto.getCantidadVendida() + cantidadAComprar);
                producto.setCantidadActual(producto.getCantidadActual() - cantidadAComprar);
                System.out.println("Venta realizada correctamente.");
                System.out.println("Total de la venta (con IVA): $" + totalVenta);
            } else {
                System.out.println("La cantidad solicitada supera la cantidad actual en inventario, se reabastecerá el inventario,"
                        + " se le hará la venta del producto y se hará el pedido en bodega.");
                HacerPedido(indice);
                producto.setCantidadVendida(producto.getCantidadVendida() + cantidadAComprar);
            }
        } else {
            System.out.println("Índice de producto no válido.");
        }
    }

    public void HacerPedido(int indice) {
        if (indice >= 0 && indice < cantidadProductos) {
            Producto producto = productos[indice];
            producto.setCantidadActual(producto.getCantidadMinima());
            System.out.println("Ahora la cantidad actual del inventario es de: " + producto.getCantidadActual());
        } else {
            System.out.println("Índice de producto no válido.");
        }
    }

    public void CalcularValorDelInventario() {
        int cantTotalInventario = 0;
        double valorTotalInventario = 0;

        for (int i = 0; i < cantidadProductos; i++) {
            cantTotalInventario += productos[i].getCantidadActual();
            valorTotalInventario += (productos[i].getCantidadActual() * productos[i].getPrecioPorUnidad());
        }

        System.out.println("En inventario hay " + cantTotalInventario + " productos en total" +
                "\nSu valor total es de $" + valorTotalInventario);
    }

    public void PrecioPromedioProductos() {
        double valorTemporalPrecio = 0;
        for (int i = 0; i < cantidadProductos; i++) {
            valorTemporalPrecio += productos[i].getPrecioPorUnidad();
        }

        double precioPromedio = valorTemporalPrecio / cantidadProductos;
        System.out.println("El precio promedio en la tienda es de $" + precioPromedio);
    }

    public void DineroEnCajaPorTipo() {
        double dineroCaja1 = 0, dineroCaja2 = 0, dineroCaja3 = 0;
        int cantTipo1 = 0, cantTipo2 = 0, cantTipo3 = 0;

        for (int i = 0; i < cantidadProductos; i++) {
            switch (productos[i].getTipo()) {
                case "1" -> {
                    cantTipo1 += productos[i].getCantidadVendida();
                    dineroCaja1 += (productos[i].getPrecioPorUnidad() * productos[i].getCantidadVendida());
                }
                case "2" -> {
                    cantTipo2 += productos[i].getCantidadVendida();
                    dineroCaja2 += (productos[i].getPrecioPorUnidad() * productos[i].getCantidadVendida());
                }
                case "3" -> {
                    cantTipo3 += productos[i].getCantidadVendida();
                    dineroCaja3 += (productos[i].getPrecioPorUnidad() * productos[i].getCantidadVendida());
                }
            }
        }

        System.out.println("En tipo 1 hay " + cantTipo1 + " productos, y la cantidad de dinero en caja por tipo es de: $" + dineroCaja1);
        System.out.println("En tipo 2 hay " + cantTipo2 + " productos, y la cantidad de dinero en caja por tipo es de: $" + dineroCaja2);
       
    }
}
