package menus;

import java.util.ArrayList;

public interface InterfaceSeleccionMenus {

	//Seleccionar los platos del menu
	public void seleccionarMenu();
	
	//Coger todos los platos del menu del dia
	public void ofrecerMenu();
	
	public ArrayList<String> ofrecerBebidas();
}
