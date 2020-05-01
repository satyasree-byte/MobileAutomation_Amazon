package com.App.Amazon.Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.App.Amazon.Test.BaseDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.PropertyReader;
	
//All the required elements for the login page 
// Fetching elements from the OR - properties file

public class LoginPage extends PropertyReader{


		public void clickOnSignin(AppiumDriver<MobileElement> driver) throws InterruptedException {
			Thread.sleep(5000);
			driver.findElement(By.id("sign_in_button")).click();
		}

		public void EnterEmailOrPhone(AppiumDriver<MobileElement> driver , String phone) throws IOException, InterruptedException {
			Thread.sleep(5000);
			driver.findElement(By.xpath(PropertyReader.getObject("TextBox_Email"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(PropertyReader.getObject("TextBox_Email"))).setValue(phone);
		}

		public void EnterPassword(AppiumDriver<MobileElement> driver ,String password) throws IOException {
			driver.findElement(By.xpath(PropertyReader.getObject("TextBox_Password"))).sendKeys(password);
			
		}

		public void clickOnContinue(AppiumDriver<MobileElement> driver) throws IOException, InterruptedException {
			driver.findElement(By.xpath(PropertyReader.getObject("Button_Continue"))).click();
			Thread.sleep(5000);
			
		}

		public void clickOnLogin(AppiumDriver<MobileElement> driver) throws IOException {
			driver.findElement(By.xpath(PropertyReader.getObject("Button_Login"))).click();
			
		}
		
		
	}


