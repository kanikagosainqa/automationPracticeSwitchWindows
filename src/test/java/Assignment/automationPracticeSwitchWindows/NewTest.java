package Assignment.automationPracticeSwitchWindows;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

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
	  driver.switchTo().window(driver.getTitle());
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
 
  //tc1 - checking page title
  @Test(enabled=true,  priority=1)
  public void pageTitle() {
	  Assert.assertEquals(driver.getTitle(),"A new title is here");
  }
	    
  //tc2 - on clicking the "Tools QA", it opens a new page
  @Test(enabled=true , priority=2)
  public void onClickingToolsQA() {
	  driver.findElement(By.className(" preload-me")).click();
	  Assert.assertEquals("http://toolsqa.com/", driver.getCurrentUrl());
  }

  //tc3 - checking share icons 
  @Test(enabled=false,priority=3)
  public void shareIcons() {
	  driver.findElement(By.xpath("//*[@id=\"page\"]/div[1]/div[1]/div[2]/div/a[1]/svg")).click();
  }

  //tc4 - 
  @Test(priority=4)
  public void newBrowserWindowButton() throws IOException {
	  currentWindowTitle  = driver.getTitle();
	  driver.findElement(By.cssSelector("#button1")).click();
	  String newWindowTitle = driver.getTitle(); 
	  mainclass.switchWindow(newWindowTitle);
	  //driver.switchTo().window("currentWindowTitle");
	  Assert.assertEquals("http://toolsqa.com/" , driver.getCurrentUrl());
  }
  
}