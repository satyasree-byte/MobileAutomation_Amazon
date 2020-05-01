package com.App.Amazon.Test;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseDriver {

	public AppiumDriver<MobileElement> driver;
	

	@BeforeTest
	public void MagicStudio() {

		try {

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("no", true);
			capabilities.setCapability("newCommandTimeout", 100000);
			capabilities.setCapability("no-reset", "true");
			capabilities.setCapability("full-reset", "false");
			// device details
			capabilities.setCapability("deviceName", "ZF6224FQ74");
			capabilities.setCapability("UDID", "ZF6224FQ74");
			capabilities.setCapability("platformVersion", "10");
			capabilities.setCapability("platformName", "Android");
			// Application details

			String apkpath = "C:\\Users\\satyasree\\Downloads\\Amazon_shopping.apk";
			File app = new File(apkpath);
			capabilities.setCapability("app", app.getAbsolutePath());

			capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
			capabilities.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");

			URL url = new URL("http://127.0.0.1:4723/wd/hub");

			// driver = new AppiumDriver<MobileElement>(url,capabilities);
			driver = new AndroidDriver<MobileElement>(url, capabilities);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//			// Load the properties File
//			obj = new Properties();
//			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\Resources\\ObjectRepository\\OR.properties");
//			obj.load(objfile);
			
			
		} catch (Exception e) {
			System.out.println("Cause is" + e.getCause());
			System.out.println("Message is" + e.getMessage());
			e.printStackTrace();
		}
//			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		// Thread.sleep(3000);

	}

//		@AfterTest
//		public void tearDown() {
//			driver.quit(); 
//			
//			
//		}

}
