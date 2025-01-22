package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	
	protected Properties prop;
	protected WebDriver driver;
	
	public void setup() throws IOException
	{
		prop =new Properties();	
		
		//load the configuration  file
		FileInputStream file=new FileInputStream("src/main/java/config.properties"); 
		prop.load(file);
	
		
		String browser= prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
	int implicitWait = Integer.parseInt(prop.getProperty("implicitwait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	}
}
