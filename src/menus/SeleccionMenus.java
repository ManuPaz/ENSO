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
		bebidas.add("Fanta lim�n");
		bebidas.add("Fanta naranja");
		bebidas.add("Agua con gas");
	}

	@Override
	public void seleccionarMenu() {
		
		GestionPagos GP = new GestionPagos();
		InterfaceGestionDePagosYCalificaciones IntGP = GP;
		MenuElegido menuElegido=new MenuElegido();
		String primero, segundo, postre, bebida;
		
		System.out.println("SELECCIONE SU MENÚ:");
		this.ofrecerMenu();
		System.out.println("--------------------------------------------");
		
		System.out.print("Primero -> ");
		Scanner teclado = new Scanner(System.in);
		primero = teclado.nextLine();
		teclado.close();
		
		System.out.print("Segundo -> ");
		teclado = new Scanner(System.in);
		segundo = teclado.nextLine();
		teclado.close();
		
		System.out.print("Postre -> ");
		teclado = new Scanner(System.in);
		postre = teclado.nextLine();
		teclado.close();
		
		System.out.println("SELECCIONE SU BEBIDA:");
		this.ofrecerBebidas();
		
		System.out.print("Bebida -> ");
		teclado = new Scanner(System.in);
		bebida = teclado.nextLine();
		teclado.close();
		
		//Creamos el menuElegido para pasarselo al sistema de gestion de pagos
		menuElegido.setPrimero(primero);
		menuElegido.setSegundo(segundo);
		menuElegido.setPostre(postre);
		menuElegido.setBebida(bebida);
		
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
		System.out.println("Primeros del día:");
		for(String primero:menu.getPrimeros()) {
			System.out.println("-"+primero);
		}
		
		System.out.println("Segundos del día:");
		
		for(String segundo:menu.getSegundos()) {
			System.out.println("-"+segundo);
		}
		
		System.out.println("Postres del día:");
		
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
