package stepdefinitions;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import utilities.ExcelHelper;

public class ExcelDatatoDataTable implements TypeRegistryConfigurer{

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		TableEntryTransformer<Excel> transformer = new TableEntryTransformer<Excel>() {

			@Override
			public Excel transform(Map<String, String> entry) throws Throwable {
				ExcelHelper excel = new ExcelHelper();
				List<List<String>> excelData = excel.getExcelSheetData(entry.get("folderName"), entry.get("fileName"), entry.get("sheetName"));
				return new Excel(excelData);
			}
		};
		
		typeRegistry.defineDataTableType(new DataTableType(Excel.class, transformer));
		
	}
	
	

}
