package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
            String filename = "src\\ficheros\\facturas.txt";
            FileWriter fw = new FileWriter(filename, true); //escribimos al final del archivo
            fw.write(factura.getIdVale() + "," + factura.getIdBandeja() + "," + factura.getMenuElegido().getPrimero() + "," + factura.getMenuElegido().getSegundo() + "," + factura.getMenuElegido().getPostre() + "," + factura.getMenuElegido().getBebida() + "," + Float.toString(factura.getImporte())+"\n");
            fw.close();
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
                if(partes.length==2) {
                	String nombre = partes[0];
                	String tipo = partes[1];
                	Plato plato = new Plato(nombre,tipo);
                	platos.add(plato);
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		return platos;
	}

	@Override
	public void insertarValoracion(Valoracion valoracion) {
		try {
            String filename = "src\\ficheros\\valoraciones.txt";
            FileWriter fw = new FileWriter(filename, true); //escribimos al final del archivo
            fw.write(valoracion.getIdBandeja() + "," + valoracion.getFechaAsignacion().toString() + "," + valoracion.getFechaDevolucion().toString() + "," + valoracion.getPlato() + "," + Integer.toString(valoracion.getPuntuacion())+"\n");
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
	}

	@Override
	public ArrayList<Valoracion> consultarValoraciones() {
		
		ArrayList<Valoracion> valoraciones = new ArrayList<>();
		DateFormat formatoHora = new SimpleDateFormat(":dd hh:mm:ss");
		
		String linea;
        String[] partes;

        try {
            FileReader fr = new FileReader("src\\ficheros\\valoraciones.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                partes = linea.split(",");
                if(partes.length==5) {
                	int idBandeja = Integer.parseInt(partes[0]);
                	Date horaAsignacion = formatoHora.parse(partes[1]);
                	Date horaDevolucion = formatoHora.parse(partes[2]);
                	String plato = partes[3];
                	int puntuacion = Integer.parseInt(partes[4]);
                	Valoracion valoracion = new Valoracion(horaAsignacion,horaDevolucion,idBandeja,plato,puntuacion);
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
		try {
            String filename = "src\\ficheros\\menus.txt";
            FileWriter fw = new FileWriter(filename, true); //escribimos al final del archivo
            fw.write(menu.getFecha().toString() + "," + menu.getPrimeros().get(0) + "," + menu.getPrimeros().get(1) + "," + menu.getPrimeros().get(2) + "," + menu.getSegundos().get(0) + "," + menu.getSegundos().get(1) + "," + menu.getSegundos().get(2) + ","+menu.getPostres().get(0) + "," + menu.getPostres().get(1) + "," + menu.getPostres().get(2)+"\n");
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
	}

	@Override
	public ArrayList<Menu> consultarMenusSemana() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu consultarMenuHoy() {
		
		Date hoy = new Date();
		String[] hoyFormateado = hoy.toString().split(" ");
		
		String linea;
        String[] partes;
        
        try {
            FileReader fr = new FileReader("src\\ficheros\\menus.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
    
                partes = linea.split(",");
                if(partes.length==10) {
                	String fechaMenu = partes[0];
                	System.out.println(fechaMenu);
                	if(fechaMenu.split(" ")[2].equals(hoyFormateado[2])&&fechaMenu.split(" ")[1].equals(hoyFormateado[1])&&fechaMenu.split(" ")[5].equals(hoyFormateado[5])) {
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
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
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
                if(partes.length==7) {
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
		return facturas;
	}

	
}
