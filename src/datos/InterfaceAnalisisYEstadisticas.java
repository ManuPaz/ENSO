package datos;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import menus.*;

public interface InterfaceAnalisisYEstadisticas {
	
	public ArrayList<String> platoMasPedido();
	
	public ArrayList<String> platoMasValorado();
	
	public ArrayList<String> platoMenosPedido();
	
	public ArrayList<String> platoMenosValorado();
	
	public int ocupacionComedor();
	
	public ArrayList<Integer> horaMasFrecuente();
	
	public int tiempoMedioDuracion();
	
	public ArrayList<Plato> rankingValoracion();
}
