package datos;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import menus.Menu;
import menus.MenuElegido;
import menus.Plato;
import pagosyvaloraciones.Factura;
import pagosyvaloraciones.Valoracion;

public class GestionDatos implements InterfaceDeGestionDeDatos {

	@Override
	public void insertarFactura(Factura factura) {

		try {
			if (factura != null) {
				String filename = "src\\ficheros\\facturas.txt";
				FileWriter fw = new FileWriter(filename, true); // escribimos al final del archivo
				fw.write(factura.getIdVale() + "," + factura.getIdBandeja() + ","
						+ factura.getMenuElegido().getPrimero() + "," + factura.getMenuElegido().getSegundo() + ","
						+ factura.getMenuElegido().getPostre() + "," + factura.getMenuElegido().getBebida() + ","
						+ Float.toString(factura.getImporte()) + "\n");
				fw.close();
			}
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}

	@Override
	public ArrayList<Plato> consultarPlatos() {

		ArrayList<Plato> platos = new ArrayList<>();

		String linea;
		String[] partes;

		try {
			FileReader fr = new FileReader("src\\ficheros\\platos.txt");
			BufferedReader br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				partes = linea.split(",");
				if (partes.length == 2) {
					String nombre = partes[0];
					String tipo = partes[1];
					if (tipo.equals("primero") || tipo.equals("segundo") || tipo.equals("postre")) {
						Plato plato = new Plato(nombre, tipo);
						platos.add(plato);
					}
				}
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		if (platos.size() == 0) {
			System.out.println("No hay platos que leer en el archivo, o no están escritos en el formato adecuado");
		}
		return platos;
	}

	@Override
	public void insertarValoracion(Valoracion valoracion) {
		try {
			if (valoracion != null) {
				String filename = "src\\ficheros\\valoraciones.txt";
				FileWriter fw = new FileWriter(filename, true); // escribimos al final del archivo
				fw.write(valoracion.getIdBandeja() + "," + valoracion.getFechaAsignacion().toString() + ","
						+ valoracion.getFechaDevolucion().toString() + "," + valoracion.getPlato() + ","
						+ Integer.toString(valoracion.getPuntuacion()) + "\n");
				fw.close();
			}
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}

	@Override
	public ArrayList<Valoracion> consultarValoraciones() {

		ArrayList<Valoracion> valoraciones = new ArrayList<>();
		DateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");

		String linea;
		String[] partes;

		try {
			FileReader fr = new FileReader("src\\ficheros\\valoraciones.txt");
			BufferedReader br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				partes = linea.split(",");
				if (partes.length == 5) {
					int idBandeja = Integer.parseInt(partes[0]);
					Date horaAsignacion = formatoHora.parse(partes[1].split(" ")[3]);
					Date horaDevolucion = formatoHora.parse(partes[2].split(" ")[3]);
					String plato = partes[3];
					int puntuacion = Integer.parseInt(partes[4]);
					Valoracion valoracion = new Valoracion(horaAsignacion, horaDevolucion, idBandeja, plato,
							puntuacion);
					valoraciones.add(valoracion);
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return valoraciones;
	}

	@Override
	public void insertarMenu(Menu menu) {

		String filename = "src\\ficheros\\menus.txt";
		boolean yaExiste = false;
		String[] partes;
		String linea;
		Date fecha = menu.getFecha();
		String[] fechaMenuFormateado = fecha.toString().split(" ");
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader bf = new BufferedReader(fr);

			while ((linea = bf.readLine()) != null) {
				partes = linea.split(",");
				if (partes.length == 10) {
					String fechaMenu = partes[0];

					if (fechaMenu.split(" ")[2].equals(fechaMenuFormateado[2])
							&& fechaMenu.split(" ")[1].equals(fechaMenuFormateado[1])
							&& fechaMenu.split(" ")[5].equals(fechaMenuFormateado[5])) {
						
						yaExiste = true;
						System.out.println("Ya existe un menú para el día introducido");
						break;
					}
				}
			}

			bf.close();
			fr.close();
			
			if (menu != null && !yaExiste) {

				fr = new FileReader(filename);
				bf = new BufferedReader(fr);
				int nLineas = 0;

				while (bf.readLine() != null) {
					nLineas++; // contamos el numero de lineas
				}

				bf.close();
				fr.close();

				/*
				 * Si ya hay 5 menus almacenados borramos la primera linea del archivo y subimos
				 * el resto de lineas hacia arriba para escribir el nuevo menu al final
				 */
				if (nLineas == 5) {
					BufferedReader file;
					file = new BufferedReader(new FileReader(filename));
					String line;
					String input = "";
					boolean borrado = false;
					while ((line = file.readLine()) != null) {
						if (!borrado) {
							borrado = true; // no cogemos la primera linea
						} else {
							input += line + "\r\n"; // cogemos todas las demás
						}
					}
					file.close();

					FileOutputStream fileOut = new FileOutputStream(filename);
					fileOut.write(input.getBytes());
					fileOut.close(); // reescribimos el fichero solo con las cuatro lineas
				}

				// Añadimos el nuevo menú
				FileWriter fw = new FileWriter(filename, true); // escribimos al final del archivo
				fw.write(menu.getFecha().toString() + "," + menu.getPrimeros().get(0) + "," + menu.getPrimeros().get(1)
						+ "," + menu.getPrimeros().get(2) + "," + menu.getSegundos().get(0) + ","
						+ menu.getSegundos().get(1) + "," + menu.getSegundos().get(2) + "," + menu.getPostres().get(0)
						+ "," + menu.getPostres().get(1) + "," + menu.getPostres().get(2) + "\n");
				fw.close();

			}
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}

	@Override
	public ArrayList<Menu> consultarMenusSemana() {

		ArrayList<Menu> menusSemana = new ArrayList<>();
		boolean encontradoHoy = false;

		Date hoy = new Date();

		int nDia = -1;
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(hoy);
		nDia = calendar.get(Calendar.DAY_OF_WEEK);
		if (nDia == 1) { // Domingo
			calendar.add(Calendar.DAY_OF_YEAR, 1); // Pasamos a lunes
			hoy = calendar.getTime();
		} else if (nDia == 7) { // Sabado
			calendar.add(Calendar.DAY_OF_YEAR, 2); // Pasamos a lunes
			hoy = calendar.getTime();
		}

		String[] hoyFormateado = hoy.toString().split(" ");

		String linea;
		String[] partes;

		try {
			FileReader fr = new FileReader("src\\ficheros\\menus.txt");
			BufferedReader br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null && menusSemana.size() != 5) {

				partes = linea.split(",");
				if (partes.length == 10) {
					String fechaMenu = partes[0];

					if (fechaMenu.split(" ")[2].equals(hoyFormateado[2])
							&& fechaMenu.split(" ")[1].equals(hoyFormateado[1])
							&& fechaMenu.split(" ")[5].equals(hoyFormateado[5])) {
						ArrayList<String> primeros = new ArrayList<>();
						ArrayList<String> segundos = new ArrayList<>();
						ArrayList<String> postres = new ArrayList<>();

						primeros.add(partes[1]);
						primeros.add(partes[2]);
						primeros.add(partes[3]);

						segundos.add(partes[4]);
						segundos.add(partes[5]);
						segundos.add(partes[6]);

						postres.add(partes[7]);
						postres.add(partes[8]);
						postres.add(partes[9]);

						Menu menu = new Menu(primeros, segundos, postres, hoy);

						menusSemana.add(menu);
						encontradoHoy = true;

					} else if (encontradoHoy) {

						ArrayList<String> primeros = new ArrayList<>();
						ArrayList<String> segundos = new ArrayList<>();
						ArrayList<String> postres = new ArrayList<>();

						primeros.add(partes[1]);
						primeros.add(partes[2]);
						primeros.add(partes[3]);

						segundos.add(partes[4]);
						segundos.add(partes[5]);
						segundos.add(partes[6]);

						postres.add(partes[7]);
						postres.add(partes[8]);
						postres.add(partes[9]);

						Menu menu = new Menu(primeros, segundos, postres, hoy);

						menusSemana.add(menu);
					}
				}
			}

			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if(menusSemana.size()>0) {
			return menusSemana;
		}else {
			System.out.println("Todavía no hay un menú establecido para ningún día de la semana");
			return null;
		}
	}

	@Override
	public Menu consultarMenuHoy() {

		Date hoy = new Date();

		int nDia = -1;
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(hoy);
		nDia = calendar.get(Calendar.DAY_OF_WEEK);
		if (nDia == 1) { // Domingo
			calendar.add(Calendar.DAY_OF_YEAR, 1); // Pasamos a lunes
			hoy = calendar.getTime();
		} else if (nDia == 7) { // Sabado
			calendar.add(Calendar.DAY_OF_YEAR, 2); // Pasamos a lunes
			hoy = calendar.getTime();
		}

		String[] hoyFormateado = hoy.toString().split(" ");

		String linea;
		String[] partes;

		try {
			FileReader fr = new FileReader("src\\ficheros\\menus.txt");
			BufferedReader br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {

				partes = linea.split(",");
				if (partes.length == 10) {
					String fechaMenu = partes[0];
					if (fechaMenu.split(" ")[2].equals(hoyFormateado[2])
							&& fechaMenu.split(" ")[1].equals(hoyFormateado[1])
							&& fechaMenu.split(" ")[5].equals(hoyFormateado[5])) {
						ArrayList<String> primeros = new ArrayList<>();
						ArrayList<String> segundos = new ArrayList<>();
						ArrayList<String> postres = new ArrayList<>();

						primeros.add(partes[1]);
						primeros.add(partes[2]);
						primeros.add(partes[3]);

						segundos.add(partes[4]);
						segundos.add(partes[5]);
						segundos.add(partes[6]);

						postres.add(partes[7]);
						postres.add(partes[8]);
						postres.add(partes[9]);

						Menu menuHoy = new Menu(primeros, segundos, postres, hoy);

						br.close();
						fr.close();
						return menuHoy;
					}
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Todavía no hay un menú establecido para ese día de la semana");
		return null;
	}

	@Override
	public ArrayList<Factura> consultarFactura() {

		ArrayList<Factura> facturas = new ArrayList<>();

		String linea;
		String[] partes;

		try {
			FileReader fr = new FileReader("src\\ficheros\\facturas.txt");
			BufferedReader br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				partes = linea.split(",");
				if (partes.length == 7) {
					int idVale = Integer.parseInt(partes[0]);
					int idBandeja = Integer.parseInt(partes[1]);
					String primero = partes[2];
					String segundo = partes[3];
					String postre = partes[4];
					String bebida = partes[5];
					float importe = Float.parseFloat(partes[6]);
					MenuElegido menuElegido = new MenuElegido(primero, segundo, postre, bebida);
					Factura factura = new Factura(importe, idBandeja, idVale, menuElegido);
					facturas.add(factura);
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (facturas.size() == 0) {
			System.out.println("No hay facturas en el fichero");
		}

		return facturas;
	}

}
