import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragAndDropDemo extends BaseTest {
	
	
	
	
	@Test
	public void dragAndDropDemoTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
		WebElement sourceEle=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		/* Java
		How can we coordinate go to inspector and 
		there is three tab above image of emunator (select element,select swipe by coordinate,tab by coordinate)
		then use it as X and Y cordinate value*/
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) sourceEle).getId(),
		    "endX", 630,
		    "endY", 580
		));
		
//		how to assert this action by grab text after action is dropped!
		String resultText=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(resultText, "Dropped!")
		
		
	;
}
}