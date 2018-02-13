import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Argumentos {

	private String extension;
	private String nombre;
	private boolean esCarpeta;
	private String nombreCarpeta;
	private File carpeta;
	private File archivo;
	private ArrayList<String> archivos = new ArrayList<String>();
	private String nombreArchivoAEscribir;
	private File archivoAEscribir;
	
	public void validar (String[] argumentos) {
		if (!(argumentos.length == 1)) {	// Si hay mas de un argumento
			System.err.println("La sintaxis correcta es java VMTranslator xxx.vm o java VMTranslator carpeta");
			System.exit(0);
		}
		
		StringTokenizer st = new StringTokenizer(argumentos[0], ".");	// Lo dividimos por el punto
		
		if (st.countTokens() > 2) {		// Si hay mas de dos tokens al dividir por el punto, no es archivo ni carpeta
			System.err.println("La sintaxis correcta es java VMTranslator xxx.vm o java VMTranslator carpeta");
			System.exit(0);
		} else if (st.countTokens() == 2) {	// Si hay 2 tokens, es un archivo
			nombre = st.nextToken();
			
			extension = st.nextToken();
			extension = extension.toLowerCase();
			
			if (!(extension.equals("vm"))) {	// Si la extensión no es .vm
				System.err.println("La sintaxis correcta es java VMTranslator xxx.vm o java VMTranslator carpeta");
				System.exit(0);
			}
			
			nombreArchivoAEscribir = nombre + ".asm";
			nombre = nombre + "." + extension;	// Reconstruimos el nombre del archivo
			archivo = new File(nombre);	// Creamos un objeto File
			nombre = archivo.getAbsolutePath();	// Pasamos al nombre la ruta absoluta
			
			if (!(archivo.exists())) {	// Chequeamos si el archivo seleccionado existe
				System.err.println("El archivo seleccionado no existe");
				System.exit(0);
			}
			
			archivos.add(nombre);	// Agregamos el único archivo al ArrayList
			esCarpeta = false;
			
		} else {	// Hay 1 token, es una carpeta
			nombre = st.nextToken();
			
			nombreCarpeta = nombre;
			carpeta = new File(nombre);	// Crea la ruta con el nombre de la carpeta
			esCarpeta = carpeta.isDirectory();	// Chequea si se encuentra en el Path ingresado
			
			// Creamos el nombre y la ruta del archivo a escribir:
			nombreArchivoAEscribir = nombreCarpeta + File.separator + carpeta.getName() + ".asm";
			archivoAEscribir = new File(nombreArchivoAEscribir);
			nombreArchivoAEscribir = archivoAEscribir.getAbsolutePath();
			
			if (!esCarpeta) {	// Si no se encuentra, error
				System.err.println("No se encuentra la carpeta " + carpeta);
				System.exit(0);
			} else {	// Si se encuentra, leemos todos sus archivos .vm y los ingresamos al ArrayList
				String[] listaArchivos = carpeta.list();	// Tomamos la lista de archivos en un vector
				
				// Recorremos el vector, pasando los .vm al ArrayList
				for (String arch : listaArchivos) {
					StringTokenizer sarc = new StringTokenizer(arch, ".");
					
					if (sarc.countTokens() == 2) {	// Si tiene un nombre.extension
						nombre = sarc.nextToken();	// Tomamos las partes
						extension = sarc.nextToken();
						
						if (extension.equals("vm")) {	// Si la extensión es .vm, lo agregamos
							nombre = (nombre + "." + extension);	// Reconstruimos el nombre del archivo
							archivo = new File(nombreCarpeta, nombre);	// Creamos un objeto File con el nombre de la carpeta y el nombre del archivo
							nombre = archivo.getAbsolutePath();	// Pasamos al nombre la ruta absoluta
							
							archivos.add(nombre);	// Agregamos el archivo al ArrayList
						}
						
					} else {	// Si no, próximo archivo
						continue;
					}
				}
				
				if (archivos.isEmpty()) {	// Si no se agregaron archivos al ArrayList
					System.err.println("El directorio seleccionado no contiene ningún archivo .vm");
					System.exit(0);
				}
			}
		}
	}
	
	public ArrayList<String> getArchivos() { return archivos; }
	public boolean esCarpeta() { return esCarpeta; }
	public String getNombreCarpeta() { return nombreCarpeta; }
	public String getNombreArchivoAEscribir() { return nombreArchivoAEscribir; }
}