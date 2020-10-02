package utils;

import modelo.Cliente;

import java.util.Date;

/**
 * Esta clase representa la orden de compra de algun cliente
 */
public class Orden {
    //Propiedades con su tipo de dato que seran utilizadas
    int id;
    Cliente cliente;
    ItemOrden item1;
    ItemOrden item2;
    Date fechaOrden;
    double precioEnvio;
    double total;
    String tipoEnvio;
    String estado;
    static int sigIdOrden; //Llevar el orden correlativo id de la orden
    int diasEnvio;

    /**
     * Constructor inicializando parametros de las propiedades
     * @param id
     * @param fechaOrden
     * @param total
     */
    public Orden(int id, Date fechaOrden, double total) {
        this.id = id;
        this.fechaOrden = new Date();
        this.total = 0.0;
    }

    /**
     *
     * @param cliente
     * @param fechaOrden
     */
    public Orden(Cliente cliente, Date fechaOrden) {
        this.cliente = cliente;
        this.fechaOrden = fechaOrden;
    }

    /**
     * Metodo que calcula el monto total de la orden
     *  se calculará en base a los precios de los productos y el descuento si es que aplica
     * @return
     */
    public void getTotalOrden(){ //falta implemtar metodo

    }
}
