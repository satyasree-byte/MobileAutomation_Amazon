package com.App.Amazon.Test;

import java.io.IOException;
import org.testng.annotations.Test;

import com.App.Amazon.Pages.CheckoutPage;
import com.App.Amazon.Pages.HomePage;
import com.App.Amazon.Pages.LoginPage;

import DataReader.ReadData;


public class TestSuite extends BaseDriver {
	HomePage Home =  new HomePage();
	LoginPage Login = new LoginPage();
	CheckoutPage Checkout = new CheckoutPage();
	Validations Validate = new Validations();
	
	
	@Test(dataProvider = "AmazonData" , dataProviderClass = ReadData.class)
	public void SearchFunctionality(String Phone, String Password,String Product) throws InterruptedException, IOException {
		
		//Validating if the launch is successful and page is loaded
		Validate.VerifyLaunchSucessful(driver);
		
		//Login process
		Login.clickOnSignin(driver);
		Login.EnterEmailOrPhone(driver,Phone);
		Login.clickOnContinue(driver);
		Login.EnterPassword(driver,Password);
		Login.clickOnLogin(driver);
		
		//Validating if the login is sucessful and user landed on home page
		Validate.VerifyLoginSucessful(driver);
		
		//Selecting the required product and Purchasing it.
		Home.SearchAndClickProduct(driver ,Product);
		Home.SelectProduct(driver);
		Checkout.clickOnAddToCart(driver);
		Checkout.clickOnCartButton(driver);
		
		Validate.VerifyCartPageIsNavigated(driver);
		//Validating product details like Name , Price and Description
		Validate.VerifyProductDetails(driver);
			
		
	}

}
