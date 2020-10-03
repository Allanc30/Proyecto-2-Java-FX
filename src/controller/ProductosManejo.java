package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.PropertyValueFactoryBuilder;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Producto;
import utils.DataSistema;
import utils.VariablesGlobales;

import java.io.IOException;

/**
 * Clase implementada para el manejo de productos a la venta de auto partes
 */
public class ProductosManejo {

    public TextField txtNombreProducto;
    public TextField txtPrecioUnitario;
    public TableView tblProductos;
    public TableColumn tfId;
    public TableColumn tfProducto;
    public TableColumn tfPrecio;

    /**
     * Metodo que no tiene retorno para parametrizar los valores iniciales de nuestro Stage
     */
    @FXML
    public void initialize(){
        tfId.setCellFactory(new PropertyValueFactory<Producto, Integer>("id"));
        tfProducto.setCellFactory(new PropertyValueFactory<Producto, String>("nombreProducto"));
        tfPrecio.setCellFactory(new PropertyValueFactory<Producto, Double>("precioUnitario"));
    }

    /**
     * Metodo para guardar productos nuevos que van ingresando
     * @param actionEvent se realiza accion al dar click en le boton
     */
    public void addProducto(ActionEvent actionEvent) {
        try {
            Producto p1 =new Producto(txtNombreProducto.getText(),Double.parseDouble(this.txtPrecioUnitario.getText()));
            VariablesGlobales.cli1.addProducto(p1);
            ObservableList<Producto> data = FXCollections.observableArrayList(VariablesGlobales.cli1.getProductos()); //convertir un arreglo de este tipo
            tblProductos.setItems(data);
            txtNombreProducto.setText("");
            txtPrecioUnitario.setText("");

        }catch (NumberFormatException n){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos incorrectos. ");
            alert.showAndWait();

        }

    }

    /**
     * Metodo que permite salir del programa
     * @param actionEvent realiza una accion al hacer click
     */
    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Metodo del boton para retornar al menu principal
     * @param actionEvent realiza el evento al dar click
     */
    public void retornarMenu(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage stageLogin = (Stage) txtNombreProducto.getScene().getWindow();
            stageLogin.close();//cerrar stage o ventana
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
