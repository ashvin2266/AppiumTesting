package GeneralStoreApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerchCheckoutTotal extends BaseTest{
	@Test
	public void totalPurchaseProductPriceTest() throws InterruptedException {		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ashvin");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		/*
		 * when you want to click add to cart you have two element on screen so use find elements method 
		 * but here in scenario when you click first add to cart add to cart change to added cart so after first click 
		 * you have only one element instead of two element so same index or code used for second add to cart 
		 * 
		 */
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//or second method also you can use like
//		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
//		this is click on cart button
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	/*	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),
				"text", "Cart"));*/
		Thread.sleep(2000);
		List<WebElement> productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count=productPrices.size();
		double actualTotalProductPrice=0;
		
		for(int i=0;i<count;i++) {
			String amountProduct=productPrices.get(i).getText();
			System.out.println("Product amount price--->"+amountProduct);
			Double price =getFormattedAmount(amountProduct);
			System.out.println("Product amount price in double format---->"+price);
			actualTotalProductPrice=actualTotalProductPrice + price;
			System.out.println("Total amount purchase ---->"+ actualTotalProductPrice);		
		}
		System.out.println("Total amount purchase ---->"+ actualTotalProductPrice);	
		
		String totalPurchaseAmountDisplay=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double displayedFormattedSum =Double.parseDouble(totalPurchaseAmountDisplay.substring(1));
		System.out.println(displayedFormattedSum);
//		Double displayedFormattedSum=getFormattedAmount(totalPurchaseAmountDisplay);
//		System.out.println("Total amount purchase displayed---->"+ displayedFormattedSum);
//		WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait1.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/productPrice")),
//				"text", "$160.97"));
		Assert.assertEquals(actualTotalProductPrice,displayedFormattedSum);
	
		
}}
	
	
	


