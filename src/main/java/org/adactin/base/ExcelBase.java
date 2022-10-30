package org.adactin.base;

import java.io.FileInputStream;

import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelBase {
	
		public static String[][] readExcel() {
		String[][] arrayData = null;
		try {
			FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx");
			Workbook workbook = new XSSFWorkbook(input);
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Sheet1");
			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
			arrayData = new String[totalRows-1][totalCells];
			int initalrow= 1,initalcell=0,arrayrow=0;
			for (int i = initalrow; i < totalRows; i++,arrayrow++) {
				int arraycell=0;
				for (int j = initalcell; j < totalCells; j++,arraycell++) {
					Cell cell = sheet.getRow(i).getCell(j);
					arrayData[arrayrow][arraycell] = getCellvalue(cell);
				}	
			}
		}catch (IOException e ) {
			System.out.println(e.getStackTrace());
		}
		return arrayData;

	}
	public static String getCellvalue(Cell cell) {
		String value=null;
		CellType cellType = cell.getCellType();
		if(cellType == CellType.STRING) {
			value = cell.getStringCellValue();
		}
		return value;
		
		
	}	
	
	
		
	}



