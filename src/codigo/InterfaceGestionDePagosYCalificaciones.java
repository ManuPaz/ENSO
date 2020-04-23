package PrjGrupo1A;

public interface InterfaceGestionDePagosYCalificaciones {

	//Crear factura
	public void nuevoMenuPedido(MenuElegido menuElegido);
	
	//Escribir la devolución de la bandeja
	public void bandejaDevuelta(Date hora, int identificadorBandeja);
	
	//Escribe en un archivo
	public void valoracion(int valoracion, String plato);
}
