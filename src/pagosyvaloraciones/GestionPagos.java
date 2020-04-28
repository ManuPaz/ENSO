package pagosyvaloraciones;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import datos.GestionDatos;
import datos.InterfaceDeGestionDeDatos;
import menus.MenuElegido;

public class GestionPagos implements InterfaceGestionDePagosYCalificaciones {
	private ArrayList<Integer> identificadorBandeja;
	private ArrayList<Date> horaAsignacion;
	private ArrayList<MenuElegido> menuElegido;
	private InterfaceSensores IS;
	private ArrayList<Date> horaDevolucion;

	public GestionPagos(InterfaceSensores IS) {
		this.IS = IS;
		this.identificadorBandeja = new ArrayList<>();
		this.menuElegido = new ArrayList<>();
		this.horaAsignacion = new ArrayList<>();
		this.horaDevolucion=new ArrayList<>();

	}

	@Override
	public void nuevoMenuPedido(MenuElegido menuElegido) {

		this.identificadorBandeja.add(this.IS.devolverIdentificadorBandeja());
		Factura factura = new Factura(6, this.identificadorBandeja.get(this.identificadorBandeja.size() - 1),
				this.IS.devolverIdentificadorVale(), menuElegido);
		this.horaAsignacion.add(new Date());
		this.menuElegido.add(menuElegido);
		InterfaceDeGestionDeDatos GD = new GestionDatos();
		GD.insertarFactura(factura);

	}

	@Override
	public void bandejaDevuelta(Date hora, int IdentificadorBandeja) {
		// TODO Auto-generated method stub
		if(this.identificadorBandeja.contains(IdentificadorBandeja)) {
			int i=this.identificadorBandeja.indexOf(IdentificadorBandeja);
		this.horaDevolucion.add(i, hora);
			
		}
	}

	@Override
	public void valoracion(int valoracion, String plato, int identificadorBandeja) {
		// TODO Auto-generated method stub
		if (this.horaDevolucion != null && this.identificadorBandeja.contains(identificadorBandeja)) {
			int i = this.identificadorBandeja.indexOf(identificadorBandeja);
			if (this.horaDevolucion.size()>i&&this.menuElegido.get(i).getPrimero().equals(plato) || this.menuElegido.get(i).getPostre().equals(plato)
					|| this.menuElegido.get(i).getSegundo().equals(plato)) {
				Valoracion valo = new Valoracion(this.horaAsignacion.get(i), this.horaDevolucion.get(i), identificadorBandeja,
						plato, valoracion);
				InterfaceDeGestionDeDatos GD = new GestionDatos();
				GD.insertarValoracion(valo);
				this.identificadorBandeja.remove(i);
				this.menuElegido.remove(i);
				this.horaAsignacion.remove(i);
				this.horaDevolucion.remove(i);
				
			}
		}

	}

}
