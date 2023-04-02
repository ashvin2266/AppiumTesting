import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellanousGestures extends BaseTest{
	/*
	 * Here we see How can we test in portable or landscape mode
	 * we using DeviceRotation class 
	 */
	
	
	
	@Test
	
	public void testOnLandscopeMode() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation devicerotate=new DeviceRotation(0,0,90);
		driver.rotate(devicerotate);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//how to grab text from mobile app and assert it
		String actualText=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actualText,"WiFi settings");
	
		//How to copy and paste gesture in appium 
		//here we using get and set method of clipBoardText method
		//for copy text
		driver.setClipboardText("AshvinWiFiCopied");
		//fro paste of copied text from clipboard use get method
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		//How to use Key event like Enter,Back,Press key from key board
		//its simple using keyEvent class object 
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
	}

}
