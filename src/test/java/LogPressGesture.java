import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LogPressGesture extends BaseTest{
	/*
	 * Here we see intro of  mobile Gestures and how its works 
	 * mobile gestures like long press,drag and drops,scrolling,swipes, pinch etc special events
	 * find documents from google search appium github gestures and follows steps 
	 */
	
	
	
	
	@Test 
	public void longPressGestureTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement element=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		// Java this is for long press
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) element).getId(),"duration",2000));
/*
 *  if you want common method from base test class call folowing method and comment above code
		longPress(element);
		*/
	Thread.sleep(2000);
		String actualMenu=driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(actualMenu,"Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		
		
		
		}

}
