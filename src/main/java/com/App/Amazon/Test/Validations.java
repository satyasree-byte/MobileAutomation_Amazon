package com.App.Amazon.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.App.Amazon.Pages.HomePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import utilities.PropertyReader;

public class Validations extends PropertyReader {
	
	public void VerifyProductDetails(AppiumDriver<MobileElement> driver) throws IOException {
		
		
		
		List<MobileElement> listNameAndDesc = driver.findElements(By.xpath(PropertyReader.getObject("Element_ProductNameDesc_CheckoutPage")));
				
		 int siz1 = listNameAndDesc.size();
		 String NameAndDescAtCheckout =  listNameAndDesc.get(siz1-2).getText();
		
		
		List<MobileElement> listPriceAtCheckout = driver.findElements(By.xpath(PropertyReader.getObject(("Element_ProductPrice_CheckoutPage"))));
		
		 int siz2 = listPriceAtCheckout.size();
		 String PriceAtCheckout =  listPriceAtCheckout.get(siz2-3).getAttribute("text");
		
		 
		List<MobileElement> listQuantityAtCheckout = driver.findElements(By.xpath(PropertyReader.getObject("Element_ProductQuantity_CheckoutPage")));
		
		 int siz3 = listQuantityAtCheckout.size();
		 String QuantityAtCheckout =  listQuantityAtCheckout.get(siz3-1).getAttribute("text");
		 
		 //Validation of Name and Description as the name and decsription is at same element
		 
		 if(HomePage.NameAndDescSelected.trim().equalsIgnoreCase(NameAndDescAtCheckout.trim())
			 				&&(HomePage.PriceSelected.split(" ")[1].trim().equalsIgnoreCase
			 						(PriceAtCheckout.split("")[3]+PriceAtCheckout.split("")[4]+PriceAtCheckout.split("")[5]))
			 							&&(HomePage.QuantitySelected.equalsIgnoreCase(QuantityAtCheckout)))
		 {
			 
			 System.out.println("Name and Description Validated successfully"+ NameAndDescAtCheckout);
			 System.out.println("Price is validated successfully"+ PriceAtCheckout);
			 System.out.println("Quantity is validated successfully"+ QuantityAtCheckout);
			 
			 System.out.println("TEST CASE PASSED");
		 }
		 
				
	}
	public void VerifyLoginSucessful(AppiumDriver<MobileElement> driver) throws IOException, InterruptedException {
		Thread.sleep(10000);
		
		if(driver.findElement(By.id(PropertyReader.getObject("Button_HamburgerMenu"))).isDisplayed())
		{
			System.out.println("Login Verified successfully");
		}
	}

	public void VerifyLaunchSucessful(AppiumDriver<MobileElement> driver) throws IOException, InterruptedException {
		Thread.sleep(10000);
		 if(driver.findElement(By.id(PropertyReader.getObject("Button_SignIn"))).isDisplayed())
		{
			System.out.println("App Launch Verified successfully");
		}
		
	}

	public void VerifyCartPageIsNavigated(AppiumDriver<MobileElement> driver) throws IOException {
		if(driver.findElement(By.xpath(PropertyReader.getObject("Element_ProceedToBuy_CheckOutPage"))).isDisplayed())
		{
			System.out.println("Navigation to cart Verified successfully");
		}
		
	}

}
