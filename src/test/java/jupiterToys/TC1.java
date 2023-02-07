package jupiterToys;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC1 {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public void tc1Test()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		driver.findElement(By.linkText("Contact")).click();
		driver.findElement(By.linkText("Submit")).click();
		
		
		WebElement fNameErr = driver.findElement(By.id("forename-err"));
		WebElement emailErr = driver.findElement(By.id("email-err"));
		WebElement msgErr = driver.findElement(By.id("message-err"));
		boolean errMsgDisp=true;
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try {
		wait.until(ExpectedConditions.visibilityOf(fNameErr));
		wait.until(ExpectedConditions.visibilityOf(emailErr));
		wait.until(ExpectedConditions.visibilityOf(msgErr));
		}
		catch (Exception e) {
			errMsgDisp=false;
			
		}
		Assert.assertTrue(errMsgDisp);
		
		driver.findElement(By.id("forename")).sendKeys("mist");
		driver.findElement(By.id("email")).sendKeys("mist@gmail.com");
		driver.findElement(By.id("message")).sendKeys("hello");
		boolean errMsgNotSisp=true;
		try {
			wait.until(ExpectedConditions.invisibilityOf(fNameErr));
			wait.until(ExpectedConditions.invisibilityOf(emailErr));
			wait.until(ExpectedConditions.invisibilityOf(msgErr));
			}
			catch (Exception e) {
				errMsgNotSisp=false;
				
			}
		Assert.assertTrue(errMsgNotSisp);
		driver.quit();
	}
	
//	@DataProvider
	public Object[][] getData()
	{
		Object[][] ob=new Object[5][5];
		ob[0][0]="mist";
		ob[0][1]="brinjal";
		ob[0][2]="mist@gmail.com";
		ob[0][3]="123446";
		ob[0][4]="hello";
		
		ob[1][0]="mist1";
		ob[1][1]="bri1";
		ob[1][2]="mist1@gmail.com";
		ob[1][3]="91234";
		ob[1][4]="bye";
		
		ob[2][0]="mist2";
		ob[2][1]="bri2";
		ob[2][2]="mist2@gmail.com";
		ob[2][3]="912312";
		ob[2][4]="hi";
		
		ob[3][0]="mist3";
		ob[3][1]="bru3";
		ob[3][2]="mist3@gmail.com";
		ob[3][3]="9987152";
		ob[3][4]="one";
		
		ob[4][0]="mist4";
		ob[4][1]="bru4";
		ob[4][2]="mist4@gmail.com";
		ob[4][3]="78600";
		ob[4][4]="hey2";
		
		return ob;	
	}
	
	@BeforeClass
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://jupiter.cloud.planittesting.com/#/");
	}

