import java.util.ArrayList;

public class VMTranslator {
	private ArrayList<String> archivos;
	private String archivo;
	private Parser p;
	private CodeWriter code;
	private Comandos commandType;
	private String arg1;
	private int arg2;
	private Argumentos a;
	
	private void validarArgumento(String[] argumentos) {
		a = new Argumentos();
		a.validar(argumentos);
		
		archivos = a.getArchivos();	// Tomamos la lista de archivos de la carpeta, o el nombre del archivo si es uno sólo
	}
	
	private void traducir(){
		code = new CodeWriter(a.getNombreArchivoAEscribir());	// Creamos un objeto CodeWriter con el nombre del archivo a escribir
		System.out.println("Escribiendo en: " + a.getNombreArchivoAEscribir());
		
		for (int i = archivos.size() - 1; i >= 0; i--) {	// Pasamos por todos los archivos de la lista
			archivo = archivos.remove(i);	// Tomamos el archivo de la lista

			p = new Parser(archivo);	// Creamos el objeto Parser a partir del archivo
			
			System.out.println("Leyendo: " + archivo);	// IMPRIMIMOS EL NOMBRE
			
			while (p.hasMoreCommands()){	// Mientras haya más comandos
				p.advance();				// Leemos el siguiente comando
			
											// Sacamos sus partes
				commandType = p.commandType();
				arg1 = p.getArg1();
				arg2 = p.getArg2();
				
				if (commandType == Comandos.C_ARITHMETIC) {	// Si es un comando aritmético
					code.writeArithmetic(arg1);
				} else if (commandType == Comandos.C_PUSH || commandType == Comandos.C_POP) {	// Si es un comando Push o Pop
					code.writePushPop(commandType, arg1, arg2);
				}
			}
		}
		code.close();	// Cerramos la corriente al archivo
	}
	
	public static void main(String[] args) {
		VMTranslator vmt = new VMTranslator();
		vmt.validarArgumento(args);	// Validamos que los argumentos estén correctamente escritos en el terminal
		vmt.traducir();
	}

}
