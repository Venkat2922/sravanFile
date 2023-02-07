package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	public String readDataFromExcel(String sheetName, int rowNUm, int cellNum) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream("./TestD.xlsx");
		Workbook workBook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workBook.getSheet(sheetName);
		Row row = sheet.getRow(rowNUm);
		Cell cell = row.getCell(cellNum);
		return cell.getStringCellValue();
		
	}

}
