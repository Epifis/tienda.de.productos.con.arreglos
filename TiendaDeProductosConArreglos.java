package tienda.de.productos.con.arreglos;
/**
 *
 * @author Alexandra Tinjaca
 */
public class TiendaDeProductosConArreglos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Tienda tienda1;
        tienda1 = new Tienda();
        
        Producto producto;
        producto = new Producto(); 
        
        //tienda1.AgregarAtributosAMano();
        tienda1.UsarArregloDeFabrica();
        //producto.UsarArregloDeFabrica(tienda1.getProducto());
        tienda1.AumentarValorUnitario();
        tienda1.ProductoMenosVendido();
        //tienda1.AgregarAtributosAMano();
        //tienda1.ProductoMenosVendido();
        tienda1.ProductoMasVendido();
        tienda1.RealizarVenta();
    }
    
}
