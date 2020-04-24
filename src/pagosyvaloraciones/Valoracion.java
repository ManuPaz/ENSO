package pagosyvaloraciones;

import java.util.Date;

public class Valoracion {

	int idBandeja;
	String plato;
	int puntuacion;
	Date fechaAsignacion;
	Date fechaDevolucion;
	public void Valoracion(Date fechaAsignacion,Date fechaDevolucion,int idBandeja, String plato, int puntuacion) {
		this.idBandeja = idBandeja;
		this.plato = plato;
		this.puntuacion = puntuacion;
		this.fechaAsignacion=fechaAsignacion;
		this.fechaDevolucion=fechaDevolucion;
		
		
	}
	public int getIdBandeja() {
		return idBandeja;
	}
	public void setIdBandeja(int idBandeja) {
		this.idBandeja = idBandeja;
	}
	public String getPlato() {
		return plato;
	}
	public void setPlato(String plato) {
		this.plato = plato;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
}
