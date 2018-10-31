package demo_package;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.File;

public class ReadExcel {
	public static void main(String[] args) {
		try(Workbook wb = WorkbookFactory.create(new File("D:/Excell.xlsx"))){
	
			Sheet sheet = wb.getSheetAt(0); 
			
			int rowStart = sheet.getFirstRowNum();
			int rowEnd = sheet.getLastRowNum();
			
			for(int i = rowStart; i < rowEnd; i++) {
				Row row = sheet.getRow(i);
				
				for(int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					System.out.println(cell.getStringCellValue());
				}
				System.out.println("--------------------");
			}
		}catch (Exception e) {
		e.printStackTrace();
	}

}
