package tienda.de.productos.con.arreglos;

/**
 *
 * @author Kotaro
 */
public class Tienda {
    public Tienda(){
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
        switch (tipo) {
            case "1":
                return "Supermercado";
            case "2":
                return "Droguería";
            case "3":
                return "Papelería";
            default:
                return "Desconocido";
        }
    }
public void calcularValorUnitario(Producto[] productos, int indice) {
    if (indice >= 0 && indice < productos.length) {
        Producto producto = productos[indice];
        double valorUnitario = producto.getPrecioPorUnidad() / producto.getCantidadActual();
        System.out.println("El valor unitario del producto es: " + valorUnitario);
    } else {
        System.out.println("Índice de producto no válido.");
    }
}
public void verificarCantidadMinima(Producto[] productos, int indice) {
    if (indice >= 0 && indice < productos.length) {
        Producto producto = productos[indice];
        if (producto.getCantidadActual() >= producto.getCantidadMinima()) {
            System.out.println("La cantidad actual es mayor o igual a la cantidad mínima.");
        } else {
            System.out.println("La cantidad actual es menor que la cantidad mínima. Se debe hacer un pedido.");
            // Lógica para hacer un pedido y actualizar la cantidad actual del producto
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
                System.out.println("La cantidad solicitada supera la cantidad actual en inventario.");
                HacerPedido(productos, indice);
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
}
