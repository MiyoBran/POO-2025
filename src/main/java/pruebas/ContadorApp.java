package pruebas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContadorApp extends Application {

    // Declaramos el contador como una variable de la clase
    private int contador = 0;

    @Override
    public void start(Stage primaryStage) {
        
        // 1. Crear los controles
        Label etiquetaContador = new Label("Veces presionado: 0");
        Button botonPresionar = new Button("¡Presióname!");

        // 2. Configurar la acción del botón (el evento)
        botonPresionar.setOnAction(event -> {
            contador++; // Incrementa el contador
            etiquetaContador.setText("Veces presionado: " + contador); // Actualiza el texto de la etiqueta
        });

        // 3. Crear un contenedor para organizar los controles
        // VBox apila los elementos verticalmente
        VBox root = new VBox(20); // 20 es el espaciado entre elementos
        root.setAlignment(Pos.CENTER); // Centra los elementos
        root.getChildren().addAll(etiquetaContador, botonPresionar);

        // 4. Crear la escena y mostrarla
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Contador Simple");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}