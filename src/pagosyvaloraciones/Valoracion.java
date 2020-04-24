package pagosyvaloraciones;

public class Valoracion {

	int idBandeja;
	String plato;
	int puntuacion;
	
	public void Valoracion(int idBandeja, String plato, int puntuacion) {
		this.idBandeja = idBandeja;
		this.plato = plato;
		this.puntuacion = puntuacion;
	}
}
