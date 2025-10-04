package pruebas;

// --- IMPORTS PARA LA ANOTACIÓN @FXML Y LOS CONTROLES ---
import javafx.fxml.FXML;               // La anotación que conecta el FXML con el código.
import javafx.scene.control.Button;    // El control del botón.
import javafx.scene.control.Label;     // El control de la etiqueta.
import javafx.scene.control.TextField;  // El control del campo de texto.

// --- IMPORT PARA EL MANEJO DE EVENTOS ---
import javafx.event.ActionEvent;      // Representa la acción del usuario (ej. un clic).

public class BienvenidaController {

    // --- CONEXIÓN CON LOS CONTROLES DEL FXML ---
    // El nombre de estas variables DEBE COINCIDIR con el 'fx:id' puesto en Scene Builder.
    
    @FXML
    private TextField nombreTextField;

    @FXML
    private Button saludarButton;

    @FXML
    private Label mensajeLabel;

    // --- MÉTODO CONECTADO AL 'onAction' DEL BOTÓN EN SCENE BUILDER ---
    // El nombre de este método DEBE COINCIDIR con el 'On Action' puesto en Scene Builder.
    
    @FXML
    void onSaludarButtonClick(ActionEvent event) {
        String nombre = nombreTextField.getText();
        
        if (nombre.isEmpty()) {
            mensajeLabel.setText("Por favor, introduce tu nombre.");
        } else {
            mensajeLabel.setText("¡Bienvenido/a, " + nombre + "!");
        }
    }
}