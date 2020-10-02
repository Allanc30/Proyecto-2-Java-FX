package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import modelo.Cliente;
import utils.VariablesGlobales;
import utils.DataSistema;

import java.util.ArrayList;


/**
 * Clase para realizar opciones de menu
 */
public class Menu {

    public TextField txtNombreCliente;
    public TextField txtApellido;
    public TextField txtCorreo;
    public TextField txtTelefono;
    public TextField txtRepuesto;
    public TableColumn tfId;
    public TableColumn tfNombreCliente;
    public TableColumn tfApellido;
    public TableColumn tfCorreo;
    public TableColumn tfTelefono;
    public TableColumn tfRepuesto;
    public TableView tblClientes;
    public Pane paneCliente;
    public static ArrayList<Cliente> clientes = new ArrayList<>();

    /**
     * Metodo que no tiene retorno para parametrizar los valores iniciales de nuestro Stage
     */
    @FXML
    public void initialize(){
        tfId.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id")); //asignar valores que pueden estar asociados a esta celda y se maneja por meido de un objeto
        tfNombreCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre")); //parametros es nombre y de manera automatica se le pasa un conjunto de carreras
        tfApellido.setCellValueFactory(new PropertyValueFactory<Cliente, String>("apellido"));
        tfCorreo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("correoElectronico"));
        tfTelefono.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));
        tfRepuesto.setCellValueFactory(new PropertyValueFactory<Cliente, String>("repuesto"));

    }

    /**
     * Medtodo para guardar clientes de la empresa Auto Partes
     * @param actionEvent al hacer clic en el boton se iran guardando los datos
     * se realizan instancias
     */
    public void addCliente(ActionEvent actionEvent) {

        try {
            Cliente c1 =new Cliente(txtNombreCliente.getText(),txtApellido.getText(),txtCorreo.getText(),txtTelefono.getText(),txtRepuesto.getText());
            VariablesGlobales.cli1.addCliente(c1);
            ObservableList<Cliente> data = FXCollections.observableArrayList(VariablesGlobales.cli1.getClientes()); //convertir un arreglo de este tipo
            tblClientes.setItems(data);
            txtNombreCliente.setText("");
            txtApellido.setText("");
            txtCorreo.setText("");
            txtTelefono.setText("");
            txtRepuesto.setText("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo exit implementado para salir de la aplicacion
     * @param actionEvent funcion al dar clic en el boton
     */
    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Metodo para accionar el menuItem de altas y bajas de los clientes se muestre
     * @param actionEvent
     */
    public void mostrarCliente(ActionEvent actionEvent) {
        paneCliente.setVisible(true);
    }

    /**
     * Metodo para seleccionar un dato de la tabla de clientes para realizaar eliminacion
     * @param mouseEvent al selecionar la tabla o la linea del dato
     */
    public void seleccionar(MouseEvent mouseEvent) {
        Cliente c = (Cliente) this.tblClientes.getSelectionModel().getSelectedItem();
        if(c!=null){
            this.txtNombreCliente.setText(c.getNombre());
            this.txtApellido.setText(c.getApellido());
            this.txtCorreo.setText(c.getCorreoElectronico());
            this.txtTelefono.setText(c.getTelefono());
            this.txtRepuesto.setText(c.getRepuesto());
        }
    }

    /**
     * Metodo del boton para borrar datos ingresados de un cliente en especifico de la tabla
     * @param actionEvent al dar clic en el boton se ejecuta el metodo clear
     */
    public void clear(ActionEvent actionEvent) {
        Cliente c = (Cliente) this.tblClientes.getSelectionModel().getSelectedItem();

        if(c==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar un cliente. ");
            alert.showAndWait();
        }else{
            //VariablesGlobales.cli1.addCliente(c).remove(c);
            //this.tblClientes.remove(c);
            //this.tblClientes.refresh();
        }
    }
}
