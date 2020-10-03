import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Keillie Sicaja y Allan Castillo
 * Clase Main para darle inicio al sistema
 */
public class Main extends Application {
    /**
     * Metodo implentado de extends Application
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane layout = (Pane) FXMLLoader.load(getClass().getResource("/view/Login.fxml")); //se realiza la carga  layout regresa un componente generico
        //se hace un casteo con (pane)
        Scene scene = new Scene(layout, 550, 500);
        stage.setTitle("Auto Partes");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo de tipo ejecutable para accionar el programa
     * se hereda metodo de applicaction
     * @param args
     */
    public static void main(String[] args) {
        launch(args); //lauch pertene a la clase application por eso tenemos acceso a ella
    }
}
