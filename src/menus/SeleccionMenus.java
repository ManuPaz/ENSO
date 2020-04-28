package menus;

import java.util.ArrayList;

import Excepciones.NoHayMenuExcepcion;
import Excepciones.PlatoIncorrectoExcepcion;
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
		
		Menu menu=IntGM.obtenerMenuDia();
	
		if(menu!=null) {
		
			if(!menu.getPrimeros().contains(primero))
				throw new PlatoIncorrectoExcepcion("Primero introducido invalido.");
			menuElegido.setPrimero(primero);

		
			if(!menu.getSegundos().contains(segundo))
				throw new PlatoIncorrectoExcepcion("Segundo introducido invalido.");
			menuElegido.setSegundo(segundo);

		
			if(!menu.getPostres().contains(postre))
				throw new PlatoIncorrectoExcepcion("Postre introducido invalido.");
			menuElegido.setPostre(postre);
		
			if(!this.bebidas.contains(bebida))
				throw new PlatoIncorrectoExcepcion("Bebida introducida invalida.");
			menuElegido.setBebida(bebida);	
		
			gp.nuevoMenuPedido(menuElegido);
		}
	}

	@Override
	public Menu ofrecerMenu() throws NoHayMenuExcepcion {
		GestionMenus GM = new GestionMenus();
		InterfaceGestionDeMenus IntGM = GM;
		
		Menu menu=IntGM.obtenerMenuDia();
		
		
		if(menu==null) {
			 throw new NoHayMenuExcepcion();
			
		}
		return menu;
		
	}

	@Override
	public ArrayList<String> ofrecerBebidas() {
		
		return this.bebidas;
	}
}

