package tyss;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTab {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		String baseW = driver.getWindowHandle();
		WebElement newTab=driver.findElement(By.xpath("//a[text()='Forgotten password?']"));
		Actions a=new Actions(driver);
		
		a.contextClick(newTab).perform();
		
		Robot r=new Robot();
		
		r.keyPress(KeyEvent.VK_T);
		
		Set<String> openW = driver.getWindowHandles();
		
		for (String w : openW) {
			if(!w.equals(baseW))
			{
				driver.switchTo().window(w);
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='identify_email']")).sendKeys("hello");
		
	}

}
