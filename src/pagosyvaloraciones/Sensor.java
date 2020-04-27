package pagosyvaloraciones;

import java.util.Date;

public class Sensor implements InterfaceSensores {
	private int idBandeja;
	@Override
	public int devolverIdentificadorVale() {
		int idVale = (int)(Math.random()*10000+1);
		return idVale;
	}

	@Override
	public int  devolverIdentificadorBandeja() {
		int idVale = (int)(Math.random()*10000+1);
		this.idBandeja=idVale;
		return idVale;
	}

	@Override
	public void simularTiempoYDevolverBandeja(InterfaceGestionDePagosYCalificaciones P) {
		//Crear de forma aleatoria el tiempo que tarda en comer
	 Math.random();
		long minutos = (long) (Math.random()*30)+10;
		//Pasar los minutos a segundos
		
		long segundos = minutos/10;
		//Hacer un sleep de los segundos
	
		try {
			Thread.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date hora=new Date();
		P.bandejaDevuelta(hora, this.idBandeja);
		
		
	}

}
