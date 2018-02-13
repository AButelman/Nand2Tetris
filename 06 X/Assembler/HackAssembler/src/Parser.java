import java.util.StringTokenizer;

public class Parser {
	private String comp;
	private String dest;
	private String jump;
	
	public Parser(String linea) {
		
		// PARSER. Dividimos la expresión en dest, comp y jump, dependiendo de si hay = o ; o ambas
		if (linea.contains("=")) {	// Si hay un =
			StringTokenizer t = new StringTokenizer(linea, "=");
			dest = t.nextToken();
			String siguiente = t.nextToken();
						
			if (siguiente.contains(";")) {	// Y además ;
				StringTokenizer d = new StringTokenizer(siguiente, ";");
								
				if (!(d.hasMoreTokens())) {	// Si se escribió el ; pero antes nada
					System.err.println("Error de sintaxis, se debe escribir algo antes del ; ");
					System.exit(0);
				}
								
				comp = d.nextToken();
								
				if (!(d.hasMoreTokens())) {	// Si se escribió el ; pero luego nada
					System.err.println("Error de sintaxis, se debe escribir algo luego del ; ");
					System.exit(0);
				}
								
				jump = d.nextToken();
								
			} else {	// Si hay = pero no ;
				comp = siguiente;
				jump = null;
			}
			
		} else if (linea.contains(";")) {	// Si hay ; pero no =
			StringTokenizer p = new StringTokenizer(linea, ";");
							
			if (!(p.hasMoreTokens())) {	// Si se escribió el ; pero antes nada
				System.err.println("Error de sintaxis.");
				System.exit(0);
			}
							
			comp = p.nextToken();
							
			if (!(p.hasMoreTokens())) {	// Si se escribió el ; pero luego nada
				System.err.println("Error de sintaxis.");
				System.exit(0);
			}
			jump = p.nextToken();
			dest = null;
		} else {	// Si no hay = ni ; ni era una instruccion-A
			System.err.println("Error de sintaxis.");
			System.exit(0);
		}
	}
	
	public String getComp() { return comp; }
	public String getDest() { return dest; }
	public String getJump() { return jump; }
}
