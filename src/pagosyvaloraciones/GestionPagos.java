package pagosyvaloraciones;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import datos.GestionDatos;
import datos.InterfaceDeGestionDeDatos;
import menus.MenuElegido;

public class GestionPagos implements InterfaceGestionDePagosYCalificaciones {
	private int identificadorBandeja;
	private Date horaAsignacion;
	private MenuElegido menuElegido;
	private Date horaDevolucion;
	private InterfaceSensores IS;
	
	public GestionPagos(InterfaceSensores IS) {
		this.IS=IS;
		this.identificadorBandeja=-1;
		
	}
	@Override
	public void nuevoMenuPedido(MenuElegido menuElegido) {
		
		this.identificadorBandeja = this.IS.devolverIdentificadorBandeja();
		Factura factura = new Factura(6, this.identificadorBandeja, this.IS.devolverIdentificadorVale(), menuElegido);
		this.horaAsignacion = new Date();
		this.menuElegido = menuElegido;
		InterfaceDeGestionDeDatos GD = new GestionDatos();
		GD.insertarFactura(factura);

	}

	@Override
	public void bandejaDevuelta(Date hora,int IdentificadorBandeja) {
		// TODO Auto-generated method stub
		this.horaDevolucion=hora;
	}

	@Override
	public void valoracion(int valoracion, String plato,int identificadorBandeja) {
		// TODO Auto-generated method stub
		if(this.menuElegido!=null||identificadorBandeja!=this.identificadorBandeja||this.identificadorBandeja==-1) {
		Valoracion valo=new Valoracion(this.horaAsignacion,this.horaDevolucion,identificadorBandeja,plato,valoracion);
		InterfaceDeGestionDeDatos GD = new GestionDatos();
		GD.insertarValoracion(valo);
	}
		
	else {
		System.out.println("No se esta realizando la valoracion para ningun menu pagado");
	}
	}

}
