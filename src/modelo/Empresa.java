package modelo;

import modelo.Cliente;

/**
 * Subclase
 * Clase empresa recibe constructor de parametros heredados de la lclase cliente
 * Se declaran variables extras excluivas en caso de tener un cliente de una empresa
 */
public class Empresa extends Cliente {
    //Propiedades
    private String contacto;
    private int descuento;

    /**
     * Constructor heredado de clase cliente
     */
    public Empresa() {
    }

    /**
     * Constructor secundario recibe parametros heredado de clase Cliente
     * @param nombre
     * @param apellido
     * @param correoElectronico
     * @param telefono
     * @param repuesto
     */
    public Empresa(String nombre, String apellido, String correoElectronico, String telefono, String repuesto, String contacto, int descuesto) {
        super(nombre, apellido, correoElectronico, telefono, repuesto);
        this.contacto = contacto;
        this.descuento = descuesto;
    }

    /**
     * Generacin de metodos de getter y setter para acceder a las propiedades
     * @return
     */
    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    /**
     * Metodo implementado para imprimir el texto
     * @return los valores y permite mostrarlos en pantalla
     */
    @Override
    public String toString() {
        return "Empresa{" +
                "contacto='" + contacto + '\'' +
                ", descuento=" + descuento +
                '}';
    }
}
