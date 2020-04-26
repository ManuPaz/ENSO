package pagosyvaloraciones;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import datos.GestionDatos;
import menus.MenuElegido;

public class GestionPagos implements InterfaceGestionDePagosYCalificaciones{

	@Override
	public void nuevoMenuPedido(MenuElegido menuElegido) {
		InterfaceSensores sensor = new Sensor();
		Factura factura = new Factura(6, sensor.devolverIdentificadorBandeja(), sensor.devolverIdentificadorVale(), menuElegido);
		
		GestionDatos GD = new GestionDatos();
		GD.insertarFactura(factura);
		
	}

	@Override
	public void bandejaDevuelta(Date hora, int identificadorBandeja) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valoracion(int valoracion, String plato) {
		// TODO Auto-generated method stub
		InterfaceSensores sensor = new Sensor();
		Valoracion val = new Valoracion(fechaAsignacion, fechaDevolucion, sensor.devolverIdentificadorBandeja(), plato, valoracion);
		
		GestionDatos GD = new GestionDatos();
		GD.insertarValoracion(valoracion);
	}

}
