package Utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	public ExcelUtilities(String xlPath, String xlSheet){
		try{
			workbook = new XSSFWorkbook(xlPath);
			sheet = workbook.getSheet(xlSheet);
		}
		catch (IOException e){
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//ExcelUtilities exl = new ExcelUtilities(projPath, "Waybill");
		//exl.getRowCount();
		//exl.getCellData(1,0);
	}
	public static int getRowCount(){
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println(rowCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return rowCount;
		
	}
	
	public static double getCellData(int rNo, int cNo ){
		double cellData = 0;
		try {
			cellData = sheet.getRow(rNo).getCell(cNo).getNumericCellValue();
			System.out.println(cellData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return cellData;
		
	}

}
