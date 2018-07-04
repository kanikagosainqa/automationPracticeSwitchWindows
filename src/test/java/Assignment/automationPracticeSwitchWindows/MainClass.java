package Assignment.automationPracticeSwitchWindows;

import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.WebDriver;

public class MainClass {
	WebDriver driver;
	
	public boolean switchWindow(String title) throws IOException {

		String currentWindow = driver.getWindowHandle();
		Set<String> availableWindows = driver.getWindowHandles();
		if(!availableWindows.isEmpty()) {
			for(String windowId:availableWindows){
				if(driver.switchTo().window(windowId).getTitle().equals(title)) {
					return true;
					}
				else {
					driver.switchTo().window(currentWindow);
				}
			}
		}
				return false;
	}
}