import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Excepciones.*;
import datos.*;
import menus.*;
import pagosyvaloraciones.*;

public class Principal {

	/**
	 * @param args
	 * @throws PlatoIncorrectoExcepcion 
	 * @throws FechaIncorrectaExcepcion 
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		GestionMenus gM = new GestionMenus();
		InterfaceGestionDeMenus iGM = gM;

		AnalisisYEstadisticas ae = new AnalisisYEstadisticas();
		InterfaceAnalisisYEstadisticas iAE = ae;

		GestionDatos gD = new GestionDatos();
		InterfaceDeGestionDeDatos iGD = gD;

		Sensor s = new Sensor();
		InterfaceSensores iS = s;

		GestionPagos gP = new GestionPagos(iS);
		InterfaceGestionDePagosYCalificaciones iGPC = gP;
		
		Date fecha= new Date();

		// SUBSISTEMA DE GESTION DE MENÚS
		//Obtener menú del día
		iGM.obtenerMenuDia();
		
		//Consultar menú semanal
		iGM.consultarMenusSemana();
		
		//Obtener platos disponibles en el menú
		iGM.obtenerPlatosDisponibles("primero");
		iGM.obtenerPlatosDisponibles("segundo");
		iGM.obtenerPlatosDisponibles("postre");
		
		//Construir menú del día
		ArrayList<String> primerosPlatos = new ArrayList<>();
		ArrayList<String> segundosPlatos = new ArrayList<>();
		ArrayList<String> platosPostres = new ArrayList<>();
		primerosPlatos.add("Sopa");
		primerosPlatos.add("Empanada");
		primerosPlatos.add("Ensaladilla");
		segundosPlatos.add("Lasaña de verduras");
		segundosPlatos.add("Raxo con patatas");
		segundosPlatos.add("Merluza a la gallega");
		platosPostres.add("Arroz con leche");
		platosPostres.add("Natillas");
		platosPostres.add("Fruta");
		try {
			iGM.construirMenuDia(fecha, primerosPlatos, segundosPlatos, platosPostres);
		} catch (FechaIncorrectaExcepcion | PlatoIncorrectoExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		// SUBSISTEMA DE ANÁLISIS Y ESTADÍSTICAS
		iAE.horaMasFrecuente();
		iAE.ocupacionComedor();
		iAE.platoMasPedido();
		iAE.platoMasValorado();
		iAE.platoMenosPedido();
		iAE.platoMenosValorado();
		iAE.tiempoMedioDuracion();
		iAE.rankingValoracion();
		
		
		
		

		// SUBSISTEMA DE GESTION DE DATOS
		// Insertar factura
		MenuElegido menuElegido = new MenuElegido("Sopa de fideos", "Lubina a la plancha", "Flan", "Agua con gas");
		Factura factura = new Factura(6, 90, 123, menuElegido);
		gD.insertarFactura(factura);
		gD.insertarFactura(null);

		// Consultar platos
		ArrayList<Plato> platos = new ArrayList<>();
		gD.consultarPlatos();

		// Insertar valoraciones
		Date ahora = new Date();
		Date despues = new Date();
		Valoracion valoracion = new Valoracion(ahora, despues, 123, "Flan", 5);
		gD.insertarValoracion(valoracion);
		gD.insertarValoracion(null);

		// Consultar valoraciones
		gD.consultarValoraciones();

		// Consultar Menu Semana
		gD.consultarMenusSemana();

		// Consultar Menu Hoy
		Menu menu = gD.consultarMenuHoy();

		// Insertar menu
		ArrayList<String> primeros = new ArrayList<>();
		ArrayList<String> segundos = new ArrayList<>();
		ArrayList<String> postres = new ArrayList<>();
		primeros.add("Sopa");
		primeros.add("Empanada");
		primeros.add("Ensaladilla");
		segundos.add("Lasaña de verduras");
		segundos.add("Raxo con patatas");
		segundos.add("Merluza a la gallega");
		postres.add("Arroz con leche");
		postres.add("Natillas");
		postres.add("Fruta");
		ahora = new Date();
		menu = new Menu(primeros, segundos, postres, ahora);
		gD.insertarMenu(menu);

		// Consultar Factura
		gD.consultarFactura();

	}

}
