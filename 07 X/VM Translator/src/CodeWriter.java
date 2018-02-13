import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CodeWriter {
	private Charset conjuntoCaracteres;
	private Path archivoAEscribir;
	private BufferedWriter escritor;
	private int contadorIgual = -1;	// Empiezan en -1 porque cuando se llama se les suma 1
	private int contadorMayor = -1;
	private int contadorMenor = -1;
	private int contadorFinal = -1;
	private int contadorLoop = -1;
/*	private int contadorPush = -1;
	private int contadorPop = -1; */
	
	public CodeWriter(String nombreArchivo){
		conjuntoCaracteres = Charset.forName("ISO-8859-1");
		archivoAEscribir = Paths.get(nombreArchivo);
		try {
			escritor = Files.newBufferedWriter(archivoAEscribir,conjuntoCaracteres);
		} catch (IOException e){
			System.err.println("Error en la escritura del archivo " + archivoAEscribir);
			e.getStackTrace();
		}
	}
	
	public void writeArithmetic(String comandoAritm) {
		
		switch (comandoAritm) {
			case ("add"):
				try {
					escritor.write("// ADD");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	//SP--");
					escritor.newLine();
					escritor.write("D=M	// D = *SP");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	//SP--");
					escritor.newLine();
					escritor.write("D=D+M	// D = D + *SP");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("M=D	// *SP = D");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
				break;
			case ("sub"):
				try {
					escritor.write("// SUB");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M-1");
					escritor.newLine();
					escritor.write("AM=M-1	// SP - 2");
					escritor.newLine();
					escritor.write("D=M	// D = *(SP - 2)");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP + 1");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("D=D-M	// D = D - *SP");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	// SP - 1");
					escritor.newLine();
					escritor.write("M=D	// *SP = D");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
				break;
			case ("neg"):
				try {
					escritor.write("// NEG");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	// SP--");
					escritor.newLine();
					escritor.write("M=-M	// *SP = -*SP");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
				break;
			case ("eq"):
				try {
					escritor.write("// EQ");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	// SP--");
					escritor.newLine();
					escritor.write("D=M	// D = *SP");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	// SP--");
					escritor.newLine();
					escritor.write("D=D-M	// D = D - *SP");
					escritor.newLine();
					String igual = generarSimbolo("igual");
					escritor.write("@IGUAL" + igual);
					escritor.newLine();
					escritor.write("D;JEQ	// Si d = 0, entonces los números eran iguales, goto IGUAL");
					escritor.newLine();
					escritor.write("@SP	// Si no, eran diferentes, escribimos FALSE (0)");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("M=0	// *SP = FALSE (0)");
					escritor.newLine();
					String fin = generarSimbolo("final");
					escritor.write("@FIN" + fin);
					escritor.newLine();
					escritor.write("0;JMP	// GOTO FIN");
					escritor.newLine();
					escritor.write("(IGUAL" + igual + ")");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("M=-1	// *SP = TRUE (-1)");
					escritor.newLine();
					escritor.write("(FIN" + fin + ")");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
				break;
			case ("gt"):
				try {
					escritor.write("// GT");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M-1");
					escritor.newLine();
					escritor.write("AM=M-1	// SP-2");
					escritor.newLine();
					escritor.write("D=M	// D = *SP = x");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M+1	// SP++");
					escritor.newLine();
					escritor.write("D=D-M	//  D = D - *SP = x - y");
					escritor.newLine();
					String mayor = generarSimbolo("mayor");
					escritor.write("@MAYOR" + mayor);
					escritor.newLine();
					escritor.write("D;JGT	// Si d > 0 entonces x > y, goto MAYOR");
					escritor.newLine();
					escritor.write("@SP	// Si no, escribimos FALSE (0)");
					escritor.newLine();
					escritor.write("AM=M-1	// SP--");
					escritor.newLine();
					escritor.write("M=0	// *SP = FALSE (0)");
					escritor.newLine();
					String fin = generarSimbolo("final");
					escritor.write("@FIN" + fin);
					escritor.newLine();
					escritor.write("0;JMP	// GOTO FIN");
					escritor.newLine();
					escritor.write("(MAYOR" + mayor + ")");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	// SP--");
					escritor.newLine();
					escritor.write("M=-1	// *SP = TRUE (-1)");
					escritor.newLine();
					escritor.write("(FIN" + fin + ")");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
				break;
			case ("lt"):
				try {
					escritor.write("// LT");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M-1");
					escritor.newLine();
					escritor.write("AM=M-1	// SP-2");
					escritor.newLine();
					escritor.write("D=M	// D = *SP = x");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M+1	// SP++");
					escritor.newLine();
					escritor.write("D=D-M	//  D = D - *SP = x - y");
					escritor.newLine();
					String menor = generarSimbolo("menor");
					escritor.write("@MENOR" + menor);
					escritor.newLine();
					escritor.write("D;JLT	// Si d < 0 entonces x < y, goto MENOR");
					escritor.newLine();
					escritor.write("@SP	// Si no, escribimos FALSE (0)");
					escritor.newLine();
					escritor.write("AM=M-1	// SP--");
					escritor.newLine();
					escritor.write("M=0	// *SP = FALSE (0)");
					escritor.newLine();
					String fin = generarSimbolo("final");
					escritor.write("@FIN" + fin);
					escritor.newLine();
					escritor.write("0;JMP	// GOTO FIN");
					escritor.newLine();
					escritor.write("(MENOR" + menor + ")");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	// SP--");
					escritor.newLine();
					escritor.write("M=-1	// *SP = TRUE (-1)");
					escritor.newLine();
					escritor.write("(FIN" + fin + ")");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
				break;
			case ("and"):
				try {
					escritor.write("// AND");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	//SP--");
					escritor.newLine();
					escritor.write("D=M	// D = *SP = y");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	//SP--");
					escritor.newLine();
					escritor.write("D=D&M	// D = D & *SP = y & x");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("M=D	// *SP = D");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
				break;
			case ("or"):
				try {
					escritor.write("// OR");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	//SP--");
					escritor.newLine();
					escritor.write("D=M	// D = *SP = y");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	//SP--");
					escritor.newLine();
					escritor.write("D=D|M	// D = D | *SP = y | x");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("M=D	// *SP = D");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
				break;
			case ("not"):
				try {
					escritor.write("// NOT");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	// SP--");
					escritor.newLine();
					escritor.write("M=!M	// *SP = !*SP");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
				break;
		}
	}
	
	public void writePushPop(Comandos comando, String segment, int index){
		
		if (comando == Comandos.C_PUSH) {	// Si es un comando PUSH
			if (segment.equals("constant")) {	// De una constante
				try {
					escritor.write("// PUSH CONSTANT " + index);
					escritor.newLine();
					escritor.write("@" + index);
					escritor.newLine();
					escritor.write("D=A	// D = lo que se haya pasado");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("M=D	// *SP = lo que se haya pasado");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
			} else if (segment.equals("local") || segment.equals("argument") || segment.equals("this")
						|| segment.equals("that")) {	// Estos segmentos se comportan igual
				String argumento = "";
				switch (segment) {		// Dependiendo el segmento que se haya pasado hay que escribir en otra base
					case ("local"):
						argumento = "LCL";
						break;
					case ("argument"):
						argumento = "ARG";
						break;
					case ("this"):
						argumento = "THIS";
						break;
					case ("that"):
						argumento = "THAT";
						break;
				}
				
				try {
					escritor.write("// PUSH " + argumento + " " + index);
					escritor.newLine();
					escritor.write("@" + argumento);
					escritor.newLine();
					escritor.write("D=M	// D = " + argumento);
					escritor.newLine();
					escritor.write("@" + index);
					escritor.newLine();
					escritor.write("D=D+A	// D = " + argumento + " + " + index);
					escritor.newLine();
					escritor.write("A=D");
					escritor.newLine();
					escritor.write("D=M	// D = *(" + argumento  + " + " + index +")");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("M=D	// *SP = *addr");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
			} else if (segment.equals("pointer") || segment.equals("temp")) {
				// pointer y temp funcionan de la misma manera, sólo que con distinta base
				int pt = 0;
				String segmento = "";
				switch (segment) {
					case ("pointer"):
						pt = 3;
						segmento = "POINTER";
						break;
					case ("temp"):
						pt = 5;
						segmento = "TEMP";
						break;
				}
				
				try {
					escritor.write("// PUSH " + segmento + " " + index);
					escritor.newLine();
					escritor.write("@" + pt);
					escritor.newLine();
					escritor.write("D=A	// D = " + pt);
					escritor.newLine();
					escritor.write("@" + index);
					escritor.newLine();
					escritor.write("A=D+A	// D = " + pt + " + i");
					escritor.newLine();
					escritor.write("D=M	// D = *(" + pt + " + i)");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("M=D	// *SP = *(" + pt + " + i)");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
			} else if (segment.equals("static")) {
				try {
					// @nombreArchivo.index es el nombre de la variable para el segmento static, al cual el
					// assembler le designará un espacio de memoria entre el 16 y 255
					escritor.write("// PUSH STATIC " + index);
					escritor.newLine();
					escritor.write("@" + archivoAEscribir.getFileName() + "." + index);
					escritor.newLine();
					escritor.write("D=M	// D = static i");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("M=D	// *SP = static i");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M+1	// SP++");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
			}
		}
		
		if (comando == Comandos.C_POP) {
			if (segment.equals("local") || segment.equals("argument") || segment.equals("this")
					|| segment.equals("that")) {	// Estos segmentos se comportan igual
				String argumento = "";
				switch (segment) {		// Dependiendo el segmento que se haya pasado hay que escribir en otra base
					case ("local"):
						argumento = "LCL";
						break;
					case ("argument"):
						argumento = "ARG";
						break;
					case ("this"):
						argumento = "THIS";
						break;
					case ("that"):
						argumento = "THAT";
						break;
				}
			
				try {
					escritor.write("// POP " + argumento + " " + index);
					escritor.newLine();
					escritor.write("@" + argumento);
					escritor.newLine();
					escritor.write("D=M	// D = " + argumento);
					escritor.newLine();
					escritor.write("@" + index);
					escritor.newLine();
					escritor.write("D=D+A	// D = " + argumento + " " + index);
					escritor.newLine();
					escritor.write("@R15");
					escritor.newLine();
					escritor.write("M=D	// addr = " + argumento + " " + index);
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M-1	// SP--");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("D=M	// D = *SP");
					escritor.newLine();
					escritor.write("@R15");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("M=D	// addr = *SP");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
			} else if (segment.equals("pointer") || segment.equals("temp")) {
				// pointer y temp funcionan de la misma manera, sólo que con distinta base
				int pt = 0;
				String segmento = "";
				switch (segment) {
					case ("pointer"):
						pt = 3;
						segmento = "POINTER";
						break;
					case ("temp"):
						pt = 5;
						segmento = "TEMP";
						break;
				}
				
				try {
					escritor.write("// POP " + segmento + " " + index);
					escritor.newLine();
					escritor.write("@" + pt);
					escritor.newLine();
					escritor.write("D=A	// D = " + pt);
					escritor.newLine();
					escritor.write("@" + index);
					escritor.newLine();
					escritor.write("D=D+A	// D = " + pt + " + i");
					escritor.newLine();
					escritor.write("@R15");
					escritor.newLine();
					escritor.write("M=D	// addr = " + pt + " + i");
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("AM=M-1	// SP--");
					escritor.newLine();
					escritor.write("D=M	// D = pop");
					escritor.newLine();
					escritor.write("@R15");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("M=D	// *addr = *SP");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
			} else if (segment.equals("static")) {
				try {
					escritor.write("// POP STATIC " + index);
					escritor.newLine();
					escritor.write("@SP");
					escritor.newLine();
					escritor.write("M=M-1	// SP--");
					escritor.newLine();
					escritor.write("A=M");
					escritor.newLine();
					escritor.write("D=M	// D = *SP");
					escritor.newLine();
					// @nombreArchivo.index es el nombre de la variable para el segmento static, al cual el
					// assembler le designó un espacio de memoria entre el 16 y 255, o le designará si no fue hecho
					escritor.write("@" + archivoAEscribir.getFileName() + "." + index);
					escritor.newLine();
					escritor.write("M=D	// static i = *SP");
					escritor.newLine();
				} catch (IOException e) {
					System.err.println("Error en la escritura del archivo " + archivoAEscribir);
					e.getStackTrace();
				}
			}
		}
	}
	
	private String generarSimbolo(String tipo){
		switch (tipo) {
			case ("igual"):
				contadorIgual++;
				return Integer.toString(contadorIgual);
			case ("mayor"):
				contadorMayor++;
				return Integer.toString(contadorMayor);
			case ("menor"):
				contadorMenor++;
				return Integer.toString(contadorMenor);
			case ("final"):
				contadorFinal++;
				return Integer.toString(contadorFinal);
			case ("loop"):
				contadorLoop++;
				return Integer.toString(contadorLoop);
			/* case ("push"):
				contadorPush++;
				return Integer.toString(contadorPush);
			case ("pop"):
				contadorPop++;
				return Integer.toBinaryString(contadorPop); */
		}
		return "";	// No debería pasar
	}
	
	public void close(){	// Cierra el stream
		try {
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}