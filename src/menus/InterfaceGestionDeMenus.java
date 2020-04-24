package menus;

import java.util.ArrayList;
import java.util.Date;
import menus.*;

public interface InterfaceGestionDeMenus {

	public void construirMenuDia();
	
	public ArrayList<Plato> obtenerPlatosDisponibles(String tipo);
	
	public Menu obtenerMenuDia(Date fecha);
	
	public ArrayList<Menu> consultarMenusSemana();
}
