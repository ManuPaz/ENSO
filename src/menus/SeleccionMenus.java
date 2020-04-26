package menus;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Excepciones.NoHayMenuExcepcion;
import pagosyvaloraciones.GestionPagos;
import pagosyvaloraciones.InterfaceGestionDePagosYCalificaciones;

public class SeleccionMenus implements InterfaceSeleccionMenus{

	private ArrayList<String> bebidas;
	
	public void SeleccionMenus() {
		bebidas = new ArrayList<>();
		bebidas.add("Agua");
		bebidas.add("CocaCola");
		bebidas.add("Nestea");
		bebidas.add("Fanta limon");
		bebidas.add("Fanta naranja");
		bebidas.add("Agua con gas");
	}

	@Override
	public void seleccionarMenu(String primero, String segundo, String bebida, String postre) {
		
		MenuElegido menuElegido=new MenuElegido();
		
		GestionPagos GP = new GestionPagos();
		InterfaceGestionDePagosYCalificaciones IntGP = GP;
		
		GestionMenus GM = new GestionMenus();
		InterfaceGestionDeMenus IntGM = GM;
		Date fechaActual=new Date();
		
		Menu menu=IntGM.obtenerMenuDia(fechaActual);
		
		System.out.println("MENÚ SELECCIONADO:");
		System.out.println("--------------------------------------------");
		
		for(String plato:menu.getPrimeros()) {
			if(!plato.equals(primero)) {
				System.out.println("Primero introducido no válido.");
			}else {
				System.out.print("Primero -> "+primero);
				menuElegido.setPrimero(primero);
				break;
			}
		}
		
		for(String plato:menu.getSegundos()) {
			if(!plato.equals(segundo)) {
				System.out.println("Segundo introducido no válido.");
			}else {
				System.out.print("Segundo -> "+segundo);
				menuElegido.setSegundo(segundo);
				break;
			}
		}
				
		for(String pos:menu.getPostres()) {
			if(!pos.equals(primero)) {
				System.out.println("Postre introducido no válido.");
			}else {
				System.out.print("Postre -> "+postre);
				menuElegido.setPostre(postre);
				break;
			}
		}
		
		for(String beb:bebidas) {
			if(!beb.equals(bebida)) {
				System.out.println("Bebida introducida no válida.");
			}else {
				System.out.print("Bebida -> "+bebida);
				menuElegido.setBebida(bebida);
				break;
			}
		}
		
		IntGP.nuevoMenuPedido(menuElegido);
		
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
