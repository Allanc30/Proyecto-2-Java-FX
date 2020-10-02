package modelo;

/**
 * Super clase que heredaran a Individual y Empresa
 * Clase Cliente es utilizada para asignar los atributos y parametros de informacion que sera utilizada para los clientes
 */
public class Cliente {
    private int id;
    private static int sigIdCliente = 1;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String telefono;
    private String repuesto;

    /**
     * Constructor Cliente
     * asignacion default asigna el valor que le corresponda a la propiedad id
     */
    public Cliente() {
        this.id = sigIdCliente++;
    }

    /**
     * Segundo constructor para asignar valores a las propiedades
     * @param nombre
     * @param apellido
     * @param correoElectronico
     * @param telefono
     * @param repuesto
     */
    public Cliente( String nombre, String apellido, String correoElectronico, String telefono, String repuesto) {
        this.id = sigIdCliente++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.repuesto = repuesto;
    }

    /**
     * Metodos de getter y setter para acceder a las propiedades
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    /**
     * Metodo para retornar valores, sin parametros
     * @return valores de las propiedades
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefono='" + telefono + '\'' +
                ", repuesto='" + repuesto + '\'' +
                '}';
    }
}
