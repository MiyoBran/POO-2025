package tp02.GUI.ej2;


public class PruebaDibujoFiguras {
    public static void main(String[] args) {
        int cantidad = DibujoFiguras.solicitarCantidadFiguras();
        DibujoFiguras dibujo = new DibujoFiguras(cantidad);

        dibujo.setVisible(true);
    }
}
