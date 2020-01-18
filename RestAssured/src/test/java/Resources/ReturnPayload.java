package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReturnPayload {
	
	
	public static String getAddBook() throws IOException{
		
		File file = new File("/Users/sapansharma/Onedirect/RestAssured/src/test/java/TestData/AddBook.json");
		FileInputStream fis = new FileInputStream(file);
		
		
		String bodypath=fis.toString();
		return bodypath;
	}

}
