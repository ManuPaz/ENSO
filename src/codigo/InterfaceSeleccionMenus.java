package codigo;

public interface InterfaceSeleccionMenus {

	//Seleccionar los platos del men�
	public MenuElegido seleccionarMenu(String primero, String segundo, String bebida, String postre);
	
	//Coger todos los platos del men� del d�a
	public void ofrecerMenu();
	
	public ArrayList<String> ofrecerBebidas();
}
