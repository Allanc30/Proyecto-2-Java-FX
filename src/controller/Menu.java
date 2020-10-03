package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Producto;
import utils.VariablesGlobales;
import utils.DataSistema;

import java.io.IOException;
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
    public MenuItem itemProductos;


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
     * Metodo para mostrar en la tablaView datos almacenados de clientes guardados en memoria
     * @param actionEvent al hacer click en el boton se ejecutara dicha accion
     */
    public void cargarClientes(ActionEvent actionEvent) {
        Cliente c2 =new Cliente("Ana","Gonzalez","ana5555@gmail.com","7985-8596","Compresor de resortes amortiguador");
        VariablesGlobales.cli1.addCliente(c2);
        Cliente c3 =new Cliente("Luis","Hernandez","luishernandez@gmail.com","8596-8541","Filtro de aceite");
        VariablesGlobales.cli1.addCliente(c3);
        Cliente c4 =new Cliente("Carlos","Herrera Hernandez","carlosn477@gmail.com","9090-1045","Protect 10W-40 4Litros");
        VariablesGlobales.cli1.addCliente(c4);
        Cliente c5 =new Cliente("Dulce","Cifuentes","dulcecifuentes4@gmail","5696-4122","Filtro de gasolina");
        VariablesGlobales.cli1.addCliente(c5);
        ObservableList<Cliente> dat = FXCollections.observableArrayList(VariablesGlobales.cli1.getClientes()); //convertir un arreglo de este tipo
        tblClientes.setItems(dat);
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

    /**
     * Metodo para entrar al formulario de Productos
     * @param actionEvent accionar evento con un click
     */
    @FXML
    public void formProductos(ActionEvent actionEvent) {
        try {
            VariablesGlobales.cli1 = new DataSistema(); //se crea una instancia de ese tipo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ProductosManejo.fxml"));
            Parent root = loader.load();
            ProductosManejo products = loader.getController();
            //products.init(productos);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Productos");
            stage.setScene(scene);
            stage.show();
            //stage.showAndWait();
            Stage stageLogin = (Stage) txtNombreCliente.getScene().getWindow();
            stageLogin.close();//cerrar stage o ventana de login y dejar solo menuPrincipal
            //Stage stage1 = (Stage)this.itemProductos.getScene().getWindow();
            //stage1.close();


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo formOrden para entrar al a dicha ventana al dar clic en el botn de opciones
     * @param actionEvent
     */
    @FXML
    public void formOrden(ActionEvent actionEvent) {
        try {
            //VariablesGlobales.cli1 = new DataSistema(); //se crea una instancia de ese tipo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/OrdenesCompras.fxml"));
            Parent root = loader.load();
            OrdenesCompras orComp = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Ordenes de Compra");
            stage.setScene(scene);
            stage.show();
            Stage stageLogin = (Stage) txtNombreCliente.getScene().getWindow();
            stageLogin.close();//cerrar stage o ventana de login y dejar solo menuPrincipal
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Metodo exit implementado para salir de la aplicacion
     * @param actionEvent funcion al dar clic en el boton
     */
    public void salir(ActionEvent actionEvent) {
        System.exit(0);
    }
}
