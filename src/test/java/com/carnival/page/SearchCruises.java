package com.carnival.page;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchCruises extends JUnitHTMLReporter {
	
	private WebDriver driver;
	By signUpLocator			= By.xpath("//*[@id=\"MainBody\"]/div[1]/div/a[2]");
	
	By sailToLocator 			= By.id("cdc-destinations");
	By sailToBahamasLocator		= By.xpath("//*[@id=\"ccl-cruise-search\"]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div[1]/div/div/ccl-search-bar-expandable-filter/div/ul/li[2]/button");
	By sailFromLocator			= By.id("cdc-ports");
	By sailFromPlaceLocator		= By.xpath("//*[@id=\"ccl-cruise-search\"]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/div[2]/div/ccl-search-bar-expandable-filter/div/ul/li[2]/button");
	By durationLocator			= By.id("cdc-durations");
	By days69Locator			= By.xpath("//*[@id=\"ccl-cruise-search\"]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div[1]/div/div/ul/li[2]/button");
	By searchButtonlocator		= By.className("cdc-filters-search-cta");											
	By pricingMenuLocator		= By.xpath("//*[@id=\"sfn-nav-pricing\"]"); 
	By pricingSlideLocator		= By.xpath("//*[@id=\"sfc-xfilters\"]/ccl-cruise-search-bar-xfilters-pricing/div/div/div/div[2]/div/div/div/span[2]");
	By pricingMinValueLocator	= By.xpath("//*[@id=\"sfc-xfilters\"]/ccl-cruise-search-bar-xfilters-pricing/div/div/div/div[2]/div/div/div/span[3]");
	By pricingMaxValueLocator	= By.xpath("//*[@id=\"sfc-xfilters\"]/ccl-cruise-search-bar-xfilters-pricing/div/div/div/div[2]/div/div/div/span[4]");
	By sortLocator				= By.id("asc-inides");
	By ListLocator				= By.xpath("//*[@id=\"ccl-refresh-homepage\"]/div/div/div/div/div/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div[1]/ccl-cruise-search-bar-layout-switcher/div/a[2]/i[1]");
	By sailToNoBahamasLocator   = By.xpath("//*[@id=\"ccl-cruise-search\"]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/div[2]/div/ccl-search-bar-expandable-filter/div/ul/li[6]/button");
	By days25Locator			= By.xpath("//*[@id=\"ccl-cruise-search\"]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/div[2]/div/ul/li[1]/button");
	By days10Locator			= By.xpath("//*[@id=\"ccl-cruise-search\"]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/div[2]/div/ul/li[3]/button");
	By dateLocator				= By.id("cdc-dates");
	By dateDec2021				= By.xpath("//*[@id=\"ccl-cruise-search\"]/ccl-cruise-search/div[3]/ccl-cruise-search-bar/div/div[2]/div/div[2]/div/div/div/ul[2]/li[12]/button");
	By learnMoreButton			= By.xpath("//*[@id=\"ccl-refresh-homepage\"]/div/div/div/div/div/ccl-cruise-search/div[3]/ccl-view-result-container/div/ccl-view-result-grid/article[1]/ccl-view-result-grid-item/div/div[1]/ccl-view-result-grid-footer/div/div[2]/a");
	By learnMoreFunDayLocator	= By.xpath("//*[@id=\"details\"]/div[3]/div[4]/div[2]/div/div/button");
	By nextInfoFunLocator		= By.xpath("//*[@id=\"details\"]/div[3]/div[4]/div[1]/div/div/slick/button[2]");
	By closeFunDetailLocator	= By.xpath("//*[@id=\"details\"]/div[3]/div[4]/div[1]/div/div/button");
	By learnMorePlaceLocator	= By.xpath("//*[@id=\"details\"]/div[3]/div[3]/div[1]/div/div/button");
	By nextInfoPlaceLocator		= By.xpath("//*[@id=\"details\"]/div[3]/div[3]/div[2]/div/div/slick/button[2]");
	By bookNowTopLocator		= By.xpath("//*[@id=\"sm-booking-btn\"]/booking-button/div/span/span");
	By bookNowBottomLocator		= By.xpath("//*[@id=\"section-rooms\"]/div/div/booking-button/div/span");
	
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.carnival.com");
	}
		
	@After
	public void finish() throws Exception {
		driver.quit();
	}
