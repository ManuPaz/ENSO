package menus;

import java.util.ArrayList;
import java.util.Date;
import Excepciones.FechaIncorrectaExcepcion;
import Excepciones.PlatoIncorrectoExcepcion;
import datos.GestionDatos;
import datos.InterfaceDeGestionDeDatos;

public class GestionMenus implements InterfaceGestionDeMenus{
	
	public void construirMenuDia(Date fecha, ArrayList<String> primero, ArrayList<String>segundo, ArrayList<String>postre) throws PlatoIncorrectoExcepcion, FechaIncorrectaExcepcion {
		
		GestionDatos GD = new GestionDatos();
		InterfaceDeGestionDeDatos IntGD = GD;
		Menu menuDelDia = new Menu();
		Date fecha1= new Date();
		if(fecha.getMonth()!=fecha1.getMonth()||fecha.getDay()!=fecha1.getDay()||fecha.getYear()!=fecha1.getYear())
			throw new FechaIncorrectaExcepcion();
		if(primero.size()!=3||segundo.size()!=3||postre.size()!=3)
			throw new PlatoIncorrectoExcepcion("Numero de platos incorrecto");
		
		//Platos disponibles en el sistema
		ArrayList<Plato> primerosDisponibles=this.obtenerPlatosDisponibles("primero");
		ArrayList<Plato> segundosDisponibles=this.obtenerPlatosDisponibles("segundo");
		ArrayList<Plato> postresDisponibles=this.obtenerPlatosDisponibles("postre");
		
		//Elementos del menu
		ArrayList<String> primeros=new ArrayList<String>();
		ArrayList<String> segundos=new ArrayList<String>();
		ArrayList<String> postres=new ArrayList<String>();

		//Tres menus distintos para cada dia
		for(int i=0;i<3;i++) {	
			
			Plato p=new Plato(primero.get(i)," ");
			if(!primerosDisponibles.contains(p)||primeros.contains(primero.get(i)))
			throw new PlatoIncorrectoExcepcion("Primer plato incorrecto");
			primeros.add(primero.get(i));
	
			
			p=new Plato(segundo.get(i)," ");
			if(!segundosDisponibles.contains(p)||segundos.contains(segundo.get(i)))
				throw new PlatoIncorrectoExcepcion("Segundo plato incorrecto");

			segundos.add(segundo.get(i));	
			
			p=new Plato(postre.get(i)," ");
			if(!postresDisponibles.contains(p)||postres.contains(postre.get(i)))
				throw new PlatoIncorrectoExcepcion("Postre  incorrecto");
			
			postres.add(postre.get(i));
		
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
		
		ArrayList<Plato> platosDisponibles=IntGD.consultarPlatos();
		ArrayList<Plato> platos= new ArrayList<>();
		for(Plato plato:platosDisponibles) {
			if(plato.getTipo().equals(tipo)) {
				platos.add(plato);
			}
		}
		
		return platos;
	}

	@Override
	public Menu obtenerMenuDia() {
		
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
