package package1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Academy_Students extends Base_test {
	@Test(dataProvider = "data")
	public void main(Map<String, String> map) throws IOException, InterruptedException {

		Academy_Register ar = new Academy_Register(driver);
		ar.register_Page();
		String mail = RandomStringUtils.randomAlphanumeric(8);
		ar.details(map.get("Firstname"), map.get("Lastname"), mail + "@gmail.com", map.get("phnNum"),
				map.get("occupation"), map.get("Gender"));

	 	ar.passwords(map.get("password"), map.get("Newpassword"));
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		boolean msg = driver.findElement(By.xpath("(//h1)[2]")).isDisplayed();
		if (msg) {
			try {
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
			} catch (InterruptedException e) {
				System.out.println("error is: " + e.getMessage());
			}

		} else
			System.out.println("error messages displayed");

	}

	@DataProvider(name = "data")
	public Object[][] dataProvider() {
		XSSFWorkbook workbook = null;
		try {
			FileInputStream FIS = new FileInputStream("./src/test/resources/data.xlsx");
			workbook = new XSSFWorkbook(FIS);
			workbook.close();
			FIS.close();
		} catch (Exception e) {
			System.out.println("File location not found");

		}
		XSSFSheet sheet = workbook.getSheet("sheet3");
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRowNum][1];
		DataFormatter df = new DataFormatter();
		for (int i = 0; i < lastRowNum; i++) {
			Map<Object, Object> datamap = new HashMap<>();
			for (int j = 0; j < lastCellNum; j++) {
				datamap.put(df.formatCellValue(sheet.getRow(0).getCell(j)),
						df.formatCellValue(sheet.getRow(i + 1).getCell(j)));
			}
			obj[i][0] = datamap;
		}
		return obj;
	}

}
