package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "allData")
	public String[][] getAllData() throws IOException {
		
		String excelPath = "./src/test/resources/TestData/Data.xlsx";
		XLutility xl = new XLutility(excelPath);
		
		int rows = xl.getRowCount("Sheet1");
		int columns = xl.getCellCount("Sheet1", 1);
		
		String[][] apiData = new String[rows][columns];
		
		for(int i = 1; i <= rows; i++) {
			for(int j = 0; j < columns; j++) {
				apiData[i-1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		
		return apiData;
	}
	
	@DataProvider(name = "allUserNames")
	public String[] getUserNames() throws IOException {
		
		String excelPath = "./src/test/resources/TestData/Data.xlsx";
		
		XLutility xl = new XLutility(excelPath);
		
		int rows = xl.getRowCount("Sheet1");
		
		String[] usernames = new String[rows];
		
		for (int i = 1; i <= rows; i++) {
			usernames[i-1] = xl.getCellData("Sheet1", i, 1);
		}
		
		return usernames;
	}
}
