import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeImageDemo extends BaseTest {
	
	
	
	
	@Test
	public void swipeImageDemoTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.id("android:id/text1")).click();
		WebElement firstImageEle=driver.findElement(By.xpath("//(android.widget.ImageView)[1]"));	
		Assert.assertEquals(firstImageEle.getAttribute("focusable"),"true");
		
		//Using swipe events taking code from document folders is same as long press but we need to little change from long press
			/*((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) firstImageEle).getId(),
		    "direction", "left",
		    "percent", 0.75
		));*/
//		Above code  put in common method and called this method here
		swipeAction(firstImageEle,"left");
		
		Thread.sleep(2000);
		 firstImageEle=driver.findElement(By.xpath("//(android.widget.ImageView)[1]"));
		
		Assert.assertEquals(firstImageEle.getAttribute("focusable"),"false");
		
	;
}
}