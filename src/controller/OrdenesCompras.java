package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase Ordenes de compra para manejar Altas, bajas y cambios para Ordenes de Compra
 */
public class OrdenesCompras {
    public TableView tblOrden;
    public TextField txtId;

    @FXML
    public void initialize(){

    }

    /**
     * Metodo exit(salir) permite salir del sistema
     * @param actionEvent accion al dar click en el boton salir
     */
    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Metodo implementado para realizar la accion de regresar al menu principal
     * @param actionEvent
     */
    public void retornarMenu(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage stageLogin = (Stage) txtId.getScene().getWindow();
            stageLogin.close();//cerrar stage o ventana
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
