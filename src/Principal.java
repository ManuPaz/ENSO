import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Excepciones.*;
import datos.*;
import menus.*;
import pagosyvaloraciones.*;

public class Principal {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String t=new Date().toString();
		System.out.println(t);
		DateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
		try {
			Date horaAsignacion = formatoHora.parse(t.split(" ")[3]);
			String a=horaAsignacion.toString();
			System.out.println(a);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GestionMenus gM = new GestionMenus();
		InterfaceGestionDeMenus iGM = gM;
		
		SeleccionMenus sM = new SeleccionMenus();
		InterfaceSeleccionMenus iSM = sM;
		
		AnalisisYEstadisticas ae = new AnalisisYEstadisticas();
		InterfaceAnalisisYEstadisticas iAE = ae;
		
		GestionDatos gD = new GestionDatos();
		InterfaceDeGestionDeDatos iGD = gD;
		
		Sensor s = new Sensor();
		InterfaceSensores iS = s;
		
		GestionPagos gP = new GestionPagos();
		InterfaceGestionDePagosYCalificaciones iGPC = gP;

		//Interfaz Seleccion Menus	
		try {
			iSM.ofrecerMenu();
			
			} catch (NoHayMenuExcepcion e) {
				System.out.println(e.getMessage());
			}
		//iSM.ofrecerBebidas();
		//iSM.seleccionarMenu();
		
		//Interfaz Gestion Menu
		ArrayList<String> primero = new ArrayList<>();
		primero.add("Ensaladilla");
		primero.add("Croquetas");
		primero.add("Empanada");
		ArrayList<String> segundo = new ArrayList<>();
		segundo.add("Paella");
		segundo.add("Macarrones con pesto");
		segundo.add("Merluza al horno");
		ArrayList<String> postre = new ArrayList<>();
		postre.add("Natillas");
		postre.add("Yogur de sabores");
		postre.add("Manzana");
		Date fecha = new Date();
		try {
			iGM.construirMenuDia(fecha, primero, segundo, postre);
		} catch (FechaIncorrectaExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PlatoIncorrectoExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		iGM.obtenerMenuDia(fecha);
		iGM.obtenerPlatosDisponibles("primero");
		iGM.consultarMenusSemana();
		
		//Interfaz de Análisis y Estadísticas
		iAE.horaMasFrecuente();
		iAE.ocupacionComedor();
		iAE.platoMasPedido();
		iAE.platoMasValorado();
		iAE.platoMenosPedido();
		iAE.platoMenosValorado();
		iAE.tiempoMedioDuracion();
		iAE.rankingValoracion();
		
		//Interfaz de Gestión de Datos
		iGD.consultarFactura();
		iGD.consultarMenuHoy();
		iGD.consultarMenusSemana();
		iGD.consultarPlatos();
		iGD.consultarValoraciones();
		MenuElegido menuElegido = new MenuElegido("Croquetas", "Paella", "Natillas", "Agua");
		Factura factura = new Factura(6, 34, 5, menuElegido);
		iGD.insertarFactura(factura);
		Menu menu = new Menu(primero,segundo,postre,fecha);
		iGD.insertarMenu(menu);
		Date fecha2 = new Date();
		Valoracion valoracion = new Valoracion(fecha, fecha2, 45, "Croquetas", 10);
		iGD.insertarValoracion(valoracion);
		
		//Interfaz de Sensores
		iS.devolverIdentificadorBandeja();
		iS.devolverIdentificadorVale();
		iS.simularTiempo();
		
		//Interfaz de Gestion de Pagos y Calificaciones
		//iGPC.bandejaDevuelta(hora, identificadorBandeja);
		iGPC.nuevoMenuPedido(menuElegido);
		//iGPC.valoracion(valoracion, plato);
			
			
		}
		
		
	
	}
	