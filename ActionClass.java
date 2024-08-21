package week4.day2.homeAssignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		
/**Learning Objective:
Learn to automate interactions using Selenium WebDriver's Actions class to simulate mouse and keyboard actions.
Expected Time:
Best Case: 50 minutes
Average Case: 1 hour
Assignment Details:
Automate a series of interactions on the Amazon website using Actions class in Selenium WebDriver.
Precondition:
- Initialize ChromeDriver
- Load the URL (https://www.amazon.in/)
- Maximize the browser window
- Add an implicit wait to ensure the webpage elements are fully loaded
Requirements:
1. Load the URL (https://www.amazon.in/)
2. Search for "oneplus 9 pro".
3. Get the price of the first product.
4. Print the number of customer ratings for the first displayed product.
5. Click the first text link of the first image.
6. Take a screenshot of the product displayed.
7. Click the 'Add to Cart' button.
8. Get the cart subtotal and verify if it is correct.
9. Close the browser.
Hints to Solve:
- Use Selenium's Actions class methods such as `moveToElement()`, ‘perform()’ and Selenium methods such as`click()`, 
`sendKeys()`.
- Utilize appropriate locators and techniques to interact with web elements.
- Switch between windows using `getwindowHandles()` and switchTo().window().
		 * 
		 * 
		 */
		
		/***************************************************************************************/
		/********************* Preconditions validation- BEGINS*********************************/
		/***************************************************************************************/
		
		//Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver();
		
		
		//Load the URL (https://www.amazon.in/)
		driver.get("https://www.amazon.in/");
		
		// Maximize the browser window
		//driver.manage().window().maximize();
		
		
		//Add an implicit wait to ensure the webpage elements are fully loaded
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				
	
		
		
		
		/***************************************************************************************/
		/*****************Pre-conditions validated- ENDS ***************************************/
		/***************************************************************************************/
	    
				
				

				/***************************************************************************************/
				/********************* Requirements validation- BEGINS*********************************/
				/***************************************************************************************/
				
				
				
				//Search for "oneplus 9 pro"
				
				WebElement searchText= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
				searchText.sendKeys("oneplus 9 pro");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
			
				Thread.sleep(3000);
			
				
				
				
				//Get the price of the first product
				WebElement firstSearch = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
				String firstPrice=firstSearch.getText();
				System.out.println(firstPrice);
				//System.out.println(firstSearch.getText());
				System.out.println("First Product Price is  now displayed from the search result");
				Thread.sleep(3000);
				
				
				
				
				//Print the number of customer ratings for the first displayed product.
				/***Unable to fetch ratings??????***/
				
				
				WebElement firstSearchRating = driver.findElement(By.xpath("(//span[@class='a-icon-alt'])[1]"));
				String rating = firstSearchRating.getText();
				System.out.println(rating);
				Thread.sleep(3000);
				System.out.println("First Product rating is  now displayed from the search result");
				
				
				
				//Click the first text link of the first image.
				WebElement firstProductlink= driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base a-text-normal')])[1]"));
				firstProductlink.click();
				Thread.sleep(5000);
				
				
				
				
				//Take a screenshot of the product displayed.
				
				/****Make the window display the current screen to take snap 
				 * 
				 * --pass driver focus to child window***/
				
				
				Set<String> pw = driver.getWindowHandles();
				System.out.println(pw);
				String title = driver.getTitle();
				System.out.println("Parent window :"+title);
				/***set in to list -list -get(1)****/
				List<String> window=new ArrayList<String>(pw);
				/***switch to child window****/
				String cw = driver.switchTo().window(window.get(1)).getTitle();
				System.out.println("Child window :"+cw); 
			
			  
				
				//Step 1: take snap
				
				File scr=driver.getScreenshotAs(OutputType.FILE);
				
				// Step 2: create path to store snap
				
				File dest=new File("./SnapShots/image.png");
				/*** everytime when you run this code the image gets replaced
				 * how to store every runs result??
				 */
				
				//Step3: connect source with Des
				FileUtils.copyFile(scr, dest);
				Thread.sleep(3000);
				
				
				
				
				
				 //Click the 'Add to Cart' button.
				
				/***control still in child window***/
				driver.findElement(By.xpath("//input[contains(@id,'add-to-cart-button')]")).click();
				Thread.sleep(3000);
				
				
				
				
				//Get the cart subtotal and verify if it is correct
				/*** how to compare price is equal?? one has decimal point and the other does not????
				 */
				WebElement subtotal = driver.findElement(By.xpath("//span[contains(@id,'attach-accessory-cart-subtotal')]"));
				
				String compareSubtotal= subtotal.getText();
				System.out.println(compareSubtotal);
				System.out.println("subtotal printed");
				Thread.sleep(3000);
				
				if(compareSubtotal==firstPrice)
				{
					
					System.out.println("Price matches");
					
				}
				
				else
				{
					System.out.println("Price mismatch!!");
					
					
				}
				
				
				//Close the browser
				
				
				driver.close();
				driver.switchTo().window(window.get(0)).close();
				
				driver.quit();
				
				
				/***************************************************************************************/
				/********************* Requirements validation- ENDS*********************************/
				/***************************************************************************************/	
				
				
	}

}



