package tyss;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//div[text()='From']/following-sibling::div/input")).sendKeys("BLR");
		driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/input")).sendKeys("DE");
		driver.findElement(By.xpath("//div[text()='DEL']")).click();
		driver.findElement(By.xpath("//div[@data-testid='app-loader']"));
		List<WebElement> monthYearList = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
		
		int depCount=0;
		int retCount=0;
		for (int i = 0; i < monthYearList.size(); i++) {
			
			String monthYear = monthYearList.get(i).getText();
			String month=monthYear.split(" ")[0];
			String year=monthYear.split(" ")[1];
			System.out.println(month+"----------"+year);
			if(month.equals("March") && year.equals("2023"))
			{
				depCount=i+1;
			}
			if(month.equals("November") && year.equals("2023"))
			{
				retCount=i+1;
				break;
			}
			
		}
		if(depCount>=1)
		{
			driver.findElement(By.xpath("(//div[text()='25'])["+depCount+"]")).click();
		}
		
		if(retCount>=1)
		{
			driver.findElement(By.xpath("(//div[text()='25'])["+retCount+"]")).click();
		}
		

		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		
		
		
		
		
		
		
		
		
		
//		driver.quit();
	}

}
