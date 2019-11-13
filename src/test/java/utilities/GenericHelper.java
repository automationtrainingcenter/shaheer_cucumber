package utilities;

import java.io.File;

public class GenericHelper {
	public static String getFilePath(String folderName, String fileName) {
		String rootFolder = System.getProperty("user.dir");
		return rootFolder + File.separator + folderName + File.separator + fileName;
	}

}