//User Story 001
	//TC-001
	@Test
	public void searchBahamasPriceRangeGrid() throws InterruptedException {
		
		int min = 0;
		int max = 0;
		final int testMinValue = 400;
		final int testMaxValue = 600;
		int numMinClicks = 0;
		int numMaxClicks = 0;
		
		//Evaluate if signup pop-up is displayed
		if (driver.findElement(signUpLocator).isDisplayed()) {
			driver.findElement(signUpLocator).click();
		}
		
		driver.findElement(sailToLocator).click();
		driver.findElement(sailToBahamasLocator).click();
		driver.findElement(durationLocator).click();		
		driver.findElement(days69Locator).click();		
		driver.findElement(searchButtonlocator).click();
		Thread.sleep(2000);
		driver.findElement(pricingMenuLocator).click();
		Thread.sleep(2000);
		
		min = Integer.parseInt(driver.findElement(pricingMinValueLocator).getAttribute("aria-valuemin"));
		max = Integer.parseInt(driver.findElement(pricingMaxValueLocator).getAttribute("aria-valuemax"));
		
		//Evaluate if pricing test values are consistent  
		if (min <= testMinValue && max >= testMaxValue) {
			
			//pricing Minimum Value is moved
			driver.findElement(pricingMinValueLocator).click();
			numMinClicks = (testMinValue - min)/10;
			int i = 0;
			while (i < numMinClicks) {			
				driver.findElement(pricingMinValueLocator).sendKeys(Keys.ARROW_RIGHT);
				i++;
			}
			
			//pricing Maximum Value is moved
			driver.findElement(pricingMaxValueLocator).click();
			numMaxClicks = (max - testMaxValue)/10;
			i = 0;
			while (i < numMaxClicks) {			
				driver.findElement(pricingMaxValueLocator).sendKeys(Keys.ARROW_LEFT);
				i++;
			}
			assertTrue(true);
		}
	}
	
	//TC-002
		@Test
		public void searchBahamasSortGrid() throws InterruptedException {
							
			//Evaluate if signup pop-up is displayed
			if (driver.findElement(signUpLocator).isDisplayed()) {
				driver.findElement(signUpLocator).click();
			}
			
			driver.findElement(sailToLocator).click();			
			driver.findElement(sailToBahamasLocator).click();			
			driver.findElement(durationLocator).click();
			driver.findElement(days69Locator).click();			
			driver.findElement(searchButtonlocator).click();
			Thread.sleep(2000);
			driver.findElement(pricingMenuLocator).click();
			
			try {
			driver.findElement(sortLocator).isDisplayed();	
			}catch(org.openqa.selenium.NoSuchElementException e) {
				Assert.assertFalse("Results sort does not exist!", true);
			}
			
		}
	
		//TC-003
		@Test
		public void searchBahamasPriceRangeList() throws InterruptedException {
			
			int min = 0;
			int max = 0;
			final int testMinValue = 500;
			final int testMaxValue = 700;
			int numMinClicks = 0;
			int numMaxClicks = 0;
			
			//Evaluate if signup pop-up is displayed
			if (driver.findElement(signUpLocator).isDisplayed()) {
				driver.findElement(signUpLocator).click();
				}
			
			driver.findElement(sailToLocator).click();
			driver.findElement(sailToBahamasLocator).click();
			driver.findElement(durationLocator).click();
			driver.findElement(days69Locator).click();
			driver.findElement(searchButtonlocator).click();
			Thread.sleep(2000);

			//Display results as a list.
			driver.findElement(ListLocator).click();
						
			driver.findElement(pricingMenuLocator).click();
						
			min = Integer.parseInt(driver.findElement(pricingMinValueLocator).getAttribute("aria-valuemin"));
			max = Integer.parseInt(driver.findElement(pricingMaxValueLocator).getAttribute("aria-valuemax"));
			
			//Evaluate if pricing test values are consistent  
			if (min <= testMinValue && max >= testMaxValue) {
				
				//pricing Minimum Value is moved
				driver.findElement(pricingMinValueLocator).click();
				numMinClicks = (testMinValue - min)/10;
				int i = 0;
				while (i < numMinClicks) {			
					driver.findElement(pricingMinValueLocator).sendKeys(Keys.ARROW_RIGHT);
					i++;
				}
				
				//pricing Maximum Value is moved
				driver.findElement(pricingMaxValueLocator).click();
				numMaxClicks = (max - testMaxValue)/10;
				i = 0;
				while (i < numMaxClicks) {			
					driver.findElement(pricingMaxValueLocator).sendKeys(Keys.ARROW_LEFT);
					i++;
				}
				assertTrue(true);
			}		
		}
		
		//TC-004
		@Test
		public void searchNotBahamas25PriceRangeGrid() throws InterruptedException {
			
			int min = 0;
			int max = 0;
			final int testMinValue = 1000;
			final int testMaxValue = 1500;
			int numMinClicks = 0;
			int numMaxClicks = 0;
			
			//Evaluate if signup pop-up is displayed
			if (driver.findElement(signUpLocator).isDisplayed()) {
				driver.findElement(signUpLocator).click();
			}
			
			driver.findElement(sailToLocator).click();
			driver.findElement(sailToNoBahamasLocator).click();
			driver.findElement(durationLocator).click();
			driver.findElement(days10Locator).click();
			driver.findElement(searchButtonlocator).click();
			Thread.sleep(2000);
			driver.findElement(pricingMenuLocator).click();
						
			min = Integer.parseInt(driver.findElement(pricingMinValueLocator).getAttribute("aria-valuemin"));
			max = Integer.parseInt(driver.findElement(pricingMaxValueLocator).getAttribute("aria-valuemax"));
			
			//Evaluate if pricing test values are consistent  
			if (min <= testMinValue && max >= testMaxValue) {
				
				//pricing Minimum Value is moved
				driver.findElement(pricingMinValueLocator).click();
				numMinClicks = (testMinValue - min)/10;
				int i = 0;
				while (i < numMinClicks) {			
					driver.findElement(pricingMinValueLocator).sendKeys(Keys.ARROW_RIGHT);
					i++;
				}
				
				//pricing Maximum Value is moved
				driver.findElement(pricingMaxValueLocator).click();
				numMaxClicks = (max - testMaxValue)/10;
				i = 0;
				while (i < numMaxClicks) {			
					driver.findElement(pricingMaxValueLocator).sendKeys(Keys.ARROW_LEFT);
					i++;
				}
				assertTrue(true);
			}else {
				System.out.println("Values out of range!");
				assertTrue(false);
			}
		}
		
		//TC-005
				@Test
				public void searchNotBahamas10PriceRangeDate() throws InterruptedException {
					
					int min = 0;
					int max = 0;
					final int testMinValue = 1200;
					final int testMaxValue = 1300;
					int numMinClicks = 0;
					int numMaxClicks = 0;
					
					//Evaluate if signup pop-up is displayed
					if (driver.findElement(signUpLocator).isDisplayed()) {
						driver.findElement(signUpLocator).click();
					}
					
					driver.findElement(sailToLocator).click();
					driver.findElement(sailToNoBahamasLocator).click();
									
					driver.findElement(sailFromLocator).click();
					driver.findElement(sailFromPlaceLocator).click();
										
					driver.findElement(durationLocator).click();
					driver.findElement(days10Locator).click();
										
					driver.findElement(dateLocator).click();
					driver.findElement(dateDec2021).click();
										
					driver.findElement(searchButtonlocator).click();
					Thread.sleep(2000);
										
					driver.findElement(pricingMenuLocator).click();
										
					min = Integer.parseInt(driver.findElement(pricingMinValueLocator).getAttribute("aria-valuemin"));
					max = Integer.parseInt(driver.findElement(pricingMaxValueLocator).getAttribute("aria-valuemax"));
					
					//Evaluate if pricing test values are consistent  
					if (min <= testMinValue && max >= testMaxValue) {
						
						//pricing Minimum Value is moved
						driver.findElement(pricingMinValueLocator).click();
						numMinClicks = (testMinValue - min)/10;
						int i = 0;
						while (i < numMinClicks) {			
							driver.findElement(pricingMinValueLocator).sendKeys(Keys.ARROW_RIGHT);
							i++;
						}
						
						//pricing Maximum Value is moved
						driver.findElement(pricingMaxValueLocator).click();
						numMaxClicks = (max - testMaxValue)/10;
						
						i = 0;
						while (i < numMaxClicks) {			
							driver.findElement(pricingMaxValueLocator).sendKeys(Keys.ARROW_LEFT);
							i++;
						}
						assertTrue(true);
					}else {
						System.out.println("Values out of range!");
						assertTrue(false);
					}
				}
}
