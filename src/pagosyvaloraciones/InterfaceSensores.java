package pagosyvaloraciones;

public interface InterfaceSensores {

	public int devolverIdentificadorVale();
	
	public int devolverIdentificadorBandeja();
	
	public void simularTiempoYDevolverBandeja(InterfaceGestionDePagosYCalificaciones GP);
}
