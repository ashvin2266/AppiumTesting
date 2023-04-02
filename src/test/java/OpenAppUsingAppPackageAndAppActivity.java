import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class OpenAppUsingAppPackageAndAppActivity extends BaseTest{
	/*
	 * Here we see How can we test in portable or landscape mode
	 * we using DeviceRotation class 
	 * how to open app using app package and app activity here all page activity collection in one package same 
	 * as our framework package and class
	 * for finding app package and app activity use following command from cmd
	 * first open emulator upto what page you want to open then
	 * For Mac/Linux:

       adb shell dumpsys window | grep -E 'mCurrentFocus' 
       For Windows:

       adb shell dumpsys window | find "mCurrentFocus"
	 */
	
	
	
	@Test
	
	public void testOnLandscopeMode() throws InterruptedException {
		//create objective of active class from appium
		Activity activity=new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
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
