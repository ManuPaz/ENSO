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
		// SUBSISTEMA DE GESTION DE MENUS
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
			
		}
		//Obtener menu del dia
		//iGM.obtenerMenuDia();
		
		//Consultar menu semanal
			
				iGM.consultarMenusSemana();
				
				//Obtener platos disponibles en el menu
				iGM.obtenerPlatosDisponibles("primero");
				iGM.obtenerPlatosDisponibles("segundo");
				iGM.obtenerPlatosDisponibles("postre");
				
				

	
		
		
		

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
		primeros.add("Pizza");
		primeros.add("Empanada");
		primeros.add("Ensalada mixta");
		segundos.add("Pollo al limon");
		segundos.add("Jureles fritos");
		segundos.add("Paella");
		postres.add("Flan");
		postres.add("Natillas");
		postres.add("Fresas con nata");
		ahora = new Date();
		Date date=new Date(ahora.getTime()+28*3600*1000);
		menu = new Menu(primeros, segundos, postres, date);
		iGD.insertarMenu(menu);

		// Consultar Factura
		iGD.consultarFactura();
		
	
				
		
		
		//SUBSISTEMA DE GESTION DE PAGOS Y CALIFICACIONES Y SUBSISTEMA DE SENSORES
		//Creamos un menuElgido
		MenuElegido menuElegido2 = new MenuElegido ("Sopa","Merluza a la gallega","Natillas","Agua");
		iGPC.nuevoMenuPedido(menuElegido2);
		int codigo= s.getIdBandeja().get(0);
		iGPC.nuevoMenuPedido(menuElegido2);
		int codigo2= s.getIdBandeja().get(1);
		//Simulamos la devolucion de la bandeja ayudandonos del subsistema de sensores
		//Se pueden pagar varios menus y despues devolver las bandejas en diferente orden
		iS.simularDevolucionBandeja(iGPC, codigo);
		iS.simularDevolucionBandeja(iGPC, codigo2);
		//Valoramos un plato consumido
		iGPC.valoracion(10, "Sopa" ,codigo);
		iGPC.valoracion(10, "Sopa" ,codigo2);
		//estas funciones se llaman desde otras interfaces, no tendria sentido llamarlas desde aqui
		iS.devolverIdentificadorBandeja();
		iS.devolverIdentificadorVale();
		iGPC.bandejaDevuelta(new Date(), 12);
		
		// SUBSISTEMA DE ANALISIS Y ESTADISTICAS
		iAE.horaMasFrecuente();
		iAE.ocupacionComedor();
		iAE.platoMasPedido();
		iAE.platoMasValorado();
		iAE.platoMenosPedido();
		iAE.platoMenosValorado();
		iAE.tiempoMedioDuracion();
		iAE.rankingValoracion();
		
		//SUBSITEMA DE SELECCION DE MENUS
		String primero="Fabada";
		String segundo="Paella";
		String bebida="Agua";
		String postre="Natillas";
		
		try {
			iSM.seleccionarMenu(primero, segundo, bebida, postre);
		} catch (PlatoIncorrectoExcepcion e) {
			// TODO Auto-generated catch block
			
			
		}
		
		try {
			iSM.ofrecerMenu();
		} catch (NoHayMenuExcepcion e) {
			// TODO Auto-generated catch block
			
		
		}
		
		iSM.ofrecerBebidas();	
	}

}