package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Cliente;
import utils.DataSistema;
import utils.VariablesGlobales;

import javax.swing.*;

/**
 * Clase que nos permitira manejar los usuarios en el sistema
 */
public class LoginController {

    public PasswordField txtContrasena;
    public TextField txtUsuario;

    /**
     * Metodo para validar usuarios que seran ingresador en el login.fxml
     * Realiza la accion de si un usuario es valido enviarlo a la otra pantalla.
     * @param actionEvent boton accion del evento realiza validacion
     */
    public void validarEntrada(ActionEvent actionEvent) {

        try{
            //validar usuario= Andres_Ramirez, contrasenia= 10203040A
            //Validar usuario= Ana_Rosales, contrasenia= 90807060B
            //validar usuario= Daniel_Herrera, contrasenia= 10020020C
            if(txtUsuario.getText().equals("Andres_Ramirez") && txtContrasena.getText().equals("10203040A")){
                JOptionPane.showMessageDialog(null, "Bienvenido","Auto Partes", JOptionPane.INFORMATION_MESSAGE);
                VariablesGlobales.cli1 = new DataSistema(); //se crea una instancia de ese tipo
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Menu.fxml")); //cargamos nuestra vista
                Pane raiz = (Pane)fxmlLoader.load(); //hacemos un casteo, es nuestro componente raiz lo asosiamos a la Scena
                //se hace un casteo con (pane)
                Scene scene = new Scene(raiz, 750, 650);
                Stage stage =new Stage();
                stage.setTitle("Menu Principal");
                stage.setScene(scene);
                stage.show();
                Stage stageLogin = (Stage) txtUsuario.getScene().getWindow();
                stageLogin.close();//cerrar stage o ventana de login y dejar solo menuPrincipal

            }else if (txtUsuario.getText().equals("Ana_Rosales") && txtContrasena.getText().equals("90807060B")){
                JOptionPane.showMessageDialog(null, "Bienvenido","Auto Partes", JOptionPane.INFORMATION_MESSAGE);
                VariablesGlobales.cli1 = new DataSistema(); //se crea una instancia de ese tipo
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Menu.fxml")); //cargamos nuestra vista
                Pane raiz = (Pane)fxmlLoader.load(); //hacemos un casteo, es nuestro componente raiz lo asosiamos a la Scena
                //se hace un casteo con (pane)
                Scene scene = new Scene(raiz, 750, 650);
                Stage stage =new Stage();
                stage.setTitle("Auto Partes/Menu Principal");
                stage.setScene(scene);
                stage.show();
                Stage stageLogin = (Stage) txtUsuario.getScene().getWindow();
                stageLogin.close();//cerrar stage o ventana de login y dejar solo menuPrincipal

            }else if(txtUsuario.getText().equals("Daniel_Herrera") && txtContrasena.getText().equals("10020020C")){
                JOptionPane.showMessageDialog(null, "Bienvenido","Auto Partes", JOptionPane.INFORMATION_MESSAGE);
                VariablesGlobales.cli1 = new DataSistema(); //se crea una instancia de ese tipo
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Menu.fxml")); //cargamos nuestra vista
                Pane raiz = (Pane)fxmlLoader.load(); //hacemos un casteo, es nuestro componente raiz lo asosiamos a la Scena
                //se hace un casteo con (pane)
                Scene scene = new Scene(raiz, 750, 650);
                Stage stage =new Stage();
                stage.setTitle("Auto Partes/Menu Principal");
                stage.setScene(scene);
                stage.show();//Muestra el Menu.fxml
                Stage stageLogin = (Stage) txtUsuario.getScene().getWindow();
                stageLogin.close();//cerrar stage o ventana de login y dejar solo menuPrincipal
            }
            else{
                JOptionPane.showMessageDialog(null, "Datos incorrectos","Auto Partes", JOptionPane.ERROR_MESSAGE);
                txtUsuario.setText(""); //Limpiar TextField
                txtContrasena.setText("");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
