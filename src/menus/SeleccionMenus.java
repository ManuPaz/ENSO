package menus;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Excepciones.NoHayMenuExcepcion;
import Excepciones.PlatoIncorrectoExcepcion;
import pagosyvaloraciones.GestionPagos;
import pagosyvaloraciones.InterfaceGestionDePagosYCalificaciones;

public class SeleccionMenus implements InterfaceSeleccionMenus{

	private ArrayList<String> bebidas;
	private InterfaceGestionDePagosYCalificaciones gp;
	
	public  SeleccionMenus(InterfaceGestionDePagosYCalificaciones gp) {
		bebidas = new ArrayList<>();
		bebidas.add("Agua");
		bebidas.add("CocaCola");
		bebidas.add("Nestea");
		bebidas.add("Fanta limon");
		bebidas.add("Fanta naranja");
		bebidas.add("Agua con gas");
		this.gp=gp;
	}

	@Override
	public void seleccionarMenu(String primero, String segundo, String bebida, String postre) throws PlatoIncorrectoExcepcion {
		
		MenuElegido menuElegido=new MenuElegido();
		
		
		
		GestionMenus GM = new GestionMenus();
		InterfaceGestionDeMenus IntGM = GM;
		Date fechaActual=new Date();
		
		Menu menu=IntGM.obtenerMenuDia(fechaActual);
		
		System.out.println("MENÚ SELECCIONADO:");
		System.out.println("--------------------------------------------");
		if(menu!=null) {
		
			if(!menu.getPrimeros().contains(primero)) {
				throw new PlatoIncorrectoExcepcion("Primero introducido inválido.");
			}else {
				System.out.println("Primero -> "+primero);
				menuElegido.setPrimero(primero);
				
			}
		
		
		
			if(!menu.getSegundos().contains(segundo)) {
				throw new PlatoIncorrectoExcepcion("Segundo introducido inválido.");
			}else {
				System.out.println("Segundo -> "+segundo);
				menuElegido.setSegundo(segundo);
				
			}
		
			if(!menu.getPostres().contains(postre)) {
				throw new PlatoIncorrectoExcepcion("Postre introducido inválido.");
			}else {
				System.out.println("Postre -> "+postre);
				menuElegido.setPostre(postre);
				
			}
		
		
		
			if(!this.bebidas.contains(bebida)) {
				throw new PlatoIncorrectoExcepcion("Bebida introducida inválida.");
			}else {
				System.out.println("Bebida -> "+bebida);
				menuElegido.setBebida(bebida);
				
			}
		
		
		gp.nuevoMenuPedido(menuElegido);
		}
	}

	@Override
	public void ofrecerMenu() throws NoHayMenuExcepcion {
		GestionMenus GM = new GestionMenus();
		InterfaceGestionDeMenus IntGM = GM;
		Date fechaActual=new Date();
		
		Menu menu=IntGM.obtenerMenuDia(fechaActual);
		
		
		if(menu==null) {
			 throw new NoHayMenuExcepcion();
			
		}
		System.out.println("Primeros del dia:");
		for(String primero:menu.getPrimeros()) {
			System.out.println("-"+primero);
		}
		
		System.out.println("Segundos del dia:");
		
		for(String segundo:menu.getSegundos()) {
			System.out.println("-"+segundo);
		}
		
		System.out.println("Postres del dia:");
		
		for(String postre:menu.getPostres()) {
			System.out.println("-"+postre);
		}
		
	}

	@Override
	public ArrayList<String> ofrecerBebidas() {
		
		for(String bebida:this.bebidas) {
			System.out.print("-"+bebida);
		}
		
		return null;
	}
}
