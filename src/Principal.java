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
		MenuElegido menu=new MenuElegido("Croquetas","Paella","Flan","Agua");
		gP.nuevoMenuPedido(menu);
		s.simularTiempo();
		gP.bandejaDevuelta(new Date());
		
		
			
			
		}
		
		
	
	}
	