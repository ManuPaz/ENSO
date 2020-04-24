package menus;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import datos.GestionDatos;
import datos.InterfaceDeGestionDeDatos;

public class GestionMenus implements InterfaceGestionDeMenus{

	@Override
	public void construirMenuDia() {
		
		GestionDatos GD = new GestionDatos();
		InterfaceDeGestionDeDatos IntGD = GD;
		Menu menuDelDia = new Menu();
		Date fecha= new Date();
		
		//Platos disponibles en el sistema
		ArrayList<Plato> primerosDisponibles=this.obtenerPlatosDisponibles("Primero");
		ArrayList<Plato> segundosDisponibles=this.obtenerPlatosDisponibles("Segundo");
		ArrayList<Plato> postresDisponibles=this.obtenerPlatosDisponibles("Postre");
		
		//Elementos del menu
		ArrayList<String> primeros=new ArrayList<String>();
		ArrayList<String> segundos=new ArrayList<String>();
		ArrayList<String> postres=new ArrayList<String>();

		//Tres menus distintos para cada dia
		for(int i=0;i<3;i++) {
			System.out.println("PRIMEROS ->");
			for(Plato primero:primerosDisponibles) {
				System.out.println("-"+primero.getNombre());
			}
			
			System.out.print("Elección ->");
			Scanner teclado = new Scanner(System.in);
			primeros.add(teclado.nextLine());
			teclado.close();
			
			System.out.println("SEGUNDOS ->");
			for(Plato segundo:segundosDisponibles) {
				System.out.println("-"+segundo.getNombre());
			}
			
			System.out.print("Elección ->");
			teclado = new Scanner(System.in);
			segundos.add(teclado.nextLine());
			teclado.close();
			
			System.out.println("POSTRES ->");
			for(Plato postre:postresDisponibles) {
				System.out.println("-"+postre.getNombre());
			}
			
			System.out.print("Elección ->");
			teclado = new Scanner(System.in);
			postres.add(teclado.nextLine());
			teclado.close();
		}
		
		menuDelDia.setPrimeros(primeros);
		menuDelDia.setSegundos(segundos);
		menuDelDia.setPostres(postres);
		menuDelDia.setFecha(fecha);
		
		IntGD.insertarMenu(menuDelDia);;
		
	}

	@Override
	public ArrayList<Plato> obtenerPlatosDisponibles(String tipo) {

		GestionDatos GD = new GestionDatos();
		InterfaceDeGestionDeDatos IntGD = GD;
		Menu menuDelDia = new Menu();
		
		ArrayList<Plato> platosDisponibles=IntGD.consultarPlatos();
		
		for(Plato plato:platosDisponibles) {
			if(plato.getTipo().equals(tipo)) {
				platosDisponibles.add(plato);
			}
		}
		
		return platosDisponibles;
	}

	@Override
	public Menu obtenerMenuDia(Date fecha) {
		
		GestionDatos GD = new GestionDatos();
		InterfaceDeGestionDeDatos IntGD = GD;
		
		return IntGD.consultarMenuHoy();
	}

	@Override
	public ArrayList<Menu> consultarMenusSemana() {
		
		GestionDatos GD = new GestionDatos();
		InterfaceDeGestionDeDatos IntGD = GD;
		
		return IntGD.consultarMenusSemana();
	}

}
