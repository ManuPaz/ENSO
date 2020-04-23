package codigo;

public interface InterfaceDeGestionDeDatos {

	public void insertarFactura(Factura factura);
	
	public ArrayList<Plato> consultarPlatos();
	
	public void insertarValoracion(Valoracion valoracion);
	
	public ArrayList<Valoracion> consultarValoraciones();
	
	public void insertarMenu(Menu menu);
	
	public ArrayList<Menu> consultarMenusSemana();
	
	public Menu consultarMenuHoy();
	
	public ArrayList<Factura> consultarFactura();
}
