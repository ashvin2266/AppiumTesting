import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppWifiSetting extends BaseTest{
	/*
	 * Here we see what locator we used for automation 
	 * 1.xpath
	 * syntax for xpath
	 //tagname[@attribute='value'] or //tagname
	 * 2.accessibilityId-when using this locator use AppiumBy.
	 * 3.Id
	 * 4.classname- when you used classname locator better to use AppiumBy.
	 * 5.androidUIAutomator
	 */
	
	
	
	@Test
	
	public void clickPreference() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//how to grab text from mobile app and assert it
		String actualText=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actualText,"WiFi settings");
		//how to handle mobile popup and making list of matching elements on mobile apps
		driver.findElement(By.id("android:id/edit")).sendKeys("Ashvinwifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
	}

}
