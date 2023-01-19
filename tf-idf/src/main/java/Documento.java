import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Documento {

	private List<String> lineas;
	private List<String> palabras;

	public Documento(String filePath) {
		this.lineas = new ArrayList<>();
		this.palabras = new ArrayList<>();
		var file = new File(filePath);

		try (var br = new BufferedReader(new FileReader(file))) {
			var linea = "";

			while ((linea = br.readLine()) != null)
				if (!linea.isEmpty() && !linea.isBlank())
					this.lineas.add(linea);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Procesador.procesarDocumento(this, "[a-zA-Z'-]+");
	}

	public List<String> getLineas() {
		return this.lineas;
	}

	public List<String> getPalabras() {
		return this.palabras;
	}
}
