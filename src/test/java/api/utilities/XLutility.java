package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutility {

	//refer this youtube channel for this file on 29th min
	//https://youtu.be/a4VDgcoltBw?si=LzQnOfMR4TsVnRDg
	public String path;
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	
	public XLutility(String excelPath) {
		this.path = excelPath;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException {
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rowNum);
		int lastCellNum = row.getLastCellNum();
		wb.close();
		fi.close();
		return lastCellNum;
	}
	
	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rowNum);
		cell = row.getCell(colNum);
		
		DataFormatter data = new DataFormatter();
		String cellData;
		
		try {
			cellData = data.formatCellValue(cell);
		} 
		catch (Exception e) {
			cellData = "";
		}
		
		return cellData;
	}
}
