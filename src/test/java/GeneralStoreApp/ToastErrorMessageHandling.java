package GeneralStoreApp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ToastErrorMessageHandling extends BaseTest{
	/*
	 * You can not capture element for Toast Message using appium inspector
	 * who develop toast message have a same tagname is   //android.widget.
	 * Toast so can smartly handle by creating xpath ////android.widget.Toast
	 * if you have more than one toast message use xpath like //"android.widget.Toast[1]" or [2] 
	 * how you can grab text ? all toast message have a attribute "name" always so use getAttribute method 
	 */
	
	
	
	@Test
	
	public void verifyToastMessageTest() throws InterruptedException{
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ashvin");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		/*
	 * Toast so can smartly handle by creating xpath ////android.widget.Toast
	 * if you have more than one toast message use xpath like //"android.widget.Toast[1]" or [2] 
	 * how you can grab text ? all toast message have a attribute name always so use getAttribute method 
		 */
		String actualToastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(actualToastMessage,"Please enter your name");
	}

}
