package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	public String readDataFromProperty(String key) throws IOException {
		FileInputStream fileInputStream = new FileInputStream("./CommonD.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		 return properties.getProperty(key);
	}

}
