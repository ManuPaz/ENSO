package pagosyvaloraciones;

public class Sensor implements InterfaceSensores {

	@Override
	public int devolverIdentificadorVale() {
		int idVale = (int)(Math.random()*10000+1);
		return idVale;
	}

	@Override
	public int devolverIdentificadorBandeja() {
		int idVale = (int)(Math.random()*10000+1);
		return idVale;
	}

	@Override
	public void simularTiempo() {
		// TODO Auto-generated method stub
		
	}

}
