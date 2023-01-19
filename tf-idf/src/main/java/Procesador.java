import java.util.regex.Pattern;

public class Procesador {

	public static void procesarDocumento(Documento doc, String regex) {
		var lineas = doc.getLineas();
		var palabras = doc.getPalabras();
		var patt = Pattern.compile(regex);

		for (String linea : lineas) {
			var mat = patt.matcher(linea);

			while (mat.find())
				palabras.add(mat.group().toLowerCase());
		}
	}
}
