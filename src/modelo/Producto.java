package modelo;

/**
 *
 */
public class Producto {
    private int id;
    private static int sigIdProducto = 2000;
    private String nombreProducto;
    private double precioUnitario;

    /**
     *Constructor que aumentara id de uno en uno
     */
    public Producto() {
        this.id = sigIdProducto++;
    }

    /**
     *Segundo constructor con los parametros indicados para asignar valores a las propiedades
     * @param nombreProducto
     * @param precioUnitario
     */
    public Producto(String nombreProducto, double precioUnitario) {
        this.id = sigIdProducto++;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
    }

    /**
     * Getter y setter de las variables que permitiran el acceso a dichas variables
     * @return devuelve el valor
     * metodo de tipo void no retornan valores
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecio(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Metodo para imprimir valores en pantalla
     * @return permite retornar los valors e imprimirlos
     */
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre producto='" + nombreProducto + '\'' +
                ", precio unitario=" + precioUnitario +
                '}';
    }
}
