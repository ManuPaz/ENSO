package menus;

public class Plato {

	String nombre;
	String tipo; //primero,segundo,postre
	
	public Plato(String nombre, String tipo) {
		this.nombre=nombre;
		this.tipo=tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
