package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writing_Excel {
	private static XSSFWorkbook wb;
	
	public XSSFCell update_Data(int Row,int column) {
		XSSFSheet sheet = wb.getSheet("sheet1");
		XSSFCell cell = sheet.createRow(Row).createCell(column);
		
		return cell;
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
    FileInputStream fis=new FileInputStream("S:\\Javafolder\\Practice\\src\\test\\resources\\Data1.xlsx");
		 wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("sheet1");
		int lastrow = sheet.getLastRowNum();
		System.out.println(lastrow);
		Writing_Excel we=new Writing_Excel();
		for(int i=1; i<lastrow; i++) {
			//sheet.createRow(i).createCell(0).setCellValue("fail");
		we.update_Data(i, 6).setCellValue("pass");
		}
				
		FileOutputStream fos=new FileOutputStream(new File("S:\\Javafolder\\Practice\\src\\test\\resources\\Data1.xlsx"));
	     wb.write(fos);
	     wb.close();
	}

}
