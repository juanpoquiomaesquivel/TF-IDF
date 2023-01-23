import java.io.FileOutputStream;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private String xlFilePath;

	public Excel crearNuevoArchivoExcel(String filePath) {
		try {
			this.xlFilePath = filePath;
			workbook = new XSSFWorkbook();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public void guardarYCerrarArchivo() {
		try {
			var out = new FileOutputStream(xlFilePath);
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void escribirFullExcel(String sheetName, Map<Integer, Object[]> data) {
		sheet = workbook.createSheet(sheetName);
		var keyset = data.keySet();
		int rowNumber = 0;

		for (Integer key : keyset) {
			var row = sheet.createRow(rowNumber++);
			var objArr = data.get(key);
			int cellNumber = 0;

			for (Object obj : objArr) {
				var cell = row.createCell(cellNumber++);

				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				} else if (obj instanceof Double) {
					cell.setCellValue((Double) obj);
				} else if (obj instanceof Float) {
					cell.setCellValue((Float) obj);
				}
			}
		}
	}
}
