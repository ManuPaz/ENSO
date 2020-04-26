package pagosyvaloraciones;

public class Sensor implements InterfaceSensores {
	private int idBandeja;
	@Override
	public int devolverIdentificadorVale() {
		int idVale = (int)(Math.random()*10000+1);
		return idVale;
	}

	@Override
	public int devolverIdentificadorBandeja() {
		int idVale = (int)(Math.random()*10000+1);
		this.idBandeja=idVale;
		return idVale;
	}

	@Override
	public int simularTiempo() {
		//Crear de forma aleatoria el tiempo que tarda en comer
		long minutos = (long) (Math.random()*(40 - 10))+10;
		//Pasar los minutos a segundos
		long segundos = minutos/10;
		//Hacer un sleep de los segundos
		try {
			Thread.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.idBandeja;
	}

}
