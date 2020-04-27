
package pagosyvaloraciones;

import java.util.ArrayList;
import java.util.Date;

public class Sensor implements InterfaceSensores {
	private ArrayList<Integer> idBandeja;
	public Sensor() {
		this.idBandeja=new ArrayList<>();
		
	}
	@Override
	public int devolverIdentificadorVale() {
		int idVale = (int)(Math.random()*10000+1);
		return idVale;
	}

	

	public ArrayList<Integer> getIdBandeja() {
		return idBandeja;
	}
	public void setIdBandeja(ArrayList<Integer> idBandeja) {
		this.idBandeja = idBandeja;
	}

	@Override
	public int  devolverIdentificadorBandeja() {
		int idVale = (int)(Math.random()*10000+1);
		this.idBandeja.add(idVale);
		return idVale;
	}

	@Override
	public void simularDevolucionBandeja(InterfaceGestionDePagosYCalificaciones P,int bandeja) {
		//Crear de forma aleatoria el tiempo que tarda en comer
		if(!(this.idBandeja==null)&&this.idBandeja.contains(bandeja)) {
			int a=this.idBandeja.indexOf(bandeja);
			this.idBandeja.remove(a);
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
		P.bandejaDevuelta(hora, bandeja);
		
		
	
	}
	}

}
