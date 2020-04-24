package menus;

public class MenuElegido {

	String primero;
	String segundo;
	String postre;
	String bebida;
	
	public void MenuElegido(String primero, String segundo, String postre, String bebida) {
		this.primero=primero;
		this.segundo=segundo;
		this.postre=postre;
		this.bebida=bebida;
	
	}

	public String getPrimero() {
		return primero;
	}

	public void setPrimero(String primero) {
		this.primero = primero;
	}

	public String getSegundo() {
		return segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

	public String getPostre() {
		return postre;
	}

	public void setPostre(String postre) {
		this.postre = postre;
	}

	public String getBebida() {
		return bebida;
	}

	public void setBebida(String bebida) {
		this.bebida = bebida;
	}
}
