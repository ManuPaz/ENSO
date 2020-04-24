package menus;

import java.util.ArrayList;

public class SeleccionMenus implements InterfaceSeleccionMenus{

	private ArrayList<String> bebidas;
	
	public void SeleccionMenus() {
		bebidas = new ArrayList<>();
		bebidas.add("Agua");
		bebidas.add("CocaCola");
		bebidas.add("Nestea");
		bebidas.add("Fanta limón");
		bebidas.add("Fanta naranja");
		bebidas.add("Agua con gas");
	}

	@Override
	public MenuElegido seleccionarMenu(String primero, String segundo, String bebida, String postre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ofrecerMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> ofrecerBebidas() {
		// TODO Auto-generated method stub
		return null;
	}
}
