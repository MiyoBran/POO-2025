public abstract class DecoradorOpcionales implements Auto {
	private Auto basico;

	public DecoradorOpcionales (Auto comp) {
		basico = comp;
	}

	public Auto getBasico( ) {
		return basico;
	}
}

