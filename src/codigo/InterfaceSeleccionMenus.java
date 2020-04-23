package codigo;

public interface InterfaceSeleccionMenus {

	//Seleccionar los platos del menú
	public MenuElegido seleccionarMenu(String primero, String segundo, String bebida, String postre);
	
	//Coger todos los platos del menú del día
	public void ofrecerMenu();
	
	public ArrayList<String> ofrecerBebidas();
}
