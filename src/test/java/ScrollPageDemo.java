import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollPageDemo extends BaseTest {
	
	
	
	
	@Test
	public void scrollPageDemoTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	/*	// if you knows where to scroll i.e.scrolling upto which element or text  use following method */
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		Thread.sleep(2000);
		
		//if you dont know where to scroll use following method
		// Java
		// Java
		/*boolean canScrollMore;
		do{ canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));}while(canScrollMore);*/
		scrollToEndAction();
		
		Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("WebView")).isDisplayed());


}
}