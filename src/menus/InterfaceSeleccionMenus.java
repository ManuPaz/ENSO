package menus;

import java.util.ArrayList;

import Excepciones.NoHayMenuExcepcion;
import Excepciones.PlatoIncorrectoExcepcion;

public interface InterfaceSeleccionMenus {

	//Seleccionar los platos del menu
	public void seleccionarMenu(String primero, String segundo, String bebida, String postre) throws PlatoIncorrectoExcepcion;
	
	//Coger todos los platos del menu del dia
	public Menu ofrecerMenu()  throws NoHayMenuExcepcion;
	
	public ArrayList<String> ofrecerBebidas();
}
