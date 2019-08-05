package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	FileInputStream fi;
	FileOutputStream fo;
	Workbook wb;
	Sheet sh;
	Row r;
	Cell c;

	// write constructor for storing excel path

	public ReadExcel(String inputexcel) {
		try {
			fi = new FileInputStream(inputexcel);
			wb = WorkbookFactory.create(fi);
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}

	}
		

	public int Getrowcount(String sheetname) {
		sh = wb.getSheet(sheetname);
		int rowcount = sh.getLastRowNum();
		return rowcount;
	}

	// count no of columns in row

	public int Getcellcount(String sheetname) {
		r = sh.getRow(0);
		int cellcount = r.getLastCellNum();
		return cellcount;
	}

	// get data from a cell

	public String Getcelldata(String sheetname, int row, int cell) {
		String data = "";
		if (wb.getSheet(sheetname).getRow(row).getCell(cell).getCellType() == Cell.CELL_TYPE_NUMERIC) {
			int celldata = (int) wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
			data = String.valueOf(data);
		}

		else {
			data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();

		}
		return data;
	}

	// write results
	public void setcelldata(String sheetname, int row, int column, String data, String outputexcel) throws IOException {
		sh = wb.getSheet(sheetname);
		sh.getRow(row).getCell(column).setCellValue(data);
		fo = new FileOutputStream(new File(outputexcel));
		wb.write(fo);
	}

	public void closefiles() throws IOException {
		fi.close();
		fo.close();
		wb.close();
	}

}
