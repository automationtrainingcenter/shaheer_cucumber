package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	Workbook book;
	Sheet sheet;

	// returns absolute path of the given file
	private static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}

	// read the data from property file by its name
	private static String readProperty(String propName) {
		try {
			FileInputStream fis = new FileInputStream(getFilePath("resources", "config.properties"));
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(propName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	// open excel
	private void openExcel(String folderName, String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(getFilePath(folderName, fileName));
			if (fileName.endsWith("xlsx")) {
				book = new XSSFWorkbook(fis);
			} else if (fileName.endsWith("xls")) {
				book = new HSSFWorkbook(fis);
			} else {
				throw new RuntimeException("invalid file name or extension");
			}
			sheet = book.getSheet(sheetName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// count the number of rows
	private int getRows() {
		return sheet.getLastRowNum();
	}

	// count the number of columns
	private int getColumns() {
		return sheet.getRow(0).getLastCellNum();
	}

	// read data from a cell
	private String readData(int rnum, int cnum) {
		String data = "";
		Cell cell = sheet.getRow(rnum).getCell(cnum);
		try {
			CellType cellType = cell.getCellType();
			switch (cellType) {
			case STRING:
				data = cell.getStringCellValue();
				break;
			case NUMERIC:
//			int i = (int) cell.getNumericCellValue();
//			data = Integer.toString(i);
				data = Integer.toString((int) cell.getNumericCellValue());
			case BLANK:
				data = "";
				break;
			default:
				data = "";
			}
		} catch (Exception e) {

		}
		return data;
	}

	// close excel
	private void closeExcel() {
		try {
			book.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<List<String>> getExcelSheetData(String folderName, String fileName, String sheetName) {
		openExcel(folderName, fileName, sheetName);
		int nor = getRows();
		int noc = getColumns();
		List<List<String>> rows = new ArrayList<>();
		// inner list is for columns and outer list for rows
		for (int i = 1; i <= nor; i++) {
			List<String> cells = new ArrayList<>();
			// rows
			for (int j = 0; j < noc; j++) {
				// columns
				cells.add(readData(i, j));
			}
			// add that entire row to the data list
			rows.add(cells);
		}
		return rows;
	}

//	public static void main(String[] args) {
//		ExcelHelper excel = new ExcelHelper();
//		List<List<String>> excelRows = excel.getExcelSheetData("resources", "testdata.xls", "empData");
//		for (int i = 0; i < excelRows.size(); i++) {
//			for (int j = 0; j < excelRows.get(i).size(); j++) {
//				System.out.print(excelRows.get(i).get(j)+"\t");
//			}
//			System.out.println();
//		}
//	}

}
