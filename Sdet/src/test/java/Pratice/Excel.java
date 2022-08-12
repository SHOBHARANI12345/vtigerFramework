package Pratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	/**
	 * This method is used Fetch data from ExcelSheet
	 * @author Shobha
	 */

	public static void main(String[] args) throws Throwable {

FileInputStream fis=new FileInputStream("./Book1.xlsx");
Workbook book = WorkbookFactory.create(fis);
Sheet sh = book.getSheet("Sheet1");
Row ro = sh.createRow(0);
  Cell cel = ro.createCell(5);
cel.setCellValue("Testyantra");

FileOutputStream fos = new FileOutputStream("./Book1.xlsx");
book.write(fos);
book.close();

}}
