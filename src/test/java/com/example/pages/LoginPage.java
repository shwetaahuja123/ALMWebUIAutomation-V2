package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
    //Locator
	private By email = By.xpath("//input[@id=\"email\"]");
	
	public void enterEmail(String emailIdInput) {
		
		driver.findElement(email).sendKeys(emailIdInput);
	}
	
	
	By submitButton = By.xpath("//input[@type=\"submit\"]");
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
		
	}
	
	By password = By.xpath("//input[@type=\"password\"]");
	
	public void enterPassword(String passwordInput)
	{
		driver.findElement(password).sendKeys(passwordInput);
	}
	
	By continueButton = By.xpath("//span[text()='Continue']");
	
	public void clickContinueButton()
	{
		driver.findElement(continueButton).click();
	}
			

}
