package util;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This method will read config.properties 
 * @return
 * */
public class ConfigReader {
	private Properties prop;
	
	public Properties init_prop() {
		prop=new Properties();
		try {
			FileInputStream file=new FileInputStream("E:\\Testing\\SeleniumAutomation\\NewCucumber\\CucumberPOM\\src\\test\\resources\\config\\config.properties");
			try {
				prop.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return prop;
	}

}
