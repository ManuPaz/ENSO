package pagosyvaloraciones;

public interface InterfaceSensores {

	public int devolverIdentificadorVale();
	
	public int devolverIdentificadorBandeja();
	
	
	public void simularDevolucionBandeja(InterfaceGestionDePagosYCalificaciones GP,int bandeja);
}
