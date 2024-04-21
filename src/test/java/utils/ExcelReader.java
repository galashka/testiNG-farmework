package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	private static Workbook myBook;
	private static Sheet mySheet;
	
	/**
	 * 
	 * @param filePath
	 */
	private static void openExcelFile(String filePath) {
		
		try {
			
		FileInputStream fis = new FileInputStream(filePath);
		
		myBook = new XSSFWorkbook(fis);
		
		}catch(IOException e){
			
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param sheetName
	 */
	private static void loadSheet(String sheetName) {
		
		mySheet = myBook.getSheet(sheetName);
	}
	/**
	 * 
	 * @return
	 */
	private static int rowCount() {
		
		return mySheet.getPhysicalNumberOfRows();
	}
	/**
	 * 
	 * @param row
	 * @return
	 */
	private static int columnCount(int rowIndex) {
		
		return mySheet.getRow(rowIndex).getLastCellNum();
	}
	/**
	 * 
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 */
	private static String getCellData(int rowIndex, int colIndex) {
		
			return mySheet.getRow(rowIndex).getCell(colIndex).toString();	
	}
	/**
	 * @param filePath
	 * @param sheetName
	 * @return
	 */
	public static Object[][] excelToArray(String filePath, String sheetName){
		
		openExcelFile(filePath);
		
		loadSheet(sheetName);
		
		int rows = rowCount();
		
		int columns = columnCount(0);
		
		Object[][] sheetData = new Object[rows - 1][columns];
		
		for(int row = 1; row < rows; row++) {
			
			for(int col = 0; col < columns; col++) {
				
				sheetData[row - 1][col] = getCellData(row, col);
			}
		}
		return sheetData;
	}
	
	
	
	
}
