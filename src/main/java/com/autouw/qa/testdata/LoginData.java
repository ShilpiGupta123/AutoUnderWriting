package com.autouw.qa.testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LoginData {

	@SuppressWarnings("static-access")
	public String[][] getCellData(String path, String sheetName) throws InvalidFormatException, IOException {
		FileInputStream stream = new FileInputStream("D:\\scripts\\local\\login_data.csv");
		Workbook workbook = WorkbookFactory.create(stream);
		Sheet s = workbook.getSheet("login_data");
		int rowcount = s.getLastRowNum();
		int cellcount = s.getRow(0).getLastCellNum();
		String data[][] = new String[rowcount][cellcount];
		for (int i = 1; i <= rowcount; i++) {
			Row r = s.getRow(i);
			for (int j = 0; j<r.getLastCellNum(); j++) {
				Cell c = r.getCell(j);
				try {
					if (c.getCellType() == c.CELL_TYPE_STRING) {
						data[i - 1][j] = c.getStringCellValue();
					} 
					else
					{
						data[i - 1][j] = String.valueOf(c.getNumericCellValue());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
}


