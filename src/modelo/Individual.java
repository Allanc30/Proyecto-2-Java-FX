package modelo;

import modelo.Cliente;

/**
 * Subclase que hereda atributos y metodos de clase Cliente
 */
public class Individual extends Cliente {

    private String dpi;

    /**
     * constructor heredado de clase cliente
     */
    public Individual() {
    }

    /**
     * constructor y parametros heredados de la superclase
     * @param nombre
     * @param apellido
     * @param correoElectronico
     * @param telefono
     * @param repuesto
     */
    public Individual(String dpi, String nombre, String apellido, String correoElectronico, String telefono, String repuesto) {
        super(nombre, apellido, correoElectronico, telefono, repuesto);
        this.dpi = dpi;
    }

    /**
     * Gette y setter de de la variable dpi que perimitira su manejo
     * @return de la propiedad dpi
     */
    public String getDpi() {
        return dpi;
    }

    /**
     * Metodo que no posee retorno
     * @param dpi
     */
    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    /**
     * Metodo que permite imprimir el valor de las porpiedades ingresadas
     * @return valores para ser impresos en patalla
     */
    @Override
    public String toString() {
        return "Individual{" +
                "dpi='" + dpi + '\'' +
                '}';
    }
}
