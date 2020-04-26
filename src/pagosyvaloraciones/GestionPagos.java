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

	@Override
	public void nuevoMenuPedido(MenuElegido menuElegido) {
		InterfaceSensores sensor = new Sensor();
		this.identificadorBandeja = sensor.devolverIdentificadorBandeja();
		Factura factura = new Factura(6, this.identificadorBandeja, sensor.devolverIdentificadorVale(), menuElegido);
		this.horaAsignacion = new Date();
		this.menuElegido = menuElegido;
		InterfaceDeGestionDeDatos GD = new GestionDatos();
		GD.insertarFactura(factura);

	}

	@Override
	public void bandejaDevuelta(Date hora, int identificadorBandeja) {
		// TODO Auto-generated method stub
		
		this.horaDevolucion=new Date();
		Scanner scanner=new Scanner(System.in);
		boolean aux=true;
		int i=0;
		boolean aux2=true;
		Integer val=0;
		while(aux) {
			System.out.println("Introduce el nombre de un plato:");
			String nombre=scanner.nextLine();
			if(menuElegido.getPrimero().equals(nombre)||menuElegido.getSegundo().equals(nombre)||menuElegido.getPostre().equals(nombre))
				aux=false;
			System.out.println("Introduce una valoracion:");
			String valoracion=scanner.nextLine();
			try {
				val=Integer.parseInt(valoracion);
			}catch(NumberFormatException e) {
				System.out.println("No es un numero");
				aux=true;
			
			};
			if(!aux) {
				this.valoracion(val, nombre);
				
				
				
				i++;
			}
			if(!aux&&i<3) {
				System.out.println("Quieres valorar mas platos ? Introduce Si/No");
				nombre=scanner.nextLine();
				if(nombre.equals("Si"))
					aux=false;
				
			}
			}
				
		
				
		
			
			
	}

	@Override
	public void valoracion(int valoracion, String plato) {
		// TODO Auto-generated method stub
		Valoracion valo=new Valoracion(this.horaAsignacion,this.horaDevolucion,identificadorBandeja,plato,valoracion);
		InterfaceDeGestionDeDatos GD = new GestionDatos();
		GD.insertarValoracion(valo);
	}

}
