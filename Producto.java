package tienda.de.productos.con.arreglos;


/**
 *
 * @author Alexandra Tinjaca
 */
public class Producto {
    private String nombre;
    private String tipo;
    private int cantidadVendida;
    private int cantidadActual;
    private int cantidadMinima;
    private double precioPorUnidad;

    public Producto(String nombre, String tipo, int cantidadVendida, int cantidadActual, int cantidadMinima, double precioPorUnidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidadVendida = cantidadVendida;
        this.cantidadActual = cantidadActual;
        this.cantidadMinima = cantidadMinima;
        this.precioPorUnidad = precioPorUnidad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nTipo: " + tipo +
                "\nCantidad vendida: " + cantidadVendida +
                "\nCantidad actual: " + cantidadActual +
                "\nCantidad mínima: " + cantidadMinima +
                "\nPrecio por unidad: " + precioPorUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public void setPrecioPorUnidad(double precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }
    
}
