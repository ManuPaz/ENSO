import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Excepciones.FechaIncorrectaExcepcion;
import Excepciones.NoHayMenuExcepcion;
import Excepciones.PlatoIncorrectoExcepcion;
import datos.InterfaceDeGestionDeDatos;
import menus.GestionMenus;
import menus.InterfaceGestionDeMenus;
import menus.InterfaceSeleccionMenus;
import menus.SeleccionMenus;

public class Principal {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hola");
		System.out.println("Adios");
		System.out.println("Adios");
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
		GestionMenus gM=new GestionMenus();
		InterfaceGestionDeMenus iGM=gM;
		SeleccionMenus sM=new SeleccionMenus();
		InterfaceSeleccionMenus iSM= sM;
		while (true) {
			Scanner scanner=new Scanner(System.in);
			System.out.println("1-> Consultar menu hoy \n 2 -> Consultar menus semana "
					+ "3 -> Construir menu hoy 4 -> Selccionar menu ");
				String a=scanner.nextLine();
				switch(a) {
				case "1":
					try {
						iSM.ofrecerMenu();
					} catch (NoHayMenuExcepcion e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					break;
				case "2":
					iGM.consultarMenusSemana();
					break;
				case "3":
				
						gM.construirMenuDia();
				
					break;
				case "4": 
					iSM.seleccionarMenu();
					break;
				
				}
			
			
		}
		
		
	
	}
	
	
}
