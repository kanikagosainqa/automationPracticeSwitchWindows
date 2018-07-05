package Assignment.automationPracticeSwitchWindows;

import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import bsh.org.objectweb.asm.Constants;

public class NewTest extends MainClass{
  WebDriver driver;
  WebDriverWait wait;
  MainClass mainclass ;
  //JavascriptExecutor je = (JavascriptExecutor) driver;
  String currentWindowTitle;
  
  public NewTest() {
	  this.driver = driver;
  }
  
  @BeforeMethod
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","/home/qainfotech/Desktop/chromedriver");
	  driver = new ChromeDriver();
	  driver.get("http://toolsqa.com/automation-practice-switch-windows/");
	  driver.manage().window().maximize();
	  //driver.switchTo().window(driver.getTitle());
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
 
  //tc1 - checking page title
  @Test(enabled=true,  priority=1)
  public void pageTitle() {
	  Assert.assertEquals(driver.getTitle(),"Demo Windows for practicing Selenium Automation");
  }
	    
  //tc2 - on clicking the "Tools QA", it opens a new page
  @Test(enabled=true , priority=2)
  public void onClickingToolsQA() {
	  driver.findElement(By.className(" preload-me")).click();
	  Assert.assertEquals("http://toolsqa.com/", driver.getCurrentUrl());
	  driver.close();
  }

  //tc3 - checking share icons 
  @Test(enabled=false,priority=3)
  public void shareIcons() {
	  driver.findElement(By.xpath("//*[@id=\"page\"]/div[1]/div[1]/div[2]/div/a[1]/svg")).click();
  }

  //tc4 - 
  @Test(priority=4)
  public void newBrowserWindow() {
	  String firstWindowHandle = driver.getWindowHandle();
	  driver.findElement(By.xpath("//*[@id=\"button1\"]")).click();
	  for(String handle:driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
	  }
	  Assert.assertEquals("http://toolsqa.com/" , driver.getCurrentUrl());
	  driver.close();
   }

  //tc5 - 
  @Test(enabled=true , priority=5)
  public void newMessageWindow() throws IOException {
	  String firstWindowHandle=driver.getWindowHandle();
	  driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]/button")).click();
	  for(String handle:driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
	  }
	  Assert.assertEquals("http://toolsqa.com/automation-practice-switch-windows/", driver.getCurrentUrl());
	  driver.close();
  }
  
  //tc6 - 
  @Test(priority=6)
  public void newBrowserTab() {
	  String firstWindowHandle = driver.getWindowHandle();
	  driver.findElement(By.xpath("//*[@id=\"content\"]/p[4]/button")).click();
	  for(String handle:driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
	  }
	  Assert.assertEquals("http://toolsqa.com/", driver.getCurrentUrl());
	  driver.close();
  }
  
  //tc7 - 
  @Test(priority=7)
  public void alertBox() {
	  //String firstWindowHandle = driver.getWindowHandle();
	  driver.findElement(By.xpath("#alert")).click();
//	  Alert alert = driver.switchTo().alert();
	  try{
		   WebDriverWait wait = new WebDriverWait(driver, 10);
		   Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		   alert.accept();
		   System.out.println("Accepted the alert successfully.");
		}
	  catch(Throwable e){
		   System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
		}
  }
}