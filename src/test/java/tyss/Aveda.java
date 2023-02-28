package tyss;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Aveda {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
		
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.aveda.com/");
		
		WebElement makeUpModule = driver.findElement(By.xpath("//div[@id='node-96']//ul/li//a[text()='MAKEUP']"));
		
		Actions a=new Actions(driver);
		////div[@id='node-96']//a[text()='BODY CARE']/following-sibling::div//div[@id='node-138']//a[text()='BODY CARE PRODUCTS']/..//a/following-sibling::div//a
		a.moveToElement(makeUpModule).perform();
		List<WebElement> makeUpList = driver.findElements(By.xpath("//div[@id='node-96']//ul/li//a[text()='MAKEUP']/..//div[@id='node-144']//a[text()='MAKEUP PRODUCTS']/..//a/following-sibling::div//a"));
	
		for (WebElement makeUp : makeUpList) {
			System.out.println(makeUp.getText());
		}
		driver.quit();
	
	}

}
