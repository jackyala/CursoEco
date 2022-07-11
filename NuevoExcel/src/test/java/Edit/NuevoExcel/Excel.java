package Edit.NuevoExcel;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static void main(String[] arg) {
		
		
		
	}
	
	public static void crearExcel() {
		
		Workbook book = new XSSFWorkbook();
		XSSFSheet Sheet = book.createSheet("hoja java");
		
	}

}
