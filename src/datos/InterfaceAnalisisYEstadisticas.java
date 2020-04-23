package datos;

import java.util.ArrayList;
import java.util.Date;
import menus.*;

public interface InterfaceAnalisisYEstadisticas {
	
	public String platoMasPedido();
	
	public String platoMasValorado();
	
	public String platoMenosPedido();
	
	public String platoMenosValorado();
	
	public int ocupacionComedor();
	
	public Date horaMasFrecuente();
	
	public Date tiempoMedioDuracion();
	
	public ArrayList<Plato> rankingValoracion();
}
