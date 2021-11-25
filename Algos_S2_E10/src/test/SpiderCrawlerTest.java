package test;

import selenium.SpiderCrawler;
import selenium.SpiderLeg;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;


/* Algos in 10 
 * Season 2 Episode 10 
 * Selenium Java Crawler for NP-Complete Apriori. 
 * 
 *  Web Crawler Unit Test. 
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

/* JUnit assertion for tests source: 
 * https://www.tutorialspoint.com/junit/junit_using_assertion.htm
 */

/* 
 * Adding JUnit to Eclipse: 
 * https://www.toddlahman.com/import-org-junit-cannot-resolved-eclipse/
 * */

public class SpiderCrawlerTest {
	
	/* 
	 * Unit Test Class: Barebones, just for demo reasons. A much more involved unit test would cover all cases. 
	 * */
	
		
		@Test
		public void testEmptyCrawler() {
			SpiderCrawler spider1 = new SpiderCrawler();
			assertFalse(spider1.search("","whatever"));
		}
		
		@Test
		public void testBasicCrawler() {
			SpiderCrawler spider2 = new SpiderCrawler();
			assertTrue(spider2.search("LeBron James","www.espn.com"));
		}
		
		@Test
		public void testNumberBasicCrawler() {
			SpiderCrawler spider3 = new SpiderCrawler();
			SpiderLeg spiderleg1 = new SpiderLeg();
			assertFalse(spider3.search("2048","https://www.wikipedia.com"));
			assertTrue(spiderleg1.crawl("https://www.espn.com"));
		}
		
		@Test
		public void testHashtagBasicCrawler() {
			SpiderCrawler spider4 = new SpiderCrawler();
			SpiderLeg spiderleg2 = new SpiderLeg();
			assertTrue(spider4.search("#","https://www.twitter.com"));
			spiderleg2.crawl("https://www.google.com");
			assertFalse(spiderleg2.crawl("https://www.fakewebsite.com"));
			assertTrue(spiderleg2.getLinks().contains("https://www.google.com"));
		}
}
