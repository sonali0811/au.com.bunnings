package au.com.bunnings.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlers {

	// Method to read Test Execution data from test-data.xlsx file
	public static String getDataFromExcel(String fileName, String sheetName, int rowIndex, int cellIndex) {
		// Declare local variable
		String data = null;

		// Read data from Test Execution data file
		try {
			File f = new File("./test-data/" + fileName + ".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			data = c.toString();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	// Method to read Configuration data from config-data.properties file
	public static String readDataFromProperties(String fileName, String key) {
		// Declare local variable
		String data = null;
		// Read data from Configuration file
		try {
			File f = new File("./config-data/" + fileName + ".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			data = prop.getProperty(key).toString();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
