package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow ro;
	public static XSSFCell ce;
	String path;
	String sheet;
	
	public ExcelUtilities(String path, String sheet) {
		this.path = path;
		this.sheet = sheet;
	}
	
	public int getRowCount() throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	
	public int getCellCount(int rowNum) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet);
		ro = sh.getRow(rowNum);
		int cellCount = ro.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	
	public String getCellValue(int row, int cell) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet);
		ro = sh.getRow(row);
		ce = ro.getCell(cell);
		String value;
		try {
			DataFormatter formate = new DataFormatter();
			value = formate.formatCellValue(ce);
		} catch (Exception e) {
			value="";
		}
		wb.close();
		fi.close();
		return value;
	}
	
}
