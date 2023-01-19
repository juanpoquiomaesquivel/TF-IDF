import java.util.ArrayList;
import java.util.List;

public class TFIDF {

	public static double calcular(String term, Documento doc, Documento[] docs) {
		return tf(term, doc) * idf(term, docs);
	}

	private static double tf(String term, Documento doc) {
		var palabras = doc.getPalabras();
		var res = 0.0;

		for (String palabra : palabras)
			if (palabra.equals(term))
				res++;

		return res / palabras.size();

	}

	private static double idf(String term, Documento[] docs) {
		var listaPalabras = new ArrayList<List<String>>();

		for (Documento doc : docs)
			listaPalabras.add(doc.getPalabras());

		var c = 0.0;

		for (List<String> palabras : listaPalabras)
			for (String palabra : palabras)
				if (palabra.equals(term)) {
					c++;
					break;
				}

		return Math.log(docs.length / c);
	}
}
