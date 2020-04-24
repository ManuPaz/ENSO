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
	
	
}
