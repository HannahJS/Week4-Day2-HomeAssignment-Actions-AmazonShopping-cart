Home Assignment : Automation using Actions Class in Selenium
Learning Objective:
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
Reference Links:
Actions Class in Java - Actions Doc
Expected Outcome:
Upon completion, you should be able to:
- Automate a series of interactions on the Amazon website using Actions class in Selenium WebDriver and 
perform specific validations
