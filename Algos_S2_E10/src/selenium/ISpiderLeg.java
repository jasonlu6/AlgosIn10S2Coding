package selenium;

import java.util.List;

/* Algos in 10 
 * Season 2 Episode 10 
 * Selenium Java Driver for NP-Complete Apriori. 
 * 
 *  Simple web crawler interface implementation. 
 *  
 *  Author: Jason Lu (jasonlu968@gmail.com) 
 *  Date: 11/21/2021 - 11/25/2021 
 *  All rights reserved. 
 *  */

// http://www.netinstructions.com/how-to-make-a-simple-web-crawler-in-java/

public interface ISpiderLeg {
	
	// Crawler method given next URL. 
	public boolean crawl(String url); 
	// Attempt to find the word on the page. 
	public boolean searchForWord(String word); 
	// Returns a list of all links 
	public List<String> getLinks(); 
	// Returns a list of all queued websites. 
	public List<String> getAllQueued(); 

}
