package seleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SearchResult 
{

	
	public static void main(String []args) throws InterruptedException 
	{
		
		
		
		
		//Create object of ChromeOptions Class for fix Error of Websocket,CDP Error
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); // remove unsecured warning
		options.addArguments("--disable-notifications");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		
		options.merge(dc);
		
		
		WebDriver driver = new ChromeDriver(options);
		//Get URL.
		driver.get("https://www.google.com/");
		//implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//maximize Browser
		driver.manage().window().maximize();
		//Get title of Page
		String title = driver.getTitle();
		System.out.println("Title of the Page: "+title);
		
		//find WebElement by ID Locator
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		searchBox.sendKeys("i7 laptops");
		
		//using for loop to drop down the AutoSuggest list 
		for(int i=0;i<=10;i++)
		{
			searchBox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(500);
		}

		//find WebElements 
		List<WebElement> searchList = driver.findElements(By.xpath("//div[@class='wM6W7d']"));
		
		//using "for each" for retrieve the AutoSuggest List. print result. 
		for(WebElement op:searchList)
		{
			String TextOfList = op.getText();
			System.out.println(TextOfList);
			
		}
		//Get Size of the List
		System.out.println("size of AutoSearch List: "+searchList.size());
		
		Thread.sleep(1000);
		
		//close browser
		driver.quit();
		
		
		
		
		
		
		
		
	}
	
}
