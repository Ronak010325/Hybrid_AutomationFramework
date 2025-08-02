package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {
//	DataProvider 1
	@DataProvider(name="loginData") //parallel=true
	public Object[][] loginData() throws IOException {
		String path = ".//testData//SampleTestData.xlsx";
		ExcelUtilities xlObj = new ExcelUtilities(path, "Sheet1");
		int rowCount = xlObj.getRowCount();
		int cellCount = xlObj.getCellCount(1);
		String[][] output = new String[rowCount][cellCount];
		for (int row = 1 ; row <= rowCount ; row++) {
			for (int cell = 0 ; cell < cellCount ; cell++) {
				output[row-1][cell] = xlObj.getCellValue(row, cell);
			}
		}
		return output;
	}
//	DataProvider 2
//	DataProvider 3
//	DataProvider 4
//	DataProvider 5
}
