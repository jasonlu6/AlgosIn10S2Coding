package selenium;

// import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

/* Algos in 10 
 * Season 2 Episode 10 
 * Selenium Java Driver for NP-Complete Apriori. 
 * 
 *  Simple web crawler application to get data from Expedia.com,
 *  in order to web crawl for some nodes. Analogous Python version 
 *  on a separate notebook. 
 *  
 *  Author: Jason Lu (jasonlu968@gmail.com) 
 *  Date: 11/21/2021 - 11/25/2021 
 *  All rights reserved. 
 *  */

/* Note:
 * Selenium with Java bonus, for ‘processing’ some clustering nodes, 
 * and Python as well, for some cool webdriver applications / system programming 
 * on a localhost website (my personal website, well part of it). That will be 
 * separate from the notebook. 
 *  */

public class SeleniumBrowser {
	
	// Helper class to print out the driver properties. 
	public void printProperties() {
		System.out.println("Properties for the Selenium Web Crawler: \n");
	}

	// Source: https://www.browserstack.com/guide/selenium-with-java-for-automated-test
	
	// Main method. 
	public static void main(String[] args) {

	//setting the driver executable
	System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
	// The other two classes will show the actual crawler results. 
	// The full results will be shown in the SpiderCrawler and SpiderLeg classes. 
	}
}
