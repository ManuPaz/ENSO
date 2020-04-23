package PrjGrupo1A;

public interface InterfaceGestionDeMenus {

	public void construirMenuDia(Date fecha; ArrayList<String> primeros, ArrayList<String> segundos, ArrayList<String> postres);
	
	public ArrayList<Plato> obtenerPlatosDisponibles();
	
	public Menu obtenerMenuDia(Date fecha);
	
	public ArrayList<Menu> consultarMenusSemana();
}
