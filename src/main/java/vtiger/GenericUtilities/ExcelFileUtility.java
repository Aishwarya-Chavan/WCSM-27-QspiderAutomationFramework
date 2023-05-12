package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of generic methods releated to excel sheet
 * @author mrsai
 *
 */
public class ExcelFileUtility {

	/**
	 * This method will read data from excel sheet
	 * @param SheetName 
	 * @param celNo 
	 * @param rowNo 
	 * @param SheetName 
	 * @param rowNo 
	 * @param celNo 
	 * @param j 
	 * @param i 
	 * @param string 
	 * @return 
	 * @throws EncryptedDocumentException 
	 * @throws IOException
	 */

	
	public String readDataFromExcel(String SheetName,int rowNo,int celNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(SheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		wb.close();
		return value;
		
	}
	
	/**
	 * This 
	 * @param SheetName
	 * @param rowNo
	 * @param celNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void writeIntoExcel(String SheetName,int rowNo,int celNo, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelfilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row rw = sh.createRow(rowNo);
		Cell cel = rw.createCell(celNo);
		cel.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.excelfilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	/**
	 * This method will read data from excel sheet and return it to data provider
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	/*public Object[][] readDatafromExcelToDataProvider(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelfilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		for(int i =0;i<lastRow;i++) //row
		{
			for(int j=0;j<lastCell;j++) //cell
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}*/
	public Object[][] readDatafromExcelToDataProvider(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelfilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		for(int i =0;i<lastRow;i++) //row
		{
			for(int j=0;j<lastCell;j++) //cell
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	
	
}
