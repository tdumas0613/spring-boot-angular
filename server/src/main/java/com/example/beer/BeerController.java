package com.example.beer;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {
	
	@Autowired
	private BeerUtility beerUtility;
	
	@GetMapping("/good-beers")
	public Collection<Map<String, String>> retrieve() {
		return beerUtility.findGoodBeers();
	}
}
