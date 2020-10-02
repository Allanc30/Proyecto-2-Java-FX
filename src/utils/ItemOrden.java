package utils;

import modelo.Producto;

/**
 * Clase ItemOrden representa el cálculo de un producto que forma parte de la orden
 */
public class ItemOrden {
    //Propiedades
    int noLinea; //que será un número correlativo de la orden
    int cantidad;
    Producto producto;

    /**
     * Constructor de ItemOrden con sus siguientes paramentros
     * @param noLinea que será un número correlativo de la orden
     * @param cantidad numero de productos
     * @param producto
     */
    public ItemOrden(int noLinea, int cantidad, Producto producto) {
        this.noLinea = noLinea;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    /**
     * Metodo ToString que permite imprimir valores en pantalla retornandolos como valores String
     * @return devuelve valors ingresados nombre de la clase y propiedades
     */
    @Override
    public String toString() {
        return "ItemOrden{" +
                "noLinea=" + noLinea +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }
}
