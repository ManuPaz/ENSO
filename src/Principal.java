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
		
		
		GestionMenus gM = new GestionMenus();
		InterfaceGestionDeMenus iGM = gM;
		
		AnalisisYEstadisticas ae = new AnalisisYEstadisticas();
		InterfaceAnalisisYEstadisticas iAE = ae;
		
		GestionDatos gD = new GestionDatos();
		InterfaceDeGestionDeDatos iGD = gD;
		
		Sensor s = new Sensor();
		InterfaceSensores iS = s;
		
		GestionPagos gP = new GestionPagos();
		InterfaceGestionDePagosYCalificaciones iGPC = gP;

		
		
		System.out.println(iAE.horaMasFrecuente());
		System.out.println(iAE.ocupacionComedor());
		System.out.println(iAE.platoMasPedido());
		System.out.println(iAE.platoMasValorado());
		System.out.println(iAE.platoMenosPedido());
		System.out.println(iAE.platoMenosValorado());
		System.out.println(iAE.tiempoMedioDuracion());
		System.out.println(iAE.rankingValoracion());
	
		
		System.out.println("\nPruebas de GestionDatos--------------------------");
			System.out.println(">Insertar factura");
			MenuElegido menuElegido = new MenuElegido("Sopa de fideos","Lubina a la plancha", "Flan", "Agua con gas"); 
			Factura factura = new Factura(6, 90, 123, menuElegido);
			gD.insertarFactura(factura);
			gD.insertarFactura(null); //ver que no da error
			
			System.out.println("\n>Consultar platos");
			ArrayList<Plato> platos= new ArrayList<>();
			platos = gD.consultarPlatos();
			System.out.println(platos);
			
			System.out.println("\n>Insertar valoraciones");
			Date ahora = new Date();
			Date despues = new Date();
			Valoracion valoracion = new  Valoracion(ahora,despues,123, "Flan", 5);
			gD.insertarValoracion(valoracion);
			gD.insertarValoracion(null); //ver que no da error
			
			System.out.println("\n>Consultar valoraciones");
			ArrayList<Valoracion> valoraciones= new ArrayList<>();
			valoraciones = gD.consultarValoraciones();
			for(int i=0; i<valoraciones.size(); i++) {
				System.out.println(valoraciones.get(i).getPlato() + " " + valoraciones.get(i).getPuntuacion());
			}
			
			System.out.println("\n>Consultar Menu Semana");
			ArrayList<Menu> menus= new ArrayList<>();
			menus = gD.consultarMenusSemana();
			if(menus!=null) {
				for(int i=0; i<menus.size(); i++) {
					System.out.println(menus.get(i).getFecha() + " " + menus.get(i).getPrimeros());
				}
			}
				
			System.out.println("\n>Consultar Menu Hoy");
		    Menu menu = gD.consultarMenuHoy();
		    if(menu!=null) {
		    	System.out.println(menu.getFecha() + " " + menu.getPrimeros());
		    }
			
			System.out.println("\n>Insertar menu");
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
			gD.insertarMenu(menu); //insertamos un menu
			
			System.out.println("\n>Consultar Factura");
			ArrayList<Factura> facturas = new ArrayList<>();
			facturas = gD.consultarFactura();
			for(int i=0; i<facturas.size(); i++) {
				System.out.println(facturas.get(i).getIdVale() + " " + facturas.get(i).getImporte());
			}
			
			System.out.println("Fin pruebas GestionDatos---------------------------");
		}
		
		
	
	}
	