package selenium;

import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

// JSOUP imports here.
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* Algos in 10 
 * Season 2 Episode 10 
 * Selenium Java Crawler for NP-Complete Apriori. 
 * 
 *  Spider web crawler 'leg' to help with web crawler with Java Selenium. 
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
 * 
 * Source: http://www.netinstructions.com/how-to-make-a-simple-web-crawler-in-java/
 *  */

/* JSoup source: https://medium.com/@andrewtschwartz/how-to-use-jsoup-to-scrape-webpages-tutorial-d0a676661b4a */

public class SpiderLeg implements ISpiderLeg {

	// Private classes to get HTTP code.
	private List<String> links = new LinkedList<String>();

	// Count number of links crawled.
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	private List<Integer> numberLinks = new ArrayList<Integer>();
	private Document htmlDocument;
	private List<String> queuedLinks = new ArrayList<String>();

	@Override
	public boolean crawl(String url) {
		// Crawl method.
		try {

			// Add in connection for HTTP Requests.
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			Document htmlDocument = connection.get();
			this.htmlDocument = htmlDocument;

			// Successful result.
			if (connection.response().statusCode() == 200) {
				System.out.println("Received web page at " + url);
			}

			// Not successful result.
			if (!connection.response().contentType().contains("text/html")) {
				System.out.println("Retrieved something other than HTML");
				return false;
			}

			Elements linksOnPage = htmlDocument.select("a[href]");
			System.out.println("Found (" + linksOnPage.size() + ") links");

			// Go thru each element for the crawler.
			for (Element link : linksOnPage) {
				this.links.add(link.absUrl("href"));
				// Increase link counter by 1. 
				this.numberLinks.add(1);
				this.queuedLinks.add(link.toString());
			}
			return true;

		} catch (IOException except) {
			// Not successful.
			System.out.println("Error in HTTP Request: " + except);
			return false;
		}
	}

	// Performs a search for a particular word in the crawler.
	@Override
	public boolean searchForWord(String word) {
		if (word == "") {
			System.out.println("Cannot search empty word!");
		}

		if (this.htmlDocument == null) {
			System.out.println("ERROR! Call crawl() before performing analysis on the document");
			return false;
		}
		System.out.println("Searching for the word " + word + "...");
		String bodyText = this.htmlDocument.body().text();
		return bodyText.toLowerCase().contains(word.toLowerCase());
	}

	@Override
	public List<String> getLinks() {
		// Return the number of links.
		System.out.println("Number of links: " + numberLinks.size());
		return this.links;
	}

	@Override
	public List<String> getAllQueued() {
		// TODO Auto-generated method stub
		return this.queuedLinks;
	}

}
