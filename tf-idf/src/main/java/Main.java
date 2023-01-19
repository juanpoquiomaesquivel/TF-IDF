public class Main {

	public static void main(String[] args) {
		String[] noms = new String[5];
		String path = "C:\\Users\\juanp\\Escritorio\\TF-IDF";
		noms[0] = path + "\\how jack went to seek his fortune.txt";
		noms[1] = path + "\\the old woman and her pig.txt";
		noms[2] = path + "\\the rose-tree.txt";
		noms[3] = path + "\\the three sillies.txt";
		noms[4] = path + "\\tom tit tot.txt";
		Documento[] docs = new Documento[5];
		var N = noms.length;

		for (var i = 0; i < N; i++) {
			docs[i] = new Documento(noms[i]);
		}

		String termino = "any";

		System.out.println("Tf-idf(" + termino + "): " + TFIDF.calcular(termino, docs[4], docs));
	}
}
