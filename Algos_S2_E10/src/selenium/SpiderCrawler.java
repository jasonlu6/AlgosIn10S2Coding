package selenium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Source: http://www.netinstructions.com/how-to-make-a-simple-web-crawler-in-java/

/* Algos in 10 
 * Season 2 Episode 10 
 * Selenium Java Crawler for NP-Complete Apriori. 
 * 
 *  Simple web crawler with visitor design pattern and a 'leg' to get optimal 
 *  results for the web crawler. 
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

public class SpiderCrawler {

	// Fields to determine how many pages to search for our web crawler.
	private static final int MAX_PAGES_TO_SEARCH = 20;
	// Hash Set to store the pages visited and the pages to visit.
	private Set<String> pagesVisited = new HashSet<String>();
	private List<String> pagesToVisit = new LinkedList<String>();
	// Extra Array List structure, to store each page visited.
	private List<String> pagesQueued = new ArrayList<String>();

	// Method for "next URL".
	private String nextUrl() {
		String nextUrl;
		// Do-while loop construct here.
		do {
			nextUrl = this.pagesToVisit.remove(0);
		} while (this.pagesVisited.contains(nextUrl));

		this.pagesVisited.add(nextUrl);
		this.pagesQueued.add(nextUrl.toString());
		return nextUrl;
	}

	// Method for searching the URL string.
	public boolean search(String url, String searchWord) {
		if (url == "" || searchWord == "") {
			// Cannot search the URL string if string is empty.
			return false;
		}
		// Search up to all of pages available.
		while (this.pagesVisited.size() < MAX_PAGES_TO_SEARCH) {
			String currentUrl;
			// New Spider Leg object here.
			SpiderLeg leg = new SpiderLeg();
			// Debug statement is here.
			System.out.println(leg.toString());
			if (this.pagesToVisit.isEmpty()) {
				// Case #1: no more pages to visit, end crawler server.
				currentUrl = url;
				System.out.println("No more pages to visit!");
				this.pagesVisited.add(url);
			} else {
				currentUrl = this.nextUrl();
				pagesQueued.add(currentUrl);
			}

			leg.crawl(currentUrl);
			// Boolean to determine if search for word function works
			boolean success = leg.searchForWord(searchWord);
			// Successful case:
			if (success) {
				System.out.println(String.format("Word %s found at %s", searchWord, currentUrl));
				break;
			} else {
				System.out.printf("Cannot find the word %s", searchWord);
			}
			this.pagesToVisit.addAll(leg.getLinks());
		}
		System.out.println("Web Crawler completed search.");
		return true;
	}

}
