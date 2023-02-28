package tyss;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo {

	public static void main(String[] args) {
		String depCity="BLR";
		String arrCity="CCU";
		String depDate="28";
		String depMonth="March";
		String depYear="2023";
		String arrDate="30";
		String arrMonth="March";
		String arrYear="2023";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[text()='Round-trip']")).click();
		driver.findElement(By.xpath("//span[text()='From']/following-sibling::p")).click();
		
		driver.findElement(By.xpath("//span[text()='From']/following-sibling::input")).sendKeys(depCity);
		driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li/descendant::span[text()='"+depCity+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='To']/following-sibling::input")).sendKeys(arrCity);
		driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li/descendant::span[text()='"+arrCity+"']")).click();
		
//		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		String monthYear=driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]/div/div")).getText();
		String month=monthYear.split(" ")[0];
		String year=monthYear.split(" ")[1];
		System.out.println(monthYear);
		
		while(true)
		{
			monthYear=driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]/div/div")).getText();
			month=monthYear.split(" ")[0];
			year=monthYear.split(" ")[1];
			if(month.equals(depMonth))
			{
				driver.findElement(By.xpath("(//p[@class='fsw__date' and text()='"+depDate+"'])[1]")).click();
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		

		while(true)
		{
			monthYear=driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]/div/div")).getText();
			month=monthYear.split(" ")[0];
			year=monthYear.split(" ")[1];
			if(month.equals(arrMonth) && year.equals(arrYear))
			{
				driver.findElement(By.xpath("(//p[@class='fsw__date' and text()='"+arrDate+"'])[1]")).click();
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
			
	}
}
