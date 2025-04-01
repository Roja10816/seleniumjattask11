package com.selenium.jattask11;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;

	public class NestedFramesExample {
	    public static void main(String[] args) {
	        // Set the path to the chromedriver executable
	        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with your chromedriver path

	        // Create ChromeOptions
	        ChromeOptions options = new ChromeOptions();

	        // Initialize the WebDriver for Chrome
	        WebDriver driver = new ChromeDriver(options);

	        try {
	            // Step 1: Open the URL "http://the-internet.herokuapp.com/nested_frames"
	            driver.get("http://the-internet.herokuapp.com/nested_frames");

	            // Step 2: Use CSS or XPath to find and switch to the top frame
	            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));

	            // Step 3: Verify there are three frames on the page
	            WebElement leftFrame = driver.findElement(By.cssSelector("frame[name='frame-left']"));
	            WebElement middleFrame = driver.findElement(By.cssSelector("frame[name='frame-middle']"));
	            WebElement rightFrame = driver.findElement(By.cssSelector("frame[name='frame-right']"));
	            WebElement bottomFrame = driver.findElement(By.cssSelector("frame[name='frame-bottom']"));

	            if (leftFrame != null && middleFrame != null && rightFrame != null && bottomFrame != null) {
	                System.out.println("There are four frames on the page.");
	            }

	            // Step 4: Switch to the left frame
	            driver.switchTo().frame(leftFrame);

	            // Step 5: Verify that the left frame has the text "LEFT"
	            WebElement leftText = driver.findElement(By.tagName("body"));
	            if (leftText.getText().contains("LEFT")) {
	                System.out.println("Verified that the left frame has text 'LEFT'.");
	            } else {
	                System.out.println("Text 'LEFT' not found in the left frame.");
	            }

	            // Step 6: Switch back to the top frame
	            driver.switchTo().parentFrame();

	            // Step 7: Switch to the middle frame
	            driver.switchTo().frame(middleFrame);

	            // Step 8: Verify that the middle frame has the text "MIDDLE"
	            WebElement middleText = driver.findElement(By.tagName("body"));
	            if (middleText.getText().contains("MIDDLE")) {
	                System.out.println("Verified that the middle frame has text 'MIDDLE'.");
	            } else {
	                System.out.println("Text 'MIDDLE' not found in the middle frame.");
	            }

	            // Step 9: Switch back to the top frame
	            driver.switchTo().parentFrame();

	            // Step 10: Switch to the right frame
	            driver.switchTo().frame(rightFrame);

	            // Step 11: Verify that the right frame has the text "RIGHT"
	            WebElement rightText = driver.findElement(By.tagName("body"));
	            if (rightText.getText().contains("RIGHT")) {
	                System.out.println("Verified that the right frame has text 'RIGHT'.");
	            } else {
	                System.out.println("Text 'RIGHT' not found in the right frame.");
	            }

	            // Step 12: Switch back to the top frame
	            driver.switchTo().parentFrame();

	            // Step 13: Switch to the bottom frame
	            driver.switchTo().frame(bottomFrame);

	            // Step 14: Verify that the bottom frame has the text "BOTTOM"
	            WebElement bottomText = driver.findElement(By.tagName("body"));
	            if (bottomText.getText().contains("BOTTOM")) {
	                System.out.println("Verified that the bottom frame has text 'BOTTOM'.");
	            } else {
	                System.out.println("Text 'BOTTOM' not found in the bottom frame.");
	            }

	            // Step 15: Switch back to the top frame
	            driver.switchTo().parentFrame();

	            // Step 16: Verify the page title is "Frames"
	            if (driver.getTitle().equals("Frames")) {
	                System.out.println("Verified that the page title is 'Frames'.");
	            } else {
	                System.out.println("The page title is not 'Frames'.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser instance
	            //driver.quit();
	        }
	    }
	}



