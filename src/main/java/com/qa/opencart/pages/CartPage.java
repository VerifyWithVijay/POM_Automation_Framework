package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CartPage {
	
	private static int totalItems = 10;
	private static final Logger log = LogManager.getLogger(CartPage.class);
	
	public void validateCartFeature()
	{
		log.info("Verify the Cart Page Items");
	}

}
