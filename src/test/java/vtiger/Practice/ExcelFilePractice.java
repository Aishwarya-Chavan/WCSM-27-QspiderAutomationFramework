package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFilePractice {

	public static void main(String[] args)  throws EncryptedDocumentException,IOException{

		//step1 : Load the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step2 : Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3 : get control over sheet
		Sheet sheet = wb.getSheet("Organization");
		
		//step4 : get control over row
		Row rw = sheet.getRow(1);
		
		//step5 : get control over cell
		Cell ce = rw.getCell(2);
		
		//step6 : read the data inside the cell
		String value = ce.getStringCellValue();
		System.out.println(value);
	}
}
