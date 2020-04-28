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
		
		SeleccionMenus sM = new SeleccionMenus(iGPC);
		InterfaceSeleccionMenus iSM = sM;
		
		
		Date fecha= new Date();
		

		// SUBSISTEMA DE ANALISIS Y ESTADISTICAS
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
		iGD.insertarFactura(factura);
		iGD.insertarFactura(null);

		// Consultar platos
		iGD.consultarPlatos();

		// Insertar valoraciones
		Date ahora = new Date();
		Date despues = new Date();
		Valoracion valoracion = new Valoracion(ahora, despues, 123, "Flan", 5);
		iGD.insertarValoracion(valoracion);
		iGD.insertarValoracion(null);

		// Consultar valoraciones
		iGD.consultarValoraciones();

		// Consultar Menu Semana
		iGD.consultarMenusSemana();

		// Consultar Menu Hoy
		Menu menu = iGD.consultarMenuHoy();

		// Insertar menu
		ArrayList<String> primeros = new ArrayList<>();
		ArrayList<String> segundos = new ArrayList<>();
		ArrayList<String> postres = new ArrayList<>();
		primeros.add("Sopa");
		primeros.add("Empanada");
		primeros.add("Ensaladilla");
		segundos.add("Lasanha de verduras");
		segundos.add("Raxo con patatas");
		segundos.add("Merluza a la gallega");
		postres.add("Arroz con leche");
		postres.add("Natillas");
		postres.add("Fruta");
		ahora = new Date();
		menu = new Menu(primeros, segundos, postres, ahora);
		iGD.insertarMenu(menu);

		// Consultar Factura
		iGD.consultarFactura();
		
		
		
		// SUBSISTEMA DE GESTION DE MENUS
		//Obtener menu del dia
		iGM.obtenerMenuDia();
		
		//Consultar menu semanal
		iGM.consultarMenusSemana();
		
		//Obtener platos disponibles en el menu
		iGM.obtenerPlatosDisponibles("primero");
		iGM.obtenerPlatosDisponibles("segundo");
		iGM.obtenerPlatosDisponibles("postre");
		
		//Construir menu del dia
		ArrayList<String> primerosPlatos = new ArrayList<>();
		ArrayList<String> segundosPlatos = new ArrayList<>();
		ArrayList<String> platosPostres = new ArrayList<>();
		primerosPlatos.add("Fabada");
		primerosPlatos.add("Empanada");
		primerosPlatos.add("Ensaladilla");
		segundosPlatos.add("Paella");
		segundosPlatos.add("Pollo al limon");
		segundosPlatos.add("Merluza al horno");
		platosPostres.add("Arroz con leche");
		platosPostres.add("Natillas");
		platosPostres.add("Manzana");
		try {
			iGM.construirMenuDia(fecha, primerosPlatos, segundosPlatos, platosPostres);
		} catch (FechaIncorrectaExcepcion | PlatoIncorrectoExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//SUBSITEMA DE SELECCION DE MENUS
		String primero="Sopa";
		String segundo="Merluza a la gallega";
		String bebida="Agua";
		String postre="Fruta";
		
		try {
			iSM.seleccionarMenu(primero, segundo, bebida, postre);
		} catch (PlatoIncorrectoExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			iSM.ofrecerMenu();
		} catch (NoHayMenuExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		iSM.ofrecerBebidas();
		
		//SUBSISTEMA DE GESTION DE PAGOS Y CALIFICACIONES 
		//Creamos el menu
		MenuElegido menuElegido2 = new MenuElegido ("Croquetas","Paella","Natillas","Agua");
		iGPC.nuevoMenuPedido(menuElegido2);
		//Simulamos la devolucion de la bandeja ayudandonos del subsistema de sensores
		int codigo= s.getIdBandeja().get(0);
		Date hora = new Date();
		iGPC.bandejaDevuelta(hora, codigo);
		iS.simularDevolucionBandeja(iGPC, codigo);
		//Valoramos un plato consumido
		iGPC.valoracion(10, "Croquetas" ,codigo);

		//SUBSISTEMA DE SENSORES
		iS.devolverIdentificadorBandeja();
		iS.devolverIdentificadorVale();

	}

}