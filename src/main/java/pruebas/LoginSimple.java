package pruebas;

// --- IMPORTS ESENCIALES PARA LA APLICACIÓN Y LA VENTANA ---
import javafx.application.Application; // Obligatorio: Es la base de cualquier app JavaFX.
import javafx.stage.Stage;             // Obligatorio: Representa la ventana principal.

// --- IMPORTS PARA LA ESCENA Y SU CONTENIDO ---
import javafx.scene.Scene;             // Obligatorio: Es el "lienzo" donde se dibuja todo.

// --- IMPORTS PARA LOS CONTENEDORES (LAYOUTS) ---
import javafx.scene.layout.VBox;       // Contenedor que apila elementos en vertical.
import javafx.scene.layout.HBox;       // Contenedor que apila elementos en horizontal.
import javafx.geometry.Insets;        // Para añadir márgenes y espaciados (padding).
import javafx.geometry.Pos;          // Para alinear los elementos (ej. centrarlos).

// --- IMPORTS PARA LOS CONTROLES (WIDGETS) ---
import javafx.scene.control.Label;     // Para mostrar texto.
import javafx.scene.control.TextField;  // Campo para que el usuario escriba.
import javafx.scene.control.Button;    // El botón para la acción.
import javafx.scene.control.PasswordField; // Campo de texto que oculta los caracteres.


public class LoginSimple extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        // --- CREACIÓN DE CONTROLES ---
        Label usuarioLabel = new Label("Usuario:");
        TextField usuarioTextField = new TextField();
        
        Label contrasenaLabel = new Label("Contraseña:");
        PasswordField contrasenaPasswordField = new PasswordField();
        
        Button loginButton = new Button("Iniciar Sesión");
        Label mensajeLabel = new Label(); // Una etiqueta vacía para mostrar mensajes.

        // --- ACCIÓN DEL BOTÓN ---
        loginButton.setOnAction(event -> {
            String usuario = usuarioTextField.getText();
            String contrasena = contrasenaPasswordField.getText();
            
            if (usuario.equals("admin") && contrasena.equals("1234")) {
                mensajeLabel.setText("¡Bienvenido, " + usuario + "!");
            } else {
                mensajeLabel.setText("Usuario o contraseña incorrectos.");
            }
        });

        // --- ORGANIZACIÓN EN CONTENEDORES ---
        // Contenedor para el usuario
        HBox usuarioBox = new HBox(10, usuarioLabel, usuarioTextField);
        usuarioBox.setAlignment(Pos.CENTER_LEFT);

        // Contenedor para la contraseña
        HBox contrasenaBox = new HBox(10, contrasenaLabel, contrasenaPasswordField);
        contrasenaBox.setAlignment(Pos.CENTER_LEFT);
        
        // Contenedor principal que apila todo verticalmente
        VBox root = new VBox(15, usuarioBox, contrasenaBox, loginButton, mensajeLabel);
        root.setPadding(new Insets(20)); // Añade un margen de 20 píxeles alrededor.
        root.setAlignment(Pos.CENTER);   // Centra todo el contenido.

        // --- CREACIÓN Y VISUALIZACIÓN DE LA ESCENA ---
        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Login Simple (Sin FXML)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}