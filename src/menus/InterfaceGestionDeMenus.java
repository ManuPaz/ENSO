package menus;

import java.util.ArrayList;
import java.util.Date;
import menus.*;

public interface InterfaceGestionDeMenus {

	public void construirMenuDia(Date fecha, ArrayList<String> primeros, ArrayList<String> segundos, ArrayList<String> postres);
	
	public ArrayList<Plato> obtenerPlatosDisponibles();
	
	public Menu obtenerMenuDia(Date fecha);
	
	public ArrayList<Menu> consultarMenusSemana();
}
