package utils;
import modelo.Cliente;
import modelo.Producto;

import java.util.ArrayList;
/**
 * Clase DataSistema para guardar un catálogo de clientes
 */
public class DataSistema {
    //
    public static ArrayList<Cliente> clientes = new ArrayList<>(); //asignaar tamanio de memoria para 4 dos individual y dos empresa
    public static ArrayList<Producto> productos = new ArrayList<>(); //asignar tamanio de productos agregar 8 productos default
    public static ArrayList<Orden> ordenes = new ArrayList<>(); // asignar 8 productos por default en la creación de la propiedad

    /**
     * Metodo para almacenas valores de clientes
     * @param c
     */
    public void addCliente(Cliente c){
        clientes.add(c);
    }

    /**
     * Metodo sin retorno para almacenar valores de productos
     * @param p
     */
    public void addProducto(Producto p){
        productos.add(p);
    }

    /**
     * Metodo para guardar ordenes de compra que se realicen
     * @param o
     */
    public void addOrden(Orden o){
        ordenes.add(o);
    }

    /**
     * Metodos get de tipo arraysList para manejar las difererentes clases que guardaran datos
     * @return
     */
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static ArrayList<Orden> getOrdenes() {
        return ordenes;
    }
}
