package testCases;

import java.io.IOException;

import org.testng.annotations.Factory;

import utilities.ExcelUtilities;

public class Myfactory {
	@Factory
	public Object[] loginData() throws IOException {
		String path = ".//testData//SampleTestData.xlsx";
		ExcelUtilities xlObj = new ExcelUtilities(path, "Sheet1");
		int rowCount = xlObj.getRowCount();
		Object[] output = new Object[rowCount];
		String email, pass, valid = "";
		for (int row = 1; row <= rowCount; row++) {
			email = xlObj.getCellValue(row, 0);
			pass = xlObj.getCellValue(row, 1);
			valid = xlObj.getCellValue(row, 2);
			output[row - 1] = new TC003_LoginDatadriven_Factory(email, pass, valid);
		}
		return output;
	}
}
