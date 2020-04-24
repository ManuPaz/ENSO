package pagosyvaloraciones;

import menus.MenuElegido;

public class Factura {

	float importe;
	int idBandeja;
	int idVale;
	MenuElegido menuElegido;
	
	public Factura(float importe, int idBandeja, int idVale, MenuElegido menuElegido) {
		super();
		this.importe = importe;
		this.idBandeja = idBandeja;
		this.idVale = idVale;
		this.menuElegido = menuElegido;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public int getIdBandeja() {
		return idBandeja;
	}

	public void setIdBandeja(int idBandeja) {
		this.idBandeja = idBandeja;
	}

	public int getIdVale() {
		return idVale;
	}

	public void setIdVale(int idVale) {
		this.idVale = idVale;
	}

	public MenuElegido getMenuElegido() {
		return menuElegido;
	}

	public void setMenuElegido(MenuElegido menuElegido) {
		this.menuElegido = menuElegido;
	}
	
	
}
