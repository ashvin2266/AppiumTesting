import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasic {
	@Test
	public void appiumTest() throws MalformedURLException {
		
	// starting appium server	
	AppiumDriverLocalService service=new AppiumServiceBuilder()
	.withAppiumJS(new File("C:\\Users\\ashvi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
	.withIPAddress("127.0.0.1").usingPort(4723).build();
	service.start();
	
	//uiautomator driver set up for automation
	UiAutomator2Options options=new UiAutomator2Options();
	options.setDeviceName("PavanEmulator");
	options.setApp("C:\\Users\\ashvi\\eclipse-workspace\\AppiumTesting\\src\\test\\java\\resources\\ApiDemos-debug.apk");
    
    AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
    driver.quit();
//    appium server stop
    service.stop();
    }

	

}
