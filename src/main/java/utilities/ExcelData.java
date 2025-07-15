package utilities;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelData {
	
	static XSSFWorkbook workbook;
	static XSSFRow row;
	static XSSFSheet sheet;
	
	public static String[][] GetSheet(String fileName, String sheetname) throws IOException {
		
		String[][] data = null;

		try {

			FileInputStream input = new FileInputStream(new File("D:\\TESTING\\AutomationProjects\\Hybrid\\Excel\\" + fileName + ".xlsx"));

			workbook = new XSSFWorkbook(input);
			sheet = workbook.getSheet(sheetname);

			// get the number of rows
			int rowCount = sheet.getLastRowNum();

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];

			// loop through the rows
			for (int i = 1; i < rowCount + 1; i++) {
				try {
					row = sheet.getRow(i);
					for (int j = 0; j < columnCount; j++) { // loop through the
						// columns
						try {
							String cellValue = "";
							try {
								if (cellValue != null) {
									cellValue = row.getCell(j).getStringCellValue();
								}
							} catch (NullPointerException e) {

							}

							data[i - 1][j] = cellValue; // add to the data array
						} catch (Exception e) {
						
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				workbook.close();
				input.close();
			}

		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return data;
	}

}
