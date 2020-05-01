package com.App.Amazon.Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;

import com.App.Amazon.Test.BaseDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilities.PropertyReader;

public class CheckoutPage extends PropertyReader {

	
	public void clickOnAddToCart(AppiumDriver<MobileElement> driver) throws IOException, InterruptedException {
		
//		Thread.sleep(3000);
//		MobileElement ScrollElement = driver.findElement(By.xpath(PropertyReader.getObject("Button_AddToCart")));
//		int x = ScrollElement.getLocation().getX();
//		int y = ScrollElement.getLocation().getY();
//		int a = (x + 200);
//		int b = (y + 400);
//		
//		Thread.sleep(3000);
//		TouchAction touchAction = new TouchAction(driver);
//		// touchAction.tap(PointOption.point(x + 20, y + 110)).perform();
//		touchAction.press(PointOption.point(a, b)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//				.moveTo(PointOption.point(x, y)).release().perform();
		
		driver.findElement(By.xpath(PropertyReader.getObject("Button_AddToCart"))).click();	
		 
	}
	
	public void clickOnCartButton(AppiumDriver<MobileElement> driver) throws IOException {
		driver.findElement(By.xpath(PropertyReader.getObject("Button_GoToCart"))).click();	
		
	}

}
