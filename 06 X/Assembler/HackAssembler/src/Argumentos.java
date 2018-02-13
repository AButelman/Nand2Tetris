import java.util.StringTokenizer;

public class Argumentos {

	private String extension;
	private String entrada;
	private String salida;
	
	
	public void validar (String[] argumentos) {
		if (!(argumentos.length == 1)) {
			System.out.println("La sintaxis correcta es java HackAssembler ArchivoAEnsamblar.asm");
			System.exit(0);
		}
		
		StringTokenizer st = new StringTokenizer(argumentos[0], ".");
		
		if (!(st.countTokens()==2)) {
			System.out.println("La sintaxis correcta es java HackAssembler ArchivoAEnsamblar.asm");
			System.exit(0);
		}
		
		salida = st.nextToken();
		salida = salida + ".hack";
		
		extension = st.nextToken();
		extension = extension.toLowerCase();
		
		if (!(extension.equals("asm"))) {
			System.out.println("La sintaxis correcta es java HackAssembler ArchivoAEnsamblar.asm");
			System.exit(0);
		}
		
		entrada = argumentos[0];
	}
	
	public String getEntrada() { return entrada; }
	
	public String getSalida() { return salida; }
}
