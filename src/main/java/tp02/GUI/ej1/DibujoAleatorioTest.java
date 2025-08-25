package tp02.GUI.ej1;


public class DibujoAleatorioTest {
    public static void main(String[] args) {
        int cantidad = Dibujo.solicitarCantidadFiguras();
        Dibujo dibujo = new Dibujo(cantidad);

        dibujo.setVisible(true);
    }
}
