import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		var noms = new String[5];
		var path = "C:\\Users\\juanp\\Escritorio\\TF-IDF";
		noms[0] = path + "\\how jack went to seek his fortune.txt";
		noms[1] = path + "\\the old woman and her pig.txt";
		noms[2] = path + "\\the rose-tree.txt";
		noms[3] = path + "\\the three sillies.txt";
		noms[4] = path + "\\tom tit tot.txt";
		var docs = new Documento[5];
		var N = noms.length;

		for (var i = 0; i < N; i++)
			docs[i] = new Documento(noms[i]);

		var listaPalabras = new ArrayList<List<String>>();

		for (var i = 0; i < N; i++)
			listaPalabras.add(docs[i].getPalabras().stream().distinct().collect(Collectors.toList()));

		var filePath = "C:\\Users\\juanp\\Escritorio\\TF-IDF\\tfidf-resultados.xlsx";
		var excel = new Excel();
		excel.crearNuevoArchivoExcel(filePath);

		var data = new TreeMap<Integer, Object[]>();
		data.put(1, new Object[] { "DOCUMENTO", "PALABRA", "TF-IDF", "PROMEDIO SECUENCIAL", "PROMEDIO PARALELO",
				"ACELERACIÓN" });

		var k = 1;

		for (var i = 0; i < N; i++) {
			var palabras = listaPalabras.get(i);

			for (String termino : palabras) {
				var obj = new Object[] { i + 1, termino, TFIDF.calcular(termino, docs[i], docs), 0, 0, 0 };
				data.put(++k, obj);
			}
		}

		excel.escribirFullExcel("resultados", data);
		excel.guardarYCerrarArchivo();
	}
}
