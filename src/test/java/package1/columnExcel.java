package package1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class columnExcel {

	public static void main(String[] args) {
		XSSFWorkbook workbook = null;
		try {
			FileInputStream FIS = new FileInputStream("./src/test/resources/apachefile.xlsx");
			workbook = new XSSFWorkbook(FIS);
			workbook.close();
			FIS.close();
		} catch (FileNotFoundException e) {
			System.out.println("File location not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("book not found");
			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheet("sheet1");
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("Row: " + lastRowNum);
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("column: " + lastCellNum);
		Object[][] obj = new Object[lastRowNum][1];
		HashMap<String, String> map = null;
		for (int c = 1; c < lastCellNum; c++) {
			map =new HashMap<>();
			System.out.println("going to inner loop: "+map);
			for (int r = 1; r < lastRowNum; r++) {
				map.put(sheet.getRow(r).getCell(0).toString(), sheet.getRow(r).getCell(c).toString());
		}
			obj[c][0] = map;
			System.out.println(map);
	}
		System.out.println(obj[1][0]);

	}

}
