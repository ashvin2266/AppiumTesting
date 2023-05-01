package GeneralStoreApp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerceAppGeneralStore extends BaseTest {
	
	
	
	
	@Test
	public void fillFormTest() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ashvin");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		
		
		
	}
	
	

}
