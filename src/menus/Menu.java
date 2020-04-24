package menus;

import java.util.ArrayList;
import java.util.Date;

public class Menu {

	ArrayList<String> primeros;
	ArrayList<String> segundos;
	ArrayList<String> postres;
	Date fecha;
	
	public Menu(ArrayList<String> primeros, ArrayList<String> segundos, ArrayList<String> postres, Date fecha) {
		super();
		this.primeros = primeros;
		this.segundos = segundos;
		this.postres = postres;
		this.fecha = fecha;
	}
	
	public Menu() {
		super();
		this.primeros = new ArrayList<String>();
		this.segundos = new ArrayList<String>();
		this.postres = new ArrayList<String>();
		this.fecha = new ArrayList<String>();
	}
	
	public ArrayList<String> getPrimeros() {
		return primeros;
	}
	public void setPrimeros(ArrayList<String> primeros) {
		this.primeros = primeros;
	}
	public ArrayList<String> getSegundos() {
		return segundos;
	}
	public void setSegundos(ArrayList<String> segundos) {
		this.segundos = segundos;
	}
	public ArrayList<String> getPostres() {
		return postres;
	}
	public void setPostres(ArrayList<String> postres) {
		this.postres = postres;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
