package datos;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import menus.Plato;
import pagosyvaloraciones.*;

public class AnalisisYEstadisticas implements InterfaceAnalisisYEstadisticas {

	@Override
	public ArrayList<String> platoMasPedido() {
		// TODO Auto-generated method stub
		GestionDatos gd = new GestionDatos();
		InterfaceDeGestionDeDatos igd = gd;
		ArrayList<String> platosRet=new ArrayList<>();
		ArrayList<Factura> facturas=igd.consultarFactura();
		ArrayList<Plato> platos=igd.consultarPlatos();
		int i=0;
		int maximo=0;
		for(Plato plato:platos) {
			i=0;
			for(Factura fact:facturas){
				if(fact.getMenuElegido().getPrimero().equals(plato)||fact.getMenuElegido().getSegundo().equals(plato)||fact.getMenuElegido().getPostre().equals(plato)) {
					i++;
				}
				if (i > maximo) {
					maximo = i;
					platosRet.removeAll(platosRet);
					platosRet.add(plato.getNombre());
				} else if (i == maximo)
					platosRet.add(plato.getNombre());
				
				
			}
			
		}
		return platosRet;
	}

	@Override
	public ArrayList<String> platoMasValorado() {
		GestionDatos gd = new GestionDatos();
		InterfaceDeGestionDeDatos igd = gd;
		ArrayList<String> platosRet=new ArrayList<>();
		ArrayList<Valoracion> valoracions=igd.consultarValoraciones();
		ArrayList<Plato> platos=igd.consultarPlatos();
		int i=0;
		int maximo=0;
		for(Plato plato:platos) {
			i=0;
			for(Valoracion fact:valoracions){
				if(fact.getPlato().equals(plato)) {
					i+=fact.getPuntuacion();
				}
				if (i >maximo) {
					maximo= i;
					platosRet.removeAll(platosRet);
					platosRet.add(plato.getNombre());
				} else if (i == maximo)
					platosRet.add(plato.getNombre());
				
				
			}
			
		}
		return platosRet;
	}

	@Override
	public ArrayList<String> platoMenosPedido() {
		GestionDatos gd = new GestionDatos();
		InterfaceDeGestionDeDatos igd = gd;
		ArrayList<String> platosRet=new ArrayList<>();
		ArrayList<Factura> facturas=igd.consultarFactura();
		ArrayList<Plato> platos=igd.consultarPlatos();
		int i=0;
		int minimo=10000000;
		for(Plato plato:platos) {
			i=0;
			for(Factura fact:facturas){
				if(fact.getMenuElegido().getPrimero().equals(plato)||fact.getMenuElegido().getSegundo().equals(plato)||fact.getMenuElegido().getPostre().equals(plato)) {
					i++;
				}
				if (i < minimo) {
					minimo = i;
					platosRet.removeAll(platosRet);
					platosRet.add(plato.getNombre());
				} else if (i == minimo)
					platosRet.add(plato.getNombre());
				
				
			}
			
		}
		return platosRet;
	}

	@Override
	public ArrayList<String> platoMenosValorado() {
		GestionDatos gd = new GestionDatos();
		InterfaceDeGestionDeDatos igd = gd;
		ArrayList<String> platosRet=new ArrayList<>();
		ArrayList<Valoracion> valoracions=igd.consultarValoraciones();
		ArrayList<Plato> platos=igd.consultarPlatos();
		int i=0;
		int minimo=1000000000;
		for(Plato plato:platos) {
			i=0;
			for(Valoracion fact:valoracions){
				if(fact.getPlato().equals(plato)) {
					i+=fact.getPuntuacion();
				}
				if (i < minimo) {
					minimo = i;
					platosRet.removeAll(platosRet);
					platosRet.add(plato.getNombre());
				} else if (i == minimo)
					platosRet.add(plato.getNombre());
				
				
			}
			
		}
		return platosRet;
	}

	@Override
	public int ocupacionComedor() {

		GestionDatos gd = new GestionDatos();
		InterfaceDeGestionDeDatos igd = gd;
		ArrayList<Valoracion> valoraciones = igd.consultarValoraciones();
		ArrayList<Factura> facturas = igd.consultarFactura();
		int i = 0;
		boolean aux = false;
		for (Factura fact : facturas) {
			aux = false;

			for (Valoracion valoracion : valoraciones) {
				if (fact.getIdBandeja() == valoracion.getIdBandeja()) {
					aux = true;
					break;

				}
				if (!aux)
					i += 1;

			}
		}
		return i;
	}

	@Override
	public ArrayList<Integer> horaMasFrecuente() {
		GestionDatos gd = new GestionDatos();
		InterfaceDeGestionDeDatos igd = gd;
		ArrayList<Valoracion> valoraciones = igd.consultarValoraciones();
		ArrayList<Integer> horas = new ArrayList<>();
		int maximo = 0;
		int aux = 0;
		for (int i = 0; i < 24; i++) {
			for (Valoracion val : valoraciones) {
				if (val.getFechaAsignacion().getHours() == i)
					aux += 1;

			}
			if (aux > maximo) {
				maximo = aux;
				horas.removeAll(horas);
				horas.add(i);
			} else if (aux == maximo)
				horas.add(i);

		}

		return horas;
	}

	@Override
	public int tiempoMedioDuracion() {
		GestionDatos gd = new GestionDatos();
		int i = 0;
		int suma = 0;

		InterfaceDeGestionDeDatos igd = gd;
		ArrayList<Valoracion> valoraciones = igd.consultarValoraciones();
		ArrayList<Integer> identificadores = new ArrayList<>();
		for (Valoracion val : igd.consultarValoraciones()) {
			if (!identificadores.contains(val.getIdBandeja())) {
				identificadores.add(val.getIdBandeja());
				suma += val.getFechaDevolucion().getTime() - val.getFechaAsignacion().getTime();
				i++;

			}
			suma = suma / i;

		}

		return suma;
	}

	@Override
	public ArrayList<Plato> rankingValoracion() {
		GestionDatos gd = new GestionDatos();
		InterfaceDeGestionDeDatos igd = gd;
		ArrayList<Plato> platos = igd.consultarPlatos();
		HashMap<Plato, Float> plats = new HashMap<>();
		ArrayList<Valoracion> valoraciones = igd.consultarValoraciones();
		for (Plato plato : platos) {
			int i = 0;
			float v = 0;
			for (Valoracion val : valoraciones) {
				if (val.getPlato().equals(plato.getNombre())) {
					i++;
					v = v + val.getPuntuacion();

				}

			}
			v = v / i;
			if (plats.size() < 10)
				plats.put(plato, v);
			else {
				Collection<Float> col = plats.values();
				float min = 11;
				for (Float f : col) {
					if (f < min)
						min = f;

				}
				if (min < v) {
					Collection<Plato> p = plats.keySet();
					for (Plato p1 : p) {
						if (plats.get(p1) == min) {
							plats.remove(p1);
							plats.put(plato, v);
							break;

						}

					}

				}

			}

		}
		ArrayList<Plato> ret=new ArrayList();
		Collection<Plato> c=plats.keySet();
		for(Plato p:c) {
		ret.add(p);	
			
		}
		return ret;
	}

}
