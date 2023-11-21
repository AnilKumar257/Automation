package com.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.GetData;

public class AddtoCartPage {
	
	WebDriver driver;
	GetData get;
	
	@FindBy(id="add-to-cart-button") // It Locates elements by their unique id attribute.
    WebElement button_AddtoCart; // Represents the “Add to Cart” button on the page.
	@FindBy(xpath="//div[@id='attachDisplayAddBaseAlert']//span") //It uses XPath expressions to locate elements based on their position
    WebElement text_AddedToCart;  // Represents the success message displayed when an item is added to the cart.
	
	public AddtoCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);  //The constructor initializes the WebDriver instance and sets up the page factory
	}
	
	public void addToCart()
	{
		for(String winHandle : driver.getWindowHandles()){  // It switches to the newly opened window
		    driver.switchTo().window(winHandle);
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button_AddtoCart); // It scrolls the “Add to Cart” button into view using JavaScript
		button_AddtoCart.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // It specifies the maximum amount of time the WebDriver should wait for an element to appear before throwing an exception.
	}
	
	public void verifyItemAdded(){
		if(text_AddedToCart.isDisplayed()){
			System.out.println("Item successfully added to cart!!!!");
		}
	}
	
}
