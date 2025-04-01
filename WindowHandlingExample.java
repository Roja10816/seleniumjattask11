package com.selenium.jattask11;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;

	import java.util.ArrayList;

	public class WindowHandlingExample {
	    public static void main(String[] args) {
	        // Set the path to the chromedriver executable
	        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with your chromedriver path

	        // Create ChromeOptions
	        ChromeOptions options = new ChromeOptions();

	        // Initialize the WebDriver for Chrome
	        WebDriver driver = new ChromeDriver(options);

	        try {
	            // Step 1: Open a new instance of Chrome browser
	            driver.get("https://the-internet.herokuapp.com/windows");

	            // Step 2: Navigate to the URL "https://the-internet.herokuapp.com/windows"
	            System.out.println("Opened URL: " + driver.getCurrentUrl());

	            // Step 3: Click the "Click Here" button to open a new window
	            WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
	            clickHereButton.click();
	            
	            // Step 4: Switch to the newly opened window
	            // Wait for the new window to open and get window handles
	            ArrayList<String> windowHandles = new ArrayList(driver.getWindowHandles());
	            
	            // Switch to the new window (the second window in the list)
	            driver.switchTo().window(windowHandles.get(1));

	            // Step 5: Verify that the text "New Window" is present on the page
	            WebElement newWindowText = driver.findElement(By.tagName("h3"));
	            if (newWindowText.getText().equals("New Window")) {
	                System.out.println("Text 'New Window' is present on the new window.");
	            } else {
	                System.out.println("Text 'New Window' is NOT present on the new window.");
	            }

	            // Step 6: Close the new window
	            driver.close();
	            System.out.println("Closed the new window.");

	            // Step 7: Verify that the original window is active
	            // Switch back to the original window
	            driver.switchTo().window(windowHandles.get(0));

	            // Ensure we are back on the original window
	            if (driver.getTitle().equals("The Internet")) {
	                System.out.println("Verified that the original window is active.");
	            } else {
	                System.out.println("Failed to return to the original window.");
	            }

	            // Step 8: Close the browser instance
	            //driver.quit();
	            System.out.println("Closed the browser.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



