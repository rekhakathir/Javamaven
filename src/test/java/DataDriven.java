import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testcase) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\ExcelDriven\\Demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			// System.out.println(workbook.getSheetName(i));
			if (workbook.getSheetName(i).equalsIgnoreCase("demo")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> row = sheet.iterator(); // collection of rows
				//int noofrows = sheet.getPhysicalNumberOfRows();
				// System.out.println(noofrows);
				while (row.hasNext()) {
					Row nextrow = row.next();
					if (nextrow.getCell(i).getStringCellValue().equalsIgnoreCase(testcase)) {
						Iterator<Cell> ce = nextrow.cellIterator(); // collection of cells
						while (ce.hasNext()) {
							Cell value = ce.next();

							if (value.getCellType() == CellType.STRING) {
								a.add(value.getStringCellValue());
							}

							else {

								a.add(NumberToTextConverter.toText(value.getNumericCellValue()));
							}

						}

					}
				}
			}

		}
		return a;
	}

}
