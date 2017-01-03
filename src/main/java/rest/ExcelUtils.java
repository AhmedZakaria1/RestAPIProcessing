package rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.*;

public class ExcelUtils {
	HSSFWorkbook Excel;
	HSSFSheet Sheet;
	HSSFCell Cell;
	HSSFRow Row;
	InputStream is;
	FileOutputStream os;
	File excelFile;

	ExcelUtils(String excelFilePath, int sheetNumber) {

		try {
			excelFile = new File(excelFilePath);
			is = new FileInputStream(excelFile);
			Excel = new HSSFWorkbook(is);
			Sheet = Excel.getSheetAt(sheetNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Contains api's for excel stuff

	protected int numberColumns() {
		return Sheet.getRow(0).getLastCellNum();
	}

	protected int numberRows() {

		return Sheet.getLastRowNum();
	}

	protected String cellData(int row, int col) {
		if (Sheet.getRow(row).getCell(col) != null)
			try{
			return Sheet.getRow(row).getCell(col).getStringCellValue();
			} catch (Exception e){
				return String.valueOf(Sheet.getRow(row).getCell(col).getNumericCellValue());
			}
		return null;
	}

	protected void setcellData(int row, int col, String value) {
		if (Sheet.getRow(row).getCell(col) != null) { // overwrite
			Sheet.getRow(row).getCell(col).setCellValue(value);
			try {
				os = new FileOutputStream(excelFile);
				Excel.write(os);
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (Sheet.getRow(row).getCell(col) == null) { // new cell
			Cell = Sheet.getRow(row).createCell(col);
			Cell.setCellValue(value);
			try {
				os = new FileOutputStream(excelFile);
				Excel.write(os);
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
