package menus;

import java.util.ArrayList;
import java.util.Date;

import Excepciones.FechaIncorrectaExcepcion;
import Excepciones.PlatoIncorrectoExcepcion;
import menus.*;

public interface InterfaceGestionDeMenus {

	public void construirMenuDia(Date fecha,ArrayList<String> primero,ArrayList<String> segundo,ArrayList<String>postre) throws FechaIncorrectaExcepcion , PlatoIncorrectoExcepcion;
	
	public ArrayList<Plato> obtenerPlatosDisponibles(String tipo);
	
	public Menu obtenerMenuDia();
	
	public ArrayList<Menu> consultarMenusSemana();
}
