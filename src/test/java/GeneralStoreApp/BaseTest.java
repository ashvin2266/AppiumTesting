package GeneralStoreApp;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		
		service =new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\ashvi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		         service.start();
				
			        				
				//uiautomator driver set up for automation
				UiAutomator2Options options=new UiAutomator2Options();
				options.setDeviceName("PavanEmulator");
				options.setApp("C:\\Users\\ashvi\\eclipse-workspace\\AppiumTesting\\src\\test\\java\\resources\\General-Store.apk");
			    
			     driver= new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
			     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	@AfterClass
	public void tearDown() {
//		driver.quit();
//		service.stop();
	}
	
	/*
	 * Common method for long press gesture
	 */
	public void longPress(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),"duration",2000));
		
		
		
	}
	/*
	 * common method for scrolling page upto end of scrolling
	 * 
	 */
	public void scrollToEndAction() {
		boolean canScrollMore;
		do{ canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));}while(canScrollMore);
		
	}
	/*
	 * common method for swipe action event
	 */
	public void swipeAction(WebElement element,String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
		    "direction", direction,
		    "percent", 0.75
		));
		
		
	}
	/*
	 * Common method for formating amount like remove $sign before price
	 * 
	 */
	public Double getFormattedAmount(String amount) {
		Double price =Double.parseDouble(amount.substring(1));
		return price;
		
		
		
	}
	
	
	
	
}