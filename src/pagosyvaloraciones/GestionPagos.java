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
		if(this.menuElegido!=null) {
		this.horaDevolucion=hora;
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
				this.valoracion(val, nombre,IdentificadorBandeja);
				
				
				
				i++;
			}
			if(!aux&&i<3) {
				System.out.println("Quieres valorar mas platos ? Introduce Si/No");
				nombre=scanner.nextLine().toString();
				if(nombre.equals("Si"))
					aux=true;
				
			}
			}
		}	else {
			System.out.println("No se esta realizando la valoracion para ningun menu pagado");
		}
		
				
		
			
			
	}

	@Override
	public void valoracion(int valoracion, String plato,int identificadorBandeja) {
		// TODO Auto-generated method stub
		if(this.menuElegido!=null) {
		Valoracion valo=new Valoracion(this.horaAsignacion,this.horaDevolucion,identificadorBandeja,plato,valoracion);
		InterfaceDeGestionDeDatos GD = new GestionDatos();
		GD.insertarValoracion(valo);
	}
		
	else {
		System.out.println("No se esta realizando la valoracion para ningun menu pagado");
	}
	}

}
