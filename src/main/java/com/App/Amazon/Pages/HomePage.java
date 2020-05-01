package com.App.Amazon.Pages;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.App.Amazon.Test.BaseDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilities.PropertyReader;

public class HomePage extends PropertyReader {
	public static String NameAndDescSelected = null;
	public static String PriceSelected = null;
	public static String QuantitySelected = null;

	public void SearchAndClickProduct(AppiumDriver<MobileElement> driver ,String product) throws InterruptedException, IOException {
		
		driver.findElement(By.id(PropertyReader.getObject("TextBox_Search"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(PropertyReader.getObject("TextBox_Search"))).sendKeys(product);
		Thread.sleep(3000);
		
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(PointOption.point(159, 325)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.release().perform();
		Thread.sleep(6000);
			
	}

	public void SelectProduct(AppiumDriver<MobileElement> driver) throws IOException, InterruptedException {
		
		Thread.sleep(3000);
		MobileElement ScrollElement = driver.findElement(By.id(PropertyReader.getObject("TextBox_Search")));
		int x = ScrollElement.getLocation().getX();
		int y = ScrollElement.getLocation().getY();
		int a = (x + 600);
		int b = (y + 950);
		
		System.out.println( x +","+ y +","+ a +","+ b);
		
		TouchAction touchAction = new TouchAction(driver);
		// touchAction.tap(PointOption.point(x + 20, y + 110)).perform();
		touchAction.press(PointOption.point(a, b)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(x, y)).release().perform();
		Thread.sleep(3000);
		List<MobileElement> list1=driver.findElements(By.id(PropertyReader.getObject("List_Products")));
		
		   int siz = list1.size();
		   list1.get(siz-1).click();
		   
//		   if(driver.findElement(By.xpath(PropertyReader.getObject("Element_LanguagePopUpClose"))).isDisplayed()){
//			   
//			   driver.findElement(By.xpath(PropertyReader.getObject("Element_LanguagePopUpClose"))).click();
//		   }
		   
		   NameAndDescSelected = driver.findElement(By.xpath(PropertyReader.getObject("Element_ProductNameDesc_ItemPage"))).getText();
		  
		   PriceSelected =  driver.findElement(By.xpath(PropertyReader.getObject("Element_ProductPrice_ItemPage"))).getText();
		   
//		   MobileElement ScrollElement2 = driver.findElement(By.id(PropertyReader.getObject("Element_ProductPrice_ItemPage")));
//			int q = ScrollElement.getLocation().getX();
//			int w = ScrollElement.getLocation().getY();
//			int e = (x + 600);
//			int r = (y + 950);
//			System.out.println( q +","+ w +","+ e +","+ r);
			
		   touchAction.press(PointOption.point(345, 1310)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			.moveTo(PointOption.point(345,340)).release().perform();
		   Thread.sleep(3000);
		  
		   QuantitySelected = driver.findElement(By.xpath(PropertyReader.getObject("Element_ProductQuantity_ItemPage"))).getAttribute("text");
		  
		  
		
	}
	
//	public void 
}