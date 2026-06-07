package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
private static Properties prop = new Properties();
static
{
	try {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		prop.load(fis);
		fis.close();
	}
		catch(IOException e)
	{
		e.printStackTrace();
		throw new RuntimeException("config.properties not found!");
	}
}
public static String get(String key) {
	String value = prop.getProperty(key);
	if (value == null) {
		throw new RuntimeException("Missing key in config.properties: " + key);
	}
	return value.trim();
}
}
