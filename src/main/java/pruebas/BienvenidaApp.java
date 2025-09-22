package pruebas;

// --- IMPORTS ESENCIALES PARA LA APLICACIÓN Y LA VENTANA ---
import javafx.application.Application; // Obligatorio: Es la base.
import javafx.stage.Stage;             // Obligatorio: La ventana.

// --- IMPORTS PARA CARGAR EL ARCHIVO FXML ---
import javafx.fxml.FXMLLoader;         // El cargador de archivos FXML.
import javafx.scene.Parent;             // El tipo de nodo raíz que devuelve el cargador.
import javafx.scene.Scene;             // El lienzo para mostrar el contenido cargado.

// --- IMPORTS PARA MANEJAR ERRORES DE LECTURA DE ARCHIVO ---
import java.io.IOException;

public class BienvenidaApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Carga el diseño desde el archivo FXML.
            // getClass().getResource() busca el archivo en la misma ubicación que esta clase.
            Parent root = FXMLLoader.load(getClass().getResource("BienvenidaVentana.fxml"));
            
            // Crea la escena con el contenido cargado.
            Scene scene = new Scene(root);
            
            // Configura y muestra la ventana.
            primaryStage.setTitle("Bienvenida (Con FXML)");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo FXML.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}