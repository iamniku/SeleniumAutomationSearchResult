package seleniumBasics;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Multiselectected_list_feature 
{

	

		public static void main(String[] args) throws InterruptedException
		{
		//Create object of ChromeOptions Class for fix Error of Websocket,CDP Error
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*"); // remove unsecured warning
			options.addArguments("--disable-notifications");
			
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(dc);
			
			WebDriver driver = new ChromeDriver(options);
			
			//get html url
		
			driver.get("https://testpages.herokuapp.com/basic_html_form.html");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			//maximize the window
			driver.manage().window().maximize();
		
		
			//find WebElement
			WebElement Multiselectected_listbox = driver.findElement(By.xpath("//select[@name='multipleselect[]']"));
		
			//create object of Select Class for handling:
			Select s=new Select(Multiselectected_listbox);
			
			s.selectByIndex(0);
			Thread.sleep(1000);
			s.selectByValue("ms2");   //String value
			Thread.sleep(1000);
			s.selectByIndex(2);
			Thread.sleep(1000);
			s.selectByIndex(3);
	

//			different method to get all avilable options in List:
			
//			List<WebElement> getoption = s.getOptions();
//			
//			for(WebElement displayOP:getoption)
//			{
//				System.out.println(displayOP.getText());
//			}
//			
			
			
			List<WebElement> op = s.getAllSelectedOptions();

			System.out.println(op.size());
			
			for(WebElement op1:op)
			{
				System.out.println(op1.getText());
			}
			
			Thread.sleep(1000);
			driver.quit();
			
		}
		
	
	
}