//	@Test(dataProvider = "getData")
	public void tc2Test(String name,String surName,String emailId,String phNo,String Msg)
	{
		try {
			driver.findElement(By.xpath("//a[text()='Contact']")).click();
		}
		catch (Exception e) {
		}
		
		driver.findElement(By.id("forename")).sendKeys(name);
		driver.findElement(By.id("surname")).sendKeys(surName);
		driver.findElement(By.id("email")).sendKeys(emailId);
		driver.findElement(By.id("telephone")).sendKeys(phNo);
		driver.findElement(By.id("message")).sendKeys(Msg);
		driver.findElement(By.linkText("Submit")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='popup modal hide ng-scope in']")));
		WebElement feedBackIcon = driver.findElement(By.xpath("//div[@class='popup modal hide ng-scope in']"));
		wait.until(ExpectedConditions.visibilityOf(feedBackIcon));
		boolean succesMsg=false;
		
		String sucMsg=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		if(sucMsg.contains("Thanks "+name))
		{
			succesMsg=true;
		}
		Assert.assertTrue(succesMsg);
		
		driver.findElement(By.linkText("« Back")).click();	
	}
	
	
	
	
	
	public String stringToElement(String xpath,String value)
	{
		String xp = String.format(xpath, value);
		return xp;
		
	}
	
	
	@Test
	public void tc3Test()
	{
		//2 stuffed frog
		//5 fluffy bunny
		//3valentine bear
		
		//item name
		String item1="Stuffed Frog";
		String item2="Fluffy Bunny";
		String item3="Valentine Bear";
		
		//item quantity
		int expfrogQty=2;
		int expBunnyQty=5;
		int expBearQty=3;
		
		//click on shop module
		driver.findElement(By.linkText("Shop")).click();
		
		//expected single item price
		float expstuffedFrogPrice =Float.parseFloat(driver.findElement(By.xpath("//h4[text()='"+item1+"']/following-sibling::p/span")).getText().replaceAll("[$]",""));
		float expfluffyBunnyPrice =Float.parseFloat(driver.findElement(By.xpath("//h4[text()='"+item2+"']/following-sibling::p/span")).getText().replaceAll("[$]",""));
		float expvalentineBearPrice =Float.parseFloat(driver.findElement(By.xpath("//h4[text()='"+item3+"']/following-sibling::p/span")).getText().replaceAll("[$]",""));
		
		
		//expected subtotal
		float expstuffedFrogPriceSubT=expstuffedFrogPrice*expfrogQty;
		float expfluffyBunnyPriceSubT=Float.parseFloat(String.format("%.2f",expfluffyBunnyPrice*expBunnyQty));
		float expvalentineBearPriceSubT=expvalentineBearPrice*expBearQty;
		
		
		//click on the items
		for (int i = 1; i <= expfrogQty; i++) {	
			driver.findElement(By.xpath("//h4[text()='"+item1+"']/following-sibling::p/a")).click();
		}
		for (int i = 1; i <= expBunnyQty; i++) {	
			driver.findElement(By.xpath("//h4[text()='"+item2+"']/following-sibling::p/a")).click();
		}
		for (int i = 1; i <= expBearQty; i++) {	
			driver.findElement(By.xpath("//h4[text()='"+item3+"']/following-sibling::p/a")).click();
		}
		
		//expected grand total
		float exGrandTotal=expstuffedFrogPriceSubT+expfluffyBunnyPriceSubT+expvalentineBearPriceSubT;
		
		System.out.println(expstuffedFrogPriceSubT);
		System.out.println(expfluffyBunnyPriceSubT);
		System.out.println(expvalentineBearPriceSubT);
		
		//click on cart icon
		driver.findElement(By.partialLinkText("Cart")).click();

		
		float acfrogPr = Float.parseFloat(driver.findElement(By.xpath("//table//tbody//tr//td[normalize-space(text())='"+item1+"']/following-sibling::td[1]")).getText().replaceAll("[$]",""));
		int acfrogQty = Integer.parseInt(driver.findElement(By.xpath("//table//tbody//tr//td[normalize-space(text())='"+item1+"']/following-sibling::td[2]/input")).getAttribute("value"));
		float acfrogSubT =Float.parseFloat(driver.findElement(By.xpath("//table//tbody//tr//td[normalize-space(text())='"+item1+"']/following-sibling::td[3]")).getText().replaceAll("[$]",""));
		
		
		float acbunnyPr = Float.parseFloat(driver.findElement(By.xpath("//table//tbody//tr//td[normalize-space(text())='"+item2+"']/following-sibling::td[1]")).getText().replaceAll("[$]",""));
		int acbunnyQty = Integer.parseInt(driver.findElement(By.xpath("//table//tbody//tr//td[normalize-space(text())='"+item2+"']/following-sibling::td[2]/input")).getAttribute("value"));
		float acbunnySubT =Float.parseFloat(driver.findElement(By.xpath("//table//tbody//tr//td[normalize-space(text())='"+item2+"']/following-sibling::td[3]")).getText().replaceAll("[$]",""));
		
		
		float acbearPr = Float.parseFloat(driver.findElement(By.xpath("//table//tbody//tr//td[normalize-space(text())='"+item3+"']/following-sibling::td[1]")).getText().replaceAll("[$]",""));
		int acbearQty = Integer.parseInt(driver.findElement(By.xpath("//table//tbody//tr//td[normalize-space(text())='"+item3+"']/following-sibling::td[2]/input")).getAttribute("value"));
		float acbearSubT =Float.parseFloat(driver.findElement(By.xpath("//table//tbody//tr//td[normalize-space(text())='"+item3+"']/following-sibling::td[3]")).getText().replaceAll("[$]",""));
		
		//actual grand total
		float acGrandTotal = Float.parseFloat(driver.findElement(By.xpath("//table//tfoot//tr/td/strong")).getText().split(" ")[1].trim());
		
		//comparison of the single item price
		Assert.assertEquals(expstuffedFrogPriceSubT, acfrogSubT);
		Assert.assertEquals(expfluffyBunnyPriceSubT, acbunnySubT);
		Assert.assertEquals(expvalentineBearPriceSubT, acbearSubT);
		
		//comparison of subtotal
		Assert.assertEquals(expstuffedFrogPrice, acfrogPr);
		Assert.assertEquals(expfluffyBunnyPrice, acbunnyPr);
		Assert.assertEquals(expvalentineBearPrice, acbearPr);
		
		//comparison of grand total
		Assert.assertEquals(exGrandTotal,acGrandTotal);
	}
	
	@AfterClass
	public void quitBrowser()
	{
		driver.quit();
	}
}
